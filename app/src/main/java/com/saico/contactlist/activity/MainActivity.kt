package com.saico.contactlist.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.saico.contactlist.PersonRepository
import com.saico.contactlist.adapter.ContactsAdapter
import com.saico.contactlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //activityMainBinding
    private lateinit var binding: ActivityMainBinding

    private lateinit var contactListRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setRecyclerView()
    }

    private fun setRecyclerView() {
        contactListRecyclerView = binding.contactsList
        contactListRecyclerView.layoutManager = LinearLayoutManager(this)
        val persons = PersonRepository()
        val contactsAdapter = ContactsAdapter(persons.persons)
        contactListRecyclerView.adapter = contactsAdapter
    }
}