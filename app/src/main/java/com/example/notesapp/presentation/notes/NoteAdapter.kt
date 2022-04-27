package com.example.notesapp.presentation.notes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.domain.model.Note


class NoteAdapter(private var noteList: List<Note>) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.note_title)
        val description: TextView = itemView.findViewById(R.id.note_description)
    }

    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.note_item, parent, false)

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