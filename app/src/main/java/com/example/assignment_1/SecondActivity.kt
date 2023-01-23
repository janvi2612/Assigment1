package com.example.assignment_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.assignment_1.login
import com.example.assignment_1.reg

import com.example.ebook.R

import kotlin.math.sign


class SecondActivity : AppCompatActivity() {

    private lateinit var loginbtn:Button
    private lateinit var signupbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginbtn = findViewById(R.id.loginbtn)
        signupbtn = findViewById(R.id.signupbtn)


        loginbtn.setOnClickListener{
            val  intent = Intent(applicationContext,login::class.java)
            startActivity(intent)
        }


        signupbtn.setOnClickListener{
            val intent = Intent(applicationContext,reg::class.java)
            startActivity(intent)
        }

    }

}
