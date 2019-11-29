package com.example.klogin

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {

    lateinit var data : DatabaseHandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        data = DatabaseHandler(this)
        btnSignUppage.setOnClickListener {
            var uname = etruname.text.toString()
            var pwd = etrpwd.text.toString()
            var cpwd = etrcpwd.text.toString()
            if (uname.isNotEmpty() || pwd.isNotEmpty() || cpwd.isNotEmpty()) {
                if (pwd.equals(cpwd)) {
                    data.inserData(uname, pwd)
                    Toast.makeText(this, "You are Signed Up SuccessFully.", Toast.LENGTH_SHORT)
                        .show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    alertDialogmismatch()
                }
            }
            else{
                alertDialogempty()
            }
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
