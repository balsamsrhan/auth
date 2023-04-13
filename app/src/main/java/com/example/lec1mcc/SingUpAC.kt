package com.example.lec1mcc

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

class SingUpAC : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentUser = auth.currentUser
        if(currentUser != null){
            updateUI()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_up)
        var edt_email = findViewById<EditText>(R.id.edt_email)
        var edt_password = findViewById<EditText>(R.id.edt_password)
        var btn_singup = findViewById<Button>(R.id.btn_singup)

        auth = Firebase.auth
        var email = edt_email.text
        var password = edt_password.text

        btn_singup.setOnClickListener {
            Log.e("bals", email.toString())
            Log.e("bals", password.toString())
            createNewAccount(email.toString(), password.toString())
        }
    }

    private fun createNewAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("balsam", "createUserWithEmail:success")
                    updateUI()
                } else {
                    Log.w("balsam", "createUserWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }


    }

    override fun onDestroy() {
        super.onDestroy()
        val currentUser = auth.currentUser
        if(currentUser != null){
            updateUI()
        }
    }
    fun updateUI() {
        var i = Intent(this, SigninAc::class.java)
        startActivity(i)
    }


}

