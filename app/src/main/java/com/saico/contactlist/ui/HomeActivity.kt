package com.saico.contactlist.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saico.contactlist.data.model.Person
import com.saico.contactlist.databinding.ActivityHomeBinding
import com.saico.contactlist.ui.adapter.ContactsAdapter
import com.saico.contactlist.presenter.HomePresenter
import com.saico.contactlist.ui.view.HomeContract

class HomeActivity : AppCompatActivity(), HomeContract.View {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var contactListRecyclerView: RecyclerView

    private lateinit var homePresenter: HomeContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        homePresenter = HomePresenter(this)
        homePresenter.getContacts()
    }

    override fun showLoader() {
        binding.spHome.visibility = View.VISIBLE
    }

    override fun hideLoader() {
        binding.spHome.visibility = View.GONE
    }

    override fun showContacts(contactList: ArrayList<Person>) {
        contactListRecyclerView = binding.contactsList
        contactListRecyclerView.layoutManager = LinearLayoutManager(this)
        val contactsAdapter = ContactsAdapter(contactList)
        contactListRecyclerView.adapter = contactsAdapter
    }

    override fun showEmptyContacts() {
        binding.contactsList.visibility = View.GONE
        binding.clEmptyContacts.visibility = View.VISIBLE
    }
}