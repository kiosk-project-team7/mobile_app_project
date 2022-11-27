package com.example.kiosk_project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.GridLayout
import android.widget.HorizontalScrollView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kiosk_project.databinding.DetailmenuBinding

data class ItemView(val image : Int,val text : String){}
class detailmenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detailmenu)
        //val binding = DetailmenuBinding.inflate(layoutInflater)
        //binding.topingRecycle.layoutManager = LinearLayoutManager(this)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerview)

        val layoutManage = LinearLayoutManager(this)
        layoutManage.orientation=LinearLayoutManager.HORIZONTAL
        recyclerView.layoutManager=layoutManage

        /*
        val layoutManager=GridLayoutManager(this,5,GridLayoutManager.VERTICAL,false)
        recyclerView.layoutManager=layoutManager

         */
        val data = ArrayList<ItemView>()


        data.add(ItemView(R.drawable.simple_one,"계란"))
        data.add(ItemView(R.drawable.simple_eight,"참치"))
        data.add(ItemView(R.drawable.simple_two,"피클"))
        data.add(ItemView(R.drawable.simple_three,"패티"))
        data.add(ItemView(R.drawable.simple_four,"베이컨"))
        Log.d("jaehan","data size :${data.size}")
        val adapter = detailAdapter(data)
        recyclerView.adapter=adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.HORIZONTAL))
    }
}