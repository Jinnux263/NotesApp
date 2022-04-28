package com.example.notesapp.presentation.notes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.domain.model.Note

class NotesActivity : AppCompatActivity() {
    private lateinit var noteList:  ArrayList<Note>
    private lateinit var noteRecycleView: RecyclerView
    private lateinit var noteAdapter: NoteAdapter
    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)
//        initApp()
    }

    fun observeData(){
        viewModel.noteList.observe(this, Observer{
            noteAdapter.bind(it)
        })
    }

    private fun initApp(){

        //LOI O DAY, KHONG TRUYEN DUOC CONTEXT VAO VIEWMODEL
        viewModel = ViewModelProvider(this)[NotesViewModel::class.java]

        noteList = ArrayList()
        noteList.add(Note("Title", "This is a note", 124578, 1))
        noteList.add(Note("Title", "This is a note", 124578, 2))
        noteList.add(Note("Title", "This is a note", 124578, 3))
        noteList.add(Note("Title", "This is a note", 124578, 4))
        noteAdapter = NoteAdapter(noteList)

        noteRecycleView = findViewById(R.id.note_recycle_view)
        noteRecycleView.adapter = noteAdapter
        noteRecycleView.layoutManager = LinearLayoutManager(this)

        observeData()

    }
}