package com.example.kioskui

import android.R
import android.graphics.drawable.BitmapDrawable
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.LayoutItemBinding
import com.example.kioskui.model.OrderViewModel

class MyViewHolder(val binding :LayoutItemBinding):RecyclerView.ViewHolder(binding.root){
    val menuImageView : ImageView = binding.bugerImage
    val menutextView  : TextView = binding.stepMenuName
    val numbertextView : TextView = binding.menuCount
    val topingtextView : TextView = binding.topingList
    val drinktextView : TextView = binding.drinkList
    val sidemenutextView : TextView = binding.sidemenuList
    val imageView : ImageView = binding.bugerImage
 }
class stepAdapter(private var dataset : List<Itemview>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //val onviewItem=dataset[position]
        val viewHolder = holder as MyViewHolder
        viewHolder.menuImageView.setImageDrawable(dataset[position].Menu)
        viewHolder.menutextView.text=dataset[position].Menu_name
        viewHolder.numbertextView.text=dataset[position].number_count
        viewHolder.topingtextView.text=dataset[position].toping
        viewHolder.drinktextView.text=dataset[position].drink
        viewHolder.sidemenutextView.text=dataset[position].sidemenu
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
    fun setData(newData:List<Itemview>)
    {
        dataset=newData
        notifyDataSetChanged()
    }
}