package com.adrpien.roomdatabaseapp

import androidx.lifecycle.LiveData
import androidx.room.*

/*
    Dao interface  provides some specific data operations without exposing details of the database
    Dao interface defines an abstract API that performs CRUD operations on database elements
    The class marked with @Dao should either be an interface or an abstract class. At compile time,
    Room will generate an implementation of this class when it is referenced by a Database.
    It is recommended to have multiple Dao classes in your codebase depending on the tables they touch.
 */

@Dao
interface PeopleDAO {

    @Insert
    fun insert(person: Person)

    @Delete
    fun delete(person: Person)

    @Update
    fun update(person: Person)


    //LivaData is return value
    @Query("SELECT * FROM people_table")
    fun getAll() : LiveData<List<Person>>

    @Query("DELETE FROM people_table")
    fun deleteAll()
}