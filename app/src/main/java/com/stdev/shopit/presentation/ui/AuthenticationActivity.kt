package com.stdev.shopit.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

import com.stdev.shopit.R
import com.stdev.shopit.data.db.DBHelper

class AuthenticationActivity : AppCompatActivity() {
    private lateinit var btnsignup: Button
    private lateinit var btnlogin: Button
    private lateinit var cart_back: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_authentication)



        btnsignup = findViewById(R.id.button0)
        btnlogin = findViewById(R.id.button2)
        cart_back = findViewById(R.id.cart_back)

        btnsignup.setOnClickListener {
            val intent = Intent(this, Signup::class.java)
            startActivity(intent)

        }

        btnlogin.setOnClickListener {
            val intent = Intent(this, login::class.java)
            startActivity(intent)

        }

        cart_back.setOnClickListener {
            val intent = Intent(this, CartFragment::class.java)
            startActivity(intent)
        }





    }
}