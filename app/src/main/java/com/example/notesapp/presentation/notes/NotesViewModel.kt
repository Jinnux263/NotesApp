package com.example.notesapp.presentation.notes

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.use_cases.*
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class NotesViewModel(
    app : Application
) : ViewModel() {
    //Thiet lap noteUseCase
    private val notesUseCases:  NoteUseCases = NoteUseCases.provideNoteUseCase(app)
    val noteList: LiveData<List<Note>> = notesUseCases.getNotes().asLiveData()

//    private var recentlyDeletedNote: Note? = null
//
//    private var getNotesJob: Job? = null
//
//    fun deleteNote(note: Note) = viewModelScope.launch {
//        notesUseCases.deleteNote(note)
//        recentlyDeletedNote = note
//    }
//
//    fun restoreNote(id: Int) = viewModelScope.launch {
//            notesUseCases.addNote(recentlyDeletedNote ?: return@launch)
//            recentlyDeletedNote = null
//    }

}