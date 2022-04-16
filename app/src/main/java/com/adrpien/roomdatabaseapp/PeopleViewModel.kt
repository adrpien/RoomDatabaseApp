package com.adrpien.roomdatabaseapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.runBlocking

class PeopleViewModel(application: Application): AndroidViewModel(application) {

    private var peopleRepository = PeopleRepository(application)
    private var allPeople: Deferred<LiveData<List<Person>>> = peopleRepository.getAll()

    fun insert(person: Person){
        peopleRepository.insert(person)
    }

    fun update(person: Person){
        peopleRepository.update(person)
    }

    fun delete(person: Person){
        peopleRepository.delete(person)
    }

    fun deleteAll(){
        peopleRepository.deleteAll()
    }

    fun getAll(): LiveData<List<Person>> = runBlocking {
        allPeople.await()
    }

}