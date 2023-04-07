package com.example.lec1mcc

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val noteList : ArrayList<notesClass>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.listadd,
            parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = noteList[position]

        holder.namenote.text = currentitem.name
        holder.desnote.text = currentitem.discription
        holder.numberch.text = currentitem.numberchar

    }

    override fun getItemCount(): Int {

        return noteList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val namenote : TextView = itemView.findViewById(R.id.txtnamenote)
        val desnote : TextView = itemView.findViewById(R.id.txtdesnote)
        val numberch : TextView = itemView.findViewById(R.id.txtnumbernote)

    }

}