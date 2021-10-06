package com.example.noteappcleanarchitecture.feature_note.domain.use_case

import com.example.noteappcleanarchitecture.feature_note.domain.model.Note
import com.example.noteappcleanarchitecture.feature_note.domain.repository.NoteRepository
import com.example.noteappcleanarchitecture.feature_note.domain.util.NoteOrder
import com.example.noteappcleanarchitecture.feature_note.domain.util.OrderType

class DeleteNote(private val repository: NoteRepository
) {

    suspend operator fun invoke(note:Note){
        repository.deleteNote(note)
    }
}