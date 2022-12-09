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

    class menuInit {
        companion object {
            val menuName = arrayListOf<String>("메뉴 1", "메뉴 2", "메뉴 3", "메뉴 4", "메뉴 5", 
            "메뉴 6", "메뉴 7", "메뉴 8", "메뉴 9", "메뉴 10", "메뉴 11", "메뉴 12")
            val imgPath = "R.id.menu1Img"
            val desc = arrayListOf<String>("메뉴1 설명입니다.", "메뉴2 설명입니다.", "메뉴3 설명입니다.",
                "메뉴4 설명입니다.", "메뉴5 설명입니다.", "메뉴6 설명입니다.", "메뉴7 설명입니다.", "메뉴8 설명입니다.",
                "메뉴9 설명입니다.", "메뉴10 설명입니다.", "메뉴11 설명입니다.", "메뉴12 설명입니다.")
            var stock = arrayListOf<Int>(100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100, 100)
            var price = arrayListOf<Int>(1000, 2000, 3000, 4000, 5000, 6000, 7000, 
                8000, 9000, 10000, 11000, 12000)
            var selectedAmt = arrayListOf<Int> (0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
            fun whenSelected(menuNum: Int) {
                selectedAmt[menuNum] += 1
                stock[menuNum] -= 1
            }
        }
    }

    val menu1: menuInit = menuInit()


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }

}