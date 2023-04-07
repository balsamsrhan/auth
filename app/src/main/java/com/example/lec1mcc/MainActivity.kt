package com.example.lec1mcc

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import kotlin.math.log

class MainActivity : AppCompatActivity() {
 lateinit var float : FloatingActionButton
 lateinit var rec :RecyclerView
    private lateinit var noteArrayList : ArrayList<notesClass>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var db = Firebase.firestore
        float = findViewById(R.id.normalFAB)
        rec = findViewById(R.id.recyclerView)
        getRegToken()

        float.setOnClickListener() {
            intent = Intent(this, Addnote::class.java)
            startActivity(intent)
        }


        rec.layoutManager = LinearLayoutManager(this)
        rec.setHasFixedSize(true)

        noteArrayList = arrayListOf()

        db.collection("notes").get().addOnSuccessListener {
            if (!it.isEmpty){
                for (data in it.documents){
                    val not : notesClass? = data.toObject(notesClass::class.java)
                    if (not != null){
                        noteArrayList.add(not)
                    }
                }
                rec.adapter = MyAdapter(noteArrayList)
            }

        }
                .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
            }


    fun getRegToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (!task.isSuccessful){
                Log.e("bal","hello",task.exception)
                return@addOnCompleteListener
            }
            val token = task.result
            Log.e("token",token.toString())
        }
    }

    }
