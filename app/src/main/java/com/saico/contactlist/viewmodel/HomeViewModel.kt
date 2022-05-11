package com.saico.contactlist.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.saico.contactlist.data.PersonRepository
import com.saico.contactlist.data.model.Person

class HomeViewModel: ViewModel() {

    val contactList = MutableLiveData<ArrayList<Person>>()
    val isLoading = MutableLiveData<Boolean>()
    val isEmptyContactList = MutableLiveData<Boolean>()
    val personRepository = PersonRepository()

    fun onCreate() {
        isLoading.postValue(true)
        Handler(Looper.getMainLooper()).postDelayed({
            validateEmptyContactList(personRepository.getContactList())
        }, 3000)
    }

    private fun validateEmptyContactList(listContact: ArrayList<Person>) {
        isLoading.postValue(false)
        if (listContact.isEmpty()) {
            isEmptyContactList.postValue(true)
        } else {
            contactList.postValue(listContact)
        }
    }
}