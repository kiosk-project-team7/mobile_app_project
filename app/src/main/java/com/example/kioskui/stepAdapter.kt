package com.example.kioskui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.LayoutItemBinding

class MyViewHolder(val binding :LayoutItemBinding):RecyclerView.ViewHolder(binding.root){
    val menutextView  : TextView = binding.stepMenuName
    val pricetextView : TextView = binding.stepPrice
    val numbertextView : TextView = binding.stepNumber

 }
class stepAdapter(val dataset : MutableList<Itemview>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val onviewItem=dataset[position]
        val viewHolder = holder as MyViewHolder
        viewHolder.menutextView.text=dataset[position].Menu_name
        viewHolder.pricetextView.text=dataset[position].price_text
        viewHolder.numbertextView.text=dataset[position].number_count
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}