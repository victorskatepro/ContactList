package com.saico.contactlist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saico.contactlist.PersonRepository
import com.saico.contactlist.adapter.ContactsAdapter
import com.saico.contactlist.databinding.ActivityHomeBinding
import com.saico.contactlist.model.Person

class HomeActivity : AppCompatActivity() {

    //activityMainBinding
    private lateinit var binding: ActivityHomeBinding

    private lateinit var contactListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        getContactList()
    }

    private fun getContactList() {
        val persons = PersonRepository()
        validateContactList(persons.persons)
    }

    private fun showRecyclerView(listContact: List<Person>) {
        contactListRecyclerView = binding.contactsList
        contactListRecyclerView.layoutManager = LinearLayoutManager(this)
        val contactsAdapter = ContactsAdapter(listContact)
        contactListRecyclerView.adapter = contactsAdapter
    }

    private fun validateContactList(listContact: List<Person>) {
        binding.pbHome.visibility = View.GONE
        if (listContact.isEmpty()) {
            binding.clEmptyList.visibility = View.VISIBLE
        } else {
            showRecyclerView(listContact)
        }
    }
}