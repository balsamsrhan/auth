package com.example.lec1mcc

import android.content.ContentValues.TAG
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SigninAc : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
       // val currentUser = auth.currentUser
        auth = Firebase.auth
        var edt_email = findViewById<EditText>(R.id.edt_emailsi)
        var edt_password = findViewById<EditText>(R.id.edt_passwordsi)
        var btn_singin = findViewById<Button>(R.id.btn_singin)

        var email = edt_email.text
        var password = edt_password.text

        btn_singin.setOnClickListener {
            singin(email.toString(), password.toString())
        }

    }

    fun updateUI() {
        var i = Intent(this, MainActivity3::class.java)
        startActivity(i)
    }
    fun singin(email:String,password:String){
        auth.signInWithEmailAndPassword(email.toString(), password.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d(TAG, "signInWithEmail:success")
                    updateUI()
                } else {
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }
}