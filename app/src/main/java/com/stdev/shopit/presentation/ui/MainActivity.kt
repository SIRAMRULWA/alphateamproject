package com.stdev.shopit.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.stdev.shopit.R
import dagger.hilt.android.AndroidEntryPoint
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}