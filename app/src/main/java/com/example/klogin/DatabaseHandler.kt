package com.example.klogin

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


var Database_name = "UserData"

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, Database_name,null,1)
{
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL("create table UserData(col_Username varchar(100) primary key,"+ "col_password varchar(100))")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //insert data
    fun inserData(colemail : String, colpwd : String){
        val database = this.writableDatabase
        var cv = ContentValues()
        cv.put("Col_Username",colemail)
        cv.put("Col_Password",colpwd)
        database.insert(Database_name,null,cv)
        database.close()
    }

    fun userPresent(colemail: String,colpwd: String): Boolean {
        val databse =this.writableDatabase
        val query = "select * from UserData where Col_Username = '$colemail' and Col_Password = '$colpwd'"
        val cursor = databse.rawQuery(query,null)
        if (cursor.count <= 0){
            cursor.close()
            return false
        }
        cursor.close()
        return true

    }



}



