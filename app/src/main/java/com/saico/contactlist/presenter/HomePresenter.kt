package com.saico.contactlist.presenter

import android.os.Handler
import android.os.Looper
import com.saico.contactlist.data.PersonRepository
import com.saico.contactlist.data.model.Person
import com.saico.contactlist.ui.view.HomeContract


class HomePresenter(private val view:HomeContract.View) : HomeContract.Presenter {

    private val personRepository = PersonRepository()

    override fun getContacts() {
        view.showLoader()
        Handler(Looper.getMainLooper()).postDelayed({
            personRepository.getContactList(object: HomeContract.OnResponseCallBack {
                override fun onResponse(personsList: ArrayList<Person>) {
                    validateContacts(personsList)
                }
            })
        }, 3000)
    }

    fun validateContacts(personsList: ArrayList<Person>) {
        view.hideLoader()
        if (personsList.isEmpty()) {
            view.showEmptyContacts()
        } else {
            view.showContacts(personsList)
        }
    }
}