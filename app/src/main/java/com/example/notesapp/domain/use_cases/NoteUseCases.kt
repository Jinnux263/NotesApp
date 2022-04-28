package com.example.notesapp.domain.use_cases

import android.content.Context
import com.example.notesapp.data.data_source.NoteDatabase
import com.example.notesapp.data.repository.NoteRepositoryImpl

// getNote chua duoc goi tu dau nen moi co mau xam
class NoteUseCases(
    val getNotes : GetNotes,
    val getNote: GetNote,
    val addNote: AddNote,
    val deleteNote: DeleteNote,
) {
    companion object {
        private var notesUseCase:  NoteUseCases? = null

        fun provideNoteUseCase(app: Context): NoteUseCases {
            if (notesUseCase == null){
                val noteDatabase = NoteDatabase.provideNoteDatabase(app)
                val noteRepository = NoteRepositoryImpl.provideNoteRepositoryImpl(noteDatabase.useNoteDao())
                notesUseCase = NoteUseCases(
                    GetNotes(noteRepository),
                    GetNote(noteRepository),
                    AddNote(noteRepository),
                    DeleteNote(noteRepository)
                )
            }
            return notesUseCase!!
        }
    }
}

