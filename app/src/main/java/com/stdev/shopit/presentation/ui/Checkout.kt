package com.stdev.shopit.presentation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stdev.shopit.R
import com.stdev.shopit.presentation.adapter.CheckoutAdapter

class Checkout : AppCompatActivity() {

    private lateinit var cart_checkout: Button
    private lateinit var checkout_back: ImageView
    private lateinit var cartRecyclerView: RecyclerView
    private lateinit var cartItemsInfo: TextView
    private lateinit var cartItemsPrice: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkout)

        cart_checkout = findViewById(R.id.cart_checkout)
        checkout_back = findViewById(R.id.cart_back)
        cartRecyclerView = findViewById(R.id.cart_recycler_view)
        cartItemsInfo = findViewById(R.id.cart_items_info)
        cartItemsPrice = findViewById(R.id.cart_items_price)

        // Set up the RecyclerView
        val layoutManager = LinearLayoutManager(this)
        cartRecyclerView.layoutManager = layoutManager
        // Set the adapter to display cart items
        val cartAdapter = CheckoutAdapter() // Replace with your custom adapter
        cartRecyclerView.adapter = cartAdapter

        cart_checkout.setOnClickListener {
            val intent = Intent(applicationContext, Order::class.java)
            startActivity(intent)
        }

        checkout_back.setOnClickListener {
            val intent = Intent(applicationContext, Signup::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        // Handle the back button press here
        // For example, navigate to the previous activity
        super.onBackPressed()
    }
}
