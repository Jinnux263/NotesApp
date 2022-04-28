package com.example.notesapp.presentation.notes

import androidx.lifecycle.*
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.use_cases.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class NotesViewModel(
    private val notesUseCases:  NoteUseCases
) : ViewModel() {
    val noteList: LiveData<List<Note>> = notesUseCases.getNotes().asLiveData()

    private var recentlyDeletedNote: Note? = null

    private var getNotesJob: Job? = null

    fun deleteNote(note: Note) = viewModelScope.launch {
        notesUseCases.deleteNote(note)
        recentlyDeletedNote = note
    }

    fun restoreNote(id: Int) = viewModelScope.launch {
            notesUseCases.addNote(recentlyDeletedNote ?: return@launch)
            recentlyDeletedNote = null
    }

}