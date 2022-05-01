package com.adrpien.roomdatabaseapp.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.adrpien.roomdatabaseapp.viewmodels.PeopleViewModel
import com.adrpien.roomdatabaseapp.room.Person
import com.adrpien.roomdatabaseapp.databinding.ActivityMainBinding

/*

CardView - Apps often need to display data in similarly styled containers.
These containers are often used in lists to hold each item's information.
The system provides the CardView API as an easy way for you to show
information inside cards that have a consistent look across the platform.
These cards have a default elevation above their containing view group, so the system draws shadows below them.
Cards provide an easy way to contain a group of views while providing a consistent style for the container.

DAO - The Data Access Object is basically an object or an interface
that provides access to an underlying database or any other persistence storage.
The concept is to "separate a data resource's client interface from its data access mechanism." ???
Dao interface  provides some specific data operations without exposing details of the database

Repository class is hub class, which can resolve conflicts between data sources
(such as persistent models, web services, and caches) and centralize changes to this data.


Aplikacja:
1. Add depencies in build.gradle and apply plugin
2. Create RecyclerView list row using Cardview
3. Create data class person and annotate it as @Entity
   (Class person in entity model for table database)
   - sign at least one field as primary key
4. Create PeopleDao interface.
   - annotate interface as @Dao
   - annotate functions aproppriate to their function
5. Create abstract class inheriting RoomDatabase
   - annotate class as @Database and add entities, version and exportSchema
   - create abstract function returning interface DAO
   - create getInstance function which creates singleton of database,
     use databaseBuilder to create database
   - create deleteInstanceDatabase function
6. Using MVVM architecture its required to create repository class
   - create var peopleDAO with PeopleDEO Interface
   - create instance of databa base in init block
   - use this instance to set peopleDAO var as reference to PeopleDEO interface instance
   - create in repository class funtions from PeopleDAO interface
7. Create ViewModel class inheriting AndroidViewModel:
   - Create instance of repository class
   - create var storing all people
   - create the same functions was creates repository class
8. Create RecyclerView Adapter
9. Create ListActivity
   - create ViewModel instance
 */

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: PeopleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Create ViewModel
        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewModel::class.java)

        binding.insertButton.setOnClickListener {

            val name = binding.nameEditText.text.toString()
            val surname = binding.surnameEditText.text.toString()
            val id = binding.idEditText.text.toString()

            val person = Person(name, surname, id)

            viewModel.insert(person)
        }

        binding.deleteButton.setOnClickListener{
            viewModel.deleteAll()
        }

        binding.showListButton.setOnClickListener {
            val intent = Intent(applicationContext, ListActivity::class.java)
            startActivity(intent)
        }
    }
}