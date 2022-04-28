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
    private lateinit var noteList:  ArrayList<Note>
    private lateinit var noteRecycleView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
        initApp()
    }

    private fun observeData(){
        viewModel.noteList.observe(this, Observer{
            noteAdapter.bind(it)
        })
    }

    private fun initApp(){
        val noteUseCases = NoteUseCases.provideNoteUseCase(applicationContext)
        viewModel = NotesViewModel(noteUseCases)

        noteList = ArrayList()
        noteList.add(Note("Title", "This is note 0", 1))
        noteList.add(Note("Title1", "This is note 1", 2))
        noteList.add(Note("Title2", "This is note 2", 3))
        noteList.add(Note("Title3", "This is note 3", 4))

        noteAdapter = NoteAdapter(noteList)

        noteRecycleView = findViewById(R.id.note_recycle_view)
        noteRecycleView.adapter = noteAdapter
        noteRecycleView.layoutManager = LinearLayoutManager(this)

        observeData()

    }
}