package com.example.noteappcleanarchitecture.feature_note.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.noteappcleanarchitecture.feature_note.domain.model.Note

@Database(
    entities = [Note::class],
    version = 1
)

abstract class NoteDatabase:RoomDatabase() {

    abstract val noteDao: NoteDao


    companion object {

        const val DATABASE_NAME = "notes_db"

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getInstance(context: Context): NoteDatabase {
            val userInstance = INSTANCE
            if (userInstance != null) {
                return userInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    DATABASE_NAME
                ).allowMainThreadQueries().build()

                INSTANCE = instance
                return instance
            }
        }
    }

}