package com.example.kioskui

import android.R
import android.graphics.drawable.BitmapDrawable
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.view.LayoutInflater
import android.view.View
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
class stepAdapter(private var dataset : MutableList<Itemview>):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return MyViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    var mposition = 0
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //val onviewItem=dataset[position]
        Log.d("위치","${position}")
        val listposition = dataset[position]
        setPosition(position)
        val viewHolder = holder as MyViewHolder
        viewHolder.menuImageView.setImageDrawable(dataset[position].Menu)
        viewHolder.menutextView.text=dataset[position].Menu_name
        viewHolder.numbertextView.text=dataset[position].number_count
        viewHolder.topingtextView.text=dataset[position].toping
        viewHolder.drinktextView.text=dataset[position].drink
        viewHolder.sidemenutextView.text=dataset[position].sidemenu

        viewHolder.binding.plus.setOnClickListener{ // + 버튼

        }
        viewHolder.binding.minus.setOnClickListener{

        }
        viewHolder.binding.allDelete.setOnClickListener {
            //delete button 눌렀을때 현재
            Log.d("button","x버튼 눌려슴")
            removeItem(getPosition())
        }

    }
    interface onItemClickListner{
        fun onClick(v: View, position:Int)
    }
    private  lateinit var itemClickListner : onItemClickListner

    override fun getItemCount(): Int {
        return dataset.size
    }
    fun setItemClickListener(itemClickListner: onItemClickListner){
        this.itemClickListner=itemClickListner
    }
    fun setData(newData:MutableList<Itemview>)
    {
        dataset=newData
        notifyDataSetChanged()
    }
    fun removeItem(position: Int)
    {
        Log.d("positon","${position}")
        if(position>=0){
            dataset.removeAt(position)
            notifyDataSetChanged()
        }
    }
    fun setPosition(position: Int){
        mposition=position
    }
    fun getPosition() : Int{
        return mposition
    }
}