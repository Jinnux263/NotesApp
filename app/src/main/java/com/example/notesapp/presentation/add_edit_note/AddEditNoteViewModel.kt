package com.example.notesapp.presentation.add_edit_note

import android.app.Application
import androidx.lifecycle.ViewModel
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.use_cases.NoteUseCases

class AddEditNoteViewModel (
    app : Application
) : ViewModel() {
    //Thiet lap noteUseCase
    private val notesUseCase: NoteUseCases = NoteUseCases.provideNoteUseCase(app)


}