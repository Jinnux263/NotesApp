package com.example.notesapp.data.repository

import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.data_source.NoteDao
import com.example.notesapp.data.data_source.NoteDatabase
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl (
    private val noteDao: NoteDao
) : NoteRepository{
    override fun getNotes(): Flow<List<Note>> {
        return noteDao.getNotes()
    }

    override suspend fun getNoteById(id: Int): Note? {
        return noteDao.getNoteById(id)
    }

    override suspend fun insertNote(note: Note) {
        noteDao.insertNote(note)
    }

    override suspend fun deleteNote(note: Note) {
        noteDao.deleteNote(note)
    }

    companion object {
        private var noteRepositoryImpl : NoteRepositoryImpl? = null
        fun provideNoteRepositoryImpl(noteDao: NoteDao): NoteRepositoryImpl {
            if (noteRepositoryImpl == null) {
                noteRepositoryImpl = NoteRepositoryImpl(noteDao)
            }
            return noteRepositoryImpl!!
        }
    }
}