package com.saico.contactlist.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saico.contactlist.data.model.Person
import com.saico.contactlist.databinding.ActivityHomeBinding
import com.saico.contactlist.ui.adapter.ContactsAdapter
import com.saico.contactlist.viewmodel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private lateinit var contactListRecyclerView: RecyclerView

    private lateinit var mainViewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainViewModel = HomeViewModel()
        mainViewModel.onCreate()

        mainViewModel.isLoading.observe(this) {
            binding.spHome.isVisible = it
        }

        mainViewModel.contactList.observe(this) {
            showContacts(it)
        }

        mainViewModel.isEmptyContactList.observe(this) {
            binding.clEmptyContacts.isVisible = it
        }
    }

    private fun showContacts(contactList: ArrayList<Person>) {
        contactListRecyclerView = binding.contactsList
        contactListRecyclerView.layoutManager = LinearLayoutManager(this)
        val contactsAdapter = ContactsAdapter(contactList)
        contactListRecyclerView.adapter = contactsAdapter
    }
}