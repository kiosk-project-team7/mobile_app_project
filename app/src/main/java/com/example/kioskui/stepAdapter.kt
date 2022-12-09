package com.example.kioskui

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.LayoutItemBinding

class MyViewHolder(val binding :LayoutItemBinding):RecyclerView.ViewHolder(binding.root){
    val menuImageView : ImageView = binding.bugerImage
    val menutextView  : TextView = binding.stepMenuName
    val numbertextView : TextView = binding.menuCount
    val topingtextView : TextView = binding.topingList
    val drinktextView : TextView = binding.drinkList
    val sidemenutextView : TextView = binding.sidemenuList
    val imageView : ImageView = binding.bugerImage
 }
class stepAdapter(val dataset : MutableList<Itemview>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val onviewItem=dataset[position]
        val viewHolder = holder as MyViewHolder
        viewHolder.menuImageView.setImageResource(onviewItem.Menu)
        viewHolder.menutextView.text=dataset[position].Menu_name
        viewHolder.numbertextView.text=dataset[position].number_count
        viewHolder.topingtextView.text=dataset[position].toping
        viewHolder.drinktextView.text=dataset[position].drink
        viewHolder.sidemenutextView.text=dataset[position].sidemenu
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}