package com.saico.contactlist.data

import com.saico.contactlist.data.model.Person
import com.saico.contactlist.ui.view.HomeContract

class PersonRepository{
    fun getContactList(responseCallBack: HomeContract.OnResponseCallBack) {
        val persons = ArrayList<Person> ()
        persons.add(Person(100, "Juan Perez", "jperez@gmail.com", "ic_profile"))
        persons.add(Person(200, "Miguel Chavez", "mchavez@gmail.com", "ic_profile"))
        persons.add(Person(300, "Martha Prado", "mprado@gmail.com", "ic_profile"))
        persons.add(Person(400, "Jaime Farfan", "jfarfan@gmail.com", "ic_profile"))
        persons.add(Person(500, "Luiz Maza", "lmaza@gmail.com", "ic_profile"))
        persons.add(Person(600, "Juan Perez", "jperez@gmail.com", "ic_profile"))
        persons.add(Person(700, "Miguel Chavez", "mchavez@gmail.com", "ic_profile"))
        persons.add(Person(800, "Martha Prado", "mprado@gmail.com", "ic_profile"))
        persons.add(Person(900, "Jaime Farfan", "jfarfan@gmail.com", "ic_profile"))
        persons.add(Person(1000, "Luiz Maza", "lmaza@gmail.com", "ic_profile"))
        responseCallBack.onResponse(persons)
    }
}