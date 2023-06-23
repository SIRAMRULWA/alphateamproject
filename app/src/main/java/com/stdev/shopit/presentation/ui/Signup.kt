package com.stdev.shopit.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.util.TextUtils
import com.stdev.shopit.R
import com.stdev.shopit.data.db.DBHelper

class Signup : AppCompatActivity() {

    private lateinit var uname: EditText
    private lateinit var pword: EditText
    private lateinit var cpword: EditText
    private lateinit var emword: EditText
    private lateinit var coword: EditText
    private lateinit var signupbtn: Button
    private lateinit var signup_back: ImageView
    private lateinit var db: DBHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        uname = findViewById(R.id.editTextText)
        pword = findViewById(R.id.editTextTextPassword)
        cpword = findViewById(R.id.editTextTextPassword2)
        emword = findViewById(R.id.editTextTextEmailAddress)
        coword = findViewById(R.id.editTextPhone)
        signup_back = findViewById(R.id.signup_back)
        signupbtn = findViewById(R.id.button3)
        db = DBHelper(this)

        signup_back.setOnClickListener {
            val intent = Intent(applicationContext, AuthenticationActivity::class.java)
            startActivity(intent)
        }

        signupbtn.setOnClickListener() {
            val unametext = uname.text.toString()
            val emwordtext = emword.text.toString()
            val cowordtext = coword.text.toString()
            val pwordtext = pword.text.toString()
            val cpwordtext = cpword.text.toString()
            val savedata = db.insertdata(unametext, pwordtext, emwordtext, cowordtext)

            if (unametext.length < 3) {
                Toast.makeText(this, "Username should have a minimum of 3 characters", Toast.LENGTH_SHORT).show()
            } else if (!isValidEmail(emwordtext)) {
                Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            } else if (!isValidContactNumber(cowordtext)) {
                Toast.makeText(this, "Invalid contact number", Toast.LENGTH_SHORT).show()
            } else if (pwordtext.length < 8) {
                Toast.makeText(this, "Password should be at least 8 characters long", Toast.LENGTH_SHORT).show()
            } else if (TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(cpwordtext)) {
                Toast.makeText(this, "Please fill in all the required fields", Toast.LENGTH_SHORT).show()
            } else {
                if (pwordtext == cpwordtext) {

                    if (savedata !=null) {
                        //  Toast.makeText(this, "Signup Successful", Toast.LENGTH_SHORT).show()
                        val intent = Intent(applicationContext, login::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, "User already exists", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            }
        }


    }


    private fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex(pattern = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
        return email.matches(emailRegex)
    }

    private fun isValidContactNumber(contactNumber: String): Boolean {
        val contactRegex = Regex(pattern = "^[0-9]{10}$")
        return contactNumber.matches(contactRegex)
    }



}