package com.example.kioskui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Layout
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.activity.viewModels
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

            lateinit var menuImageView : ImageView

            val data = ArrayList<Itemview>()
            var count = 0
            fun whenSelected(menuNum: Int) {
                selectedAmt[menuNum] += 1
                stock[menuNum] -= 1
            }
        }
    }


    /*fun setOn(view: View){
        val rdg2 = findViewById<RadioGroup>(R.id.rdg2)

        if(view is RadioButton){
            val checked = view.isChecked

            when(view.getId()){
                R.id.rb1 ->
                    if(checked)
                        rdg2.clearCheck()
                R.id.rb2 ->
                    if(checked)
                        rdg2.clearCheck()
                R.id.rb3 ->
                    if(checked)
                        rdg2.clearCheck()
                R.id.rb4 ->
                    if(checked)
                        rdg2.clearCheck()
                R.id.rb5 ->
                    if(checked)
                        rdg2.clearCheck()
                R.id.rb6 ->
                    if(checked)
                        rdg2.clearCheck()
            }
        }
    }

    fun setOn2(view: View){
        val rdg1 = findViewById<RadioGroup>(R.id.rdg1)

        if(view is RadioButton){
            val checked = view.isChecked

            when(view.getId()){
                R.id.rb7 ->
                    if(checked)
                        rdg1.clearCheck()
                R.id.rb8 ->
                    if(checked)
                        rdg1.clearCheck()
                R.id.rb9 ->
                    if(checked)
                        rdg1.clearCheck()
                R.id.rb10 ->
                    if(checked)
                        rdg1.clearCheck()
                R.id.rb11 ->
                    if(checked)
                        rdg1.clearCheck()
                R.id.rb12 ->
                    if(checked)
                        rdg1.clearCheck()
            }
        }
    }*/

    class myclass {
        companion object {
            var menuName : String = " "
            var stock : Boolean = false
            var price : Int = 6800
            //   var isSeleced = Array<Boolean>(12,false)
            fun onclickTest(i : Int) {
            }
        }
    }

    class myclass2 {
        companion object {
            var isSeleced : Boolean = true
            fun onclickTest() {
                isSeleced = !isSeleced
                Log.d("test", isSeleced.toString())
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }
}