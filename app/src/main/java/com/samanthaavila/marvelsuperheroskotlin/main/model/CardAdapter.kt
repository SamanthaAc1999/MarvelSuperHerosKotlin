package com.samanthaavila.marvelsuperheroskotlin.main.model

import android.view.View
import android.widget.TextView
import android.widget.ImageView
import android.view.ViewGroup
import android.view.LayoutInflater
import androidx.recyclerview.widget.RecyclerView
import com.samanthaavila.marvelsuperheroskotlin.R


class CardAdapter(private val characters: List<Character>):
    RecyclerView.Adapter<CardAdapter.CharacterViewHolder>(){

    class CharacterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: TextView = view.findViewById(R.id.textViewDetailTitle)
        val textViewYear: TextView = view.findViewById(R.id.textViewDetailYear)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_main, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.textViewTitle.text = character.name
        holder.textViewYear.text = character.description

    }

    override fun getItemCount() = characters.size


}