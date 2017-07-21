package com.generalmobile.app.gmnotes.ui.main

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.generalmobile.app.gmnotes.Application
import com.generalmobile.app.gmnotes.R
import com.generalmobile.app.gmnotes.databinding.ItemNoteBinding
import com.generalmobile.app.gmnotes.db.entities.Note

class NoteAdapter(private var noteList: List<Note>, var application: Application) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {
    override fun getItemCount() = noteList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel.note = noteList[position]
        holder.binding.executePendingBindings()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val postBinding = DataBindingUtil.inflate<ItemNoteBinding>(LayoutInflater.from(parent.context), R.layout.item_note, parent, false)
        val viewModel = NoteAdapterViewModel(application)
        postBinding.viewModel = viewModel
        return ViewHolder(postBinding)
    }

    fun addItems(notes: List<Note>) {
        noteList = notes
        notifyDataSetChanged()
    }


    class ViewHolder(var binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)
}