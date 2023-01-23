package com.example.assignment_1

import android.app.ProgressDialog
import android.content.ContentValues
import android.content.Intent
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.text.TextUtils
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import com.example.ebook.R


class reg : AppCompatActivity() {
    lateinit var db :SQLiteDatabase
    lateinit var rs :Cursor
    lateinit var register : Button
    lateinit var name : EditText
    lateinit var email : EditText
    lateinit var pwd : EditText
    lateinit var cpwd : EditText
    private lateinit var progressDialog: ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reg)
        name = findViewById(R.id.nme)
        email = findViewById(R.id.emailid)
        pwd = findViewById(R.id.pwd)
        cpwd = findViewById(R.id.cnpwd)
        var helper = SqlHelper(applicationContext)
        db = helper.readableDatabase
        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Please wait")
        progressDialog.setCanceledOnTouchOutside(false)
        register.setOnClickListener {
            submit()
        }


    }




    private fun submit() {


        var p = Patterns.EMAIL_ADDRESS



        if (TextUtils.isEmpty(name.text.toString())){
            name.setError("Name field is Empty")
            name.requestFocus()

        }
        else if (TextUtils.isEmpty(email.text.toString()))
        {
            email.setError("Email filed is Empty")
            email.requestFocus()
        }
        else if (email.text.toString().trim() != p.toString())
        {
            email.setError("Enter Email Properly")
            email.requestFocus()
        }

        else if (TextUtils.isEmpty(pwd.text.toString()))
        {
            pwd.setError("Password  field is Empty")
            pwd.requestFocus()
        }

        else if (pwd.length() < 8)
        {
            pwd.setError("Password Must be in 8 or more char")
            pwd.requestFocus()
        }
        else if (TextUtils.isEmpty(cpwd.text.toString()))
        {
            cpwd.setError("Conform Password  field is Empty")
            cpwd.requestFocus()
        }
        else if (cpwd.text.toString().trim() != cpwd.text.toString().trim())
        {
            cpwd.setError("Please provide a same password")
            cpwd.requestFocus()
        }
        else{
            var cv= ContentValues()
            cv.put("Name",name.text.toString())
            cv.put("Email",email.text.toString())
            cv.put("Password",pwd.text.toString())
            db.insert("Abcd",null,cv)
            rs.requery()
            var intent  = Intent(applicationContext,login::class.java)
            startActivity(intent)
            finish()
        }

    }
}




