package com.example.notesapp.data.data_source

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.domain.model.Note


@Database(
    entities = [Note::class],
    version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun useNoteDao() : NoteDao

    companion object {
        private const val DATABASE_NAME = "note_database"
        private var noteDatabase : NoteDatabase? = null

        fun provideNoteDatabase(context : Context) : NoteDatabase{
            if (noteDatabase == null) {
                noteDatabase = Room.databaseBuilder(context, NoteDatabase::class.java, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return noteDatabase as NoteDatabase
        }

    }



}