package com.adrpien.roomdatabaseapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.adrpien.roomdatabaseapp.room.Person
import com.adrpien.roomdatabaseapp.room.PeopleRepository
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


    // await is suspended functions so that we have to use runBlocking
    fun getAll(): LiveData<List<Person>> = runBlocking {
        allPeople.await()
    }

}