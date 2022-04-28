package com.example.notesapp.presentation.notes

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.domain.model.Note
import com.example.notesapp.presentation.add_edit_note.AddEditNoteActivity


class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    private var noteList: List<Note> = ArrayList()

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.note_title)
        val description: TextView = itemView.findViewById(R.id.note_description)
    }


    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

        val btnDelete : Button = view.findViewById(R.id.btn_delete)
        btnDelete.setOnClickListener(View.OnClickListener {
            Toast.makeText(parent.context, "item click!", Toast.LENGTH_SHORT).show()
        })



        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = noteList[position]
        holder.title.text = item.title
        holder.description.text = item.content

    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    fun bind(noteList: List<Note>){
        this.noteList = noteList
    }
}