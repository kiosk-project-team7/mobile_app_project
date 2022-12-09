package com.example.kioskui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.widget.ImageView
import androidx.navigation.findNavController
import com.example.kioskui.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    val fragmentManager = supportFragmentManager

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}