package com.saico.contactlist.ui.view

import com.saico.contactlist.data.model.Person


interface HomeContract  {

    interface View {
        fun showLoader()
        fun hideLoader()
        fun showContacts(contactList: ArrayList<Person>)
        fun showEmptyContacts()
    }

    interface Presenter {
        fun getContacts()
    }

    interface OnResponseCallBack {
        fun onResponse(personsList: ArrayList<Person>)
    }

}