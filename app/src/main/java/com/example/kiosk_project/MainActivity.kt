package com.example.kiosk_project

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiosk_project.databinding.DialogBinding
import com.example.kiosk_project.databinding.FragmentSimpleBinding
import com.example.kiosk_project.databinding.MenuSelectBinding
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {
    lateinit var transaction : FragmentTransaction
    var present : Fragment? = null
    lateinit var fragmentManager : FragmentManager
    lateinit var binding : MenuSelectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=MenuSelectBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val simple_btn =binding.simple
        val set_btn=binding.set
        val side_btn=binding.sidemenu
        val drink_btn =binding.drink
        val step_tablayout = binding.stepTab
        val simpleFragment = simple()
        val setFragment = set()
        val sideFragment= sidemenu()
        val drinkFragment=drink()
        fragmentManager=supportFragmentManager
        val step1 : TabLayout.Tab=step_tablayout.newTab()
        step1.text="포장/매장"
        step_tablayout.addTab(step1)
        val step2 : TabLayout.Tab=step_tablayout.newTab()
        step2.text="메뉴선택"
        step_tablayout.addTab(step2)
        val step3 : TabLayout.Tab=step_tablayout.newTab()
        step3.text="디테일추가"
        step_tablayout.addTab(step3)
        val step4 : TabLayout.Tab=step_tablayout.newTab()
        step4.text="결제"
        step_tablayout.addTab(step4)
        val dialogBinding = DialogBinding.inflate(layoutInflater)

        simple_btn.setOnClickListener{
            Log.d("jaehan","simple 버튼이 눌렸습니다")
            replaceTransaction(simpleFragment)
        }
        set_btn.setOnClickListener{
            replaceTransaction(setFragment)

        }
        side_btn.setOnClickListener {
            replaceTransaction(sideFragment)
        }
        drink_btn.setOnClickListener{
            replaceTransaction(drinkFragment)
        }
    }
    fun replaceTransaction(fragment: Fragment){
        if(present==fragment){
            Toast.makeText(this, "이미 해당 fragment를 보여주고 있습니다", Toast.LENGTH_SHORT).show()
            return
        }
        transaction=fragmentManager.beginTransaction()
        transaction.replace(binding.menuContainer.id, fragment).commit()
        present=fragment
    }
}