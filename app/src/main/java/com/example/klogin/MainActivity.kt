package com.example.klogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var handler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        handler = DatabaseHandler(this)
        btnLogin.setOnClickListener {
        if(handler.userPresent(etEmail.text.toString(),etPassword.text.toString()))
        {
            Toast.makeText(this,"You are Successfully logged in.",Toast.LENGTH_SHORT).show()
        }
        }
        btnSignup.setOnClickListener {
        startActivity(Intent(this,SignUp::class.java))
        }
    }
}
