package com.adrpien.roomdatabaseapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


// You can not create an instance of database, use builder instead
@Database(entities = [Person::class], version = 1, exportSchema = false)
abstract class PeopleDatabase: RoomDatabase() {

    abstract fun peopleDao(): PeopleDAO

    companion object {

        private var instance: PeopleDatabase? = null


        // fallbackToDestructiveMigration - Room can can destroy and recreate database if migration is not possible
        // Create database singleton
        fun getInstance(context: Context): PeopleDatabase?{
            if(instance == null){
                // Create database
                instance = Room.databaseBuilder(context, PeopleDatabase::class.java,"people_table")
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }

        fun deleteDatabaseInstace(){
            instance = null
        }
    }
}