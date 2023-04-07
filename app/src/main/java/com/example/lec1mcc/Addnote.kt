package com.example.lec1mcc

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Addnote : AppCompatActivity() {
    lateinit var txtname : EditText
    lateinit var txtdes : EditText
    lateinit var txtnum : EditText
    lateinit var btnadd : Button
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_addnote)

        txtname = findViewById(R.id.namenotes)
        txtdes = findViewById(R.id.DESCRIPTION)
        txtnum = findViewById(R.id.number)
        btnadd = findViewById(R.id.btnadd)

        btnadd.setOnClickListener{
addnotes(
    txtname.text.toString(),
    txtdes.text.toString(),
    txtnum.text.toString(),
)
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
    private fun addnotes(
        name: String,
        description: String,
        numberchar: String,
    ) {

        var notess =
            hashMapOf(
                "name" to name,
                "discription" to description,
                "numberchar" to numberchar
            )
        db.collection("notes")
            .add(notess)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}