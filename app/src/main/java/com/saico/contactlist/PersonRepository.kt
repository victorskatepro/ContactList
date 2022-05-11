package com.saico.contactlist

import com.saico.contactlist.model.Person

class PersonRepository (val persons:MutableList<Person> = ArrayList()){

    init {
        setDataPersons()
    }

    private fun setDataPersons(): List<Person> {
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
        return persons
    }
}