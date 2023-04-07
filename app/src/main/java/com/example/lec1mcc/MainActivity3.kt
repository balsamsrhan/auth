package com.example.lec1mcc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity3 : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        auth = Firebase.auth
        val user = Firebase.auth.currentUser
        var edt_email = findViewById<TextView>(R.id.txt_emailsi)
        var edt_password = findViewById<TextView>(R.id.txt_UID)
        var btn_singout = findViewById<Button>(R.id.btn_singout)

      edt_email.text = user!!.email
        edt_password.text = user.uid

        btn_singout.setOnClickListener {
            Firebase.auth.signOut()
            var i = Intent(this, SigninAc::class.java)
            startActivity(i)
        }

    }
}