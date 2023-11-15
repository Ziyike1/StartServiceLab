package com.example.myapplication2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)
        val startButton = findViewById<Button>(R.id.startButton)

        startButton.setOnClickListener {
            val number = editTextNumber.text.toString().toIntOrNull() ?: return@setOnClickListener
            val intent = Intent(this, CountdownService::class.java)
            intent.putExtra("COUNTDOWN_VALUE", number)
            startService(intent)
        }
    }
}
