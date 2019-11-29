package com.example.klogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var handler: DatabaseHandler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var sign = SignUp()
        handler = DatabaseHandler(this)
        //This is btn login
        btnLogin.setOnClickListener {
            var uname = etEmail.text.toString()
            var pwd = etPassword.text.toString()
            if (uname.isNotEmpty() || pwd.isNotEmpty()) {
                if (handler.userPresent(etEmail.text.toString(), etPassword.text.toString())) {
                    Toast.makeText(this, "You are Successfully logged in.", Toast.LENGTH_SHORT)
                        .show()
                }
                else{
                    alertDialogmismatch()
                }
            }
            else
            {
                alertDialogempty()
            }
        }
        //This is btn SignUP
        btnSignup.setOnClickListener {
        startActivity(Intent(this,SignUp::class.java))
        }
    }

    public fun alertDialogmismatch() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Password mismatch")
        dialog.setMessage("Confirm password Doesn't match")

        dialog.setPositiveButton(
            "ok"
        ) { dialog, which -> }
        dialog.setNegativeButton(
            "Cancel"
        ) { dialog, which -> }
        val alertDialog = dialog.create()
        alertDialog.show()
    }


    public fun alertDialogempty() {
        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("ERROR")
        dialog.setMessage("Password Fields can't be empty");

        dialog.setPositiveButton(
            "ok"
        ) { dialog, which -> }
        dialog.setNegativeButton(
            "Cancel"
        ) { dialog, which -> }
        val alertDialog = dialog.create()
        alertDialog.show()
    }
}
