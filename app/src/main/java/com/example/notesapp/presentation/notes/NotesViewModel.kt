package com.example.notesapp.presentation.notes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.domain.model.Note

class NotesViewModel : ViewModel() {
    val noteList = MutableLiveData<List<Note>>()
}