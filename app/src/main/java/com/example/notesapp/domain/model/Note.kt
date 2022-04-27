package com.example.notesapp.domain.model

import androidx.room.*

@Entity
data class Note(
    val title: String,
    val content: String,
    val timestamp: Long,
    @PrimaryKey val id: Int? = null
)

class InvalidNoteException(message: String): Exception(message)