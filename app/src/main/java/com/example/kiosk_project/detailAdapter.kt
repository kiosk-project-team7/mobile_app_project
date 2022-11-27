package com.example.kiosk_project

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kiosk_project.databinding.DetailmenuBinding
import com.example.kiosk_project.databinding.TopingDetailBinding

class myViewHolder(val layout : View) :RecyclerView.ViewHolder(layout){
    val imageView: ImageView = layout.findViewById(R.id.top_image)
    val textView: TextView=  layout.findViewById(R.id.top_name)
}
class detailAdapter(val dataSet : ArrayList<ItemView>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val viewInflater = LayoutInflater.from(parent.context)
        val viewItemDesignLayout = viewInflater.inflate(R.layout.toping_detail,parent,false)
        return myViewHolder(viewItemDesignLayout)
    }
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val oneViewItem=dataSet[position]
        val viewHolder =holder as myViewHolder
        viewHolder.imageView.setImageResource(oneViewItem.image)
        viewHolder.textView.text=oneViewItem.text
    }
    override fun getItemCount(): Int {
        return dataSet.size
    }
}