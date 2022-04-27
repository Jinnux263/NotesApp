package com.example.notesapp.domain.use_cases

data class NoteUseCases(
    val getNotes : GetNotes,
    val getNote: GetNote,
    val addNote: AddNote,
    val deleteNote: DeleteNote,
)

