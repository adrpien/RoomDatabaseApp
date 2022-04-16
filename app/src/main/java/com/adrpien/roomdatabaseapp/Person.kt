package com.adrpien.roomdatabaseapp

import androidx.room.Entity
import androidx.room.PrimaryKey

/* @Entity marks a class as an entity. This class will have a mapping SQLite table in the database
   Each entity must have at least 1 field annotated with PrimaryKey.
   You can also use primaryKeys attribute to define the primary key. */

// Class Person is model for our table 'people_table' in our Database
@Entity(tableName = "people_table")
data class Person( val name: String,
                   val surname:String,
                   val id: String) {

    // Setting PrimaryKey
    @PrimaryKey(autoGenerate = true)
    val user_id: Int = 0
}