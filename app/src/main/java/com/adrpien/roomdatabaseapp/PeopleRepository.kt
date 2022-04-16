package com.adrpien.roomdatabaseapp

import android.app.Application
import androidx.lifecycle.LiveData
import kotlinx.coroutines.*

class PeopleRepository (application: Application) {

    private lateinit var peopleDAO: PeopleDAO


    init {
        val peopleDatabase = PeopleDatabase.getInstance(application.applicationContext)
        peopleDAO = peopleDatabase!!.peopleDao()
    }

    fun insert(person: Person) =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDAO.insert(person)
        }

    fun update(person: Person) =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDAO.update(person) }


    fun delete(person: Person) =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDAO.delete(person)
        }

    fun deleteAll() =
        CoroutineScope(Dispatchers.IO).launch {
            peopleDAO.deleteAll()
        }

    fun getAll(): Deferred<LiveData<List<Person>>> =
        CoroutineScope(Dispatchers.IO).async {
            peopleDAO.getAll()
        }
}