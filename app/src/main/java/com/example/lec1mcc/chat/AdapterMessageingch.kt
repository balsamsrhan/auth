package com.example.lec1mcc.chat

import android.content.Context
import android.os.Message
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lec1mcc.R

class AdapterMessageingch(val context: Context, val message1: List<MessageClass>, val currentUserUid:String): RecyclerView.Adapter<AdapterMessageingch.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = message1[position]
        holder.messageText.text = message.text
        holder.timeText.text = message.currenttime

        //خاصة بجزئية CurrentUid
        val layoutParams = holder.messageText.layoutParams as
                LinearLayout.LayoutParams
        layoutParams.gravity = if (message.senderId == currentUserUid)
            Gravity.END else Gravity.START
        holder.messageText.layoutParams = layoutParams

        val layoutParam = holder.timeText.layoutParams as
                LinearLayout.LayoutParams
        layoutParam.gravity = if (message.senderId == currentUserUid)
            Gravity.END else Gravity.START
        holder.timeText.layoutParams = layoutParams
    }

    override fun getItemCount(): Int {
        return message1.size
    }

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.message_text)
        val timeText: TextView = itemView.findViewById(R.id.time)
    }
}

