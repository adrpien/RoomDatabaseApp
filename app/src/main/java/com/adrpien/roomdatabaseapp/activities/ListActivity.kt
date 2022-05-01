package com.adrpien.roomdatabaseapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.adrpien.roomdatabaseapp.PeopleRecyclerViewAdapter
import com.adrpien.roomdatabaseapp.viewmodels.PeopleViewModel
import com.adrpien.roomdatabaseapp.room.Person
import com.adrpien.roomdatabaseapp.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListBinding

    private lateinit var viewModel: PeopleViewModel
    private lateinit var daoAdapter: PeopleRecyclerViewAdapter
    private lateinit var recyclerViewAdapter: PeopleRecyclerViewAdapter
    private lateinit var listOfPeople: LiveData<List<Person>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider
            .AndroidViewModelFactory
            .getInstance(application)
            .create(PeopleViewModel::class.java)

        binding.peopleRecyclerView.layoutManager = LinearLayoutManager(applicationContext)

        listOfPeople = viewModel.getAll()
        listOfPeople.observe(
            this,
            Observer { t ->
                if(t.isNotEmpty()){
                    daoAdapter = PeopleRecyclerViewAdapter(t)
                    binding.peopleRecyclerView.adapter = daoAdapter
                }
        })
    }
}