package com.example.notesapp.presentation.notes

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.notesapp.R
import com.example.notesapp.data.data_source.NoteDatabase
import com.example.notesapp.data.repository.NoteRepositoryImpl
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.use_cases.*


class NotesActivity : AppCompatActivity() {
//    private var noteList:  ArrayList<Note> = ArrayList()
    private lateinit var noteRecycleView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        initApp()
    }

    // Can chinh sua cho nay, khong phai luc nao cung la insert
    private fun observeData(){
        viewModel.noteList.observe(this, Observer{
            noteAdapter.bind(it)
            noteAdapter.notifyItemInserted(noteAdapter.itemCount - 1)
        })
    }

    private fun initApp(){
        val noteUseCases = NoteUseCases.provideNoteUseCase(applicationContext)
        viewModel = NotesViewModel(noteUseCases)

        noteRecycleView = findViewById(R.id.note_recycle_view)
        noteAdapter = NoteAdapter()
        noteRecycleView.adapter = noteAdapter
        noteRecycleView.layoutManager = LinearLayoutManager(this)

        observeData()

        viewModel.addNote(Note("Title", "This is note 0", 1))
        viewModel.addNote(Note("Title 1", "This is note 1", 2))
        viewModel.addNote(Note("Title 2", "This is note 2", 3))
        viewModel.addNote(Note("Title 3", "This is note 3", 4))
        viewModel.addNote(Note("Title 4", "This is note 4", 5))
        viewModel.addNote(Note("Title 5", "This is note 5", 6))
        viewModel.addNote(Note("Title 6", "This is note 6", 7))
        viewModel.addNote(Note("Title 7", "This is note 7", 8))
        viewModel.addNote(Note("Title 8", "This is note 8", 9))
        viewModel.addNote(Note("Title 9", "This is note 9", 10))
        viewModel.addNote(Note("Title 10", "This is note 10", 11))
        viewModel.addNote(Note("Title 11", "This is note 11", 12))

    }
}