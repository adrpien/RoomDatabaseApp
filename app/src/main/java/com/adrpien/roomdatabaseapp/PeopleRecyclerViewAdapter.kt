package com.adrpien.roomdatabaseapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeopleRecyclerViewAdapter(private val listOfPeople: List<Person>): RecyclerView.Adapter<AdapterViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val row = layoutInflater.inflate(R.layout.list_row, parent, false )
        return AdapterViewHolder(row)
    }

    override fun onBindViewHolder(holder: AdapterViewHolder, position: Int) {
        holder.idTextView.text = listOfPeople[position].id
        holder.nameTextView.text = listOfPeople[position].name
        holder.surnameTextView.text = listOfPeople[position].surname
    }

    override fun getItemCount(): Int {
    return listOfPeople.size
    }

}

class AdapterViewHolder(val view: View): RecyclerView.ViewHolder(view){
    val nameTextView = view.findViewById<TextView>(R.id.nameTextView)
    val surnameTextView = view.findViewById<TextView>(R.id.surnameTextView)
    val idTextView = view.findViewById<TextView>(R.id.idTextView)
}
