package com.example.kiosk_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)

        val gotomenu = findViewById<Button>(R.id.eat)
        gotomenu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        val gotopay = findViewById<Button>(R.id.pack)
        gotopay.setOnClickListener{
            val intent1 = Intent(this,pay::class.java)
            startActivity(intent1)
        }
    }
}