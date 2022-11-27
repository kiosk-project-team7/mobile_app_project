package com.example.kiosk_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

//시작화면
class start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start)

        val gotomenu = findViewById<Button>(R.id.eat)
        //매장
        gotomenu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        //포장
        val gotopay = findViewById<Button>(R.id.pack)
        gotopay.setOnClickListener{
            val intent1 = Intent(this,MainActivity::class.java)
            startActivity(intent1)
        }
    }
}