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
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.LayoutItemBinding
import com.example.kioskui.MenuFragment
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import com.example.kioskui.databinding.FragmentMenuBinding

class MyViewHolder(val binding :LayoutItemBinding):RecyclerView.ViewHolder(binding.root){

    val menuImageView : ImageView = binding.bugerImage
    val menutextView  : TextView = binding.stepMenuName
    var numbertextView : TextView = binding.menuCount
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
    var fbinding : FragmentMenuBinding?=null
    var nowPrice = fbinding.priceText.toString()
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //val onviewItem=dataset[position]
        //Log.d("위치","${position}")
        val listposition = dataset[position]

        val viewHolder = holder as MyViewHolder

        viewHolder.menuImageView.setImageDrawable(dataset[position].Menu)
        viewHolder.menutextView.text=dataset[position].Menu_name
        viewHolder.numbertextView.text=dataset[position].number_count
        viewHolder.topingtextView.text=dataset[position].toping
        viewHolder.drinktextView.text=dataset[position].drink
        viewHolder.sidemenutextView.text=dataset[position].sidemenu

        if(viewHolder.numbertextView.text=="1")
        {
            viewHolder.binding.minus.alpha = 0.3f
        }
        else
            viewHolder.binding.minus.alpha= 1f

        viewHolder.binding.plus.setOnClickListener{ // + 버튼
            Log.d("button","${position} 번째 +버튼 눌렀슴")
            //여기 눌렀을 때 price_text에서 dataset[price] 올리기.
            Log.d("업데이트 전 data","${dataset[position]}")
            var num = dataset[position].number_count.toInt()
            num++
            Log.d("num", "${num}")
            dataset[position].number_count=num.toString()
            var bug_Price = dataset[position].price.toInt()
            Log.d("price", "+버튼 누르기전 ${fbinding?.priceText?.text}")
            nowPrice= (nowPrice.toInt() + bug_Price).toString()
            fbinding?.priceText?.text=nowPrice
            Log.d("price", "+버튼 누르기전 ${fbinding?.priceText?.text}")
            //

            //여기서 nowPrice를 textView로 넘겨줘야함.
            notifyDataSetChanged()
            Log.d("업데이트 후 data","${dataset[position]}")
        }
        viewHolder.binding.minus.setOnClickListener{
            //여기 눌렀을 때 price_text에서 dataset[position]에 count깎고 price 업데이트하기.
            Log.d("button","${position} 번째 -버튼 눌렀슴")
            Log.d("업데이트 전 data","${dataset[position]}")
            var num = dataset[position].number_count.toInt()
            var bug_Price = dataset[position].price.toInt()
            Log.d("price","-누르기전 가격 : ${fbinding?.priceText?.text}")
            if(num>1) {
                num--
                Log.d("num", "${num}")
                dataset[position].number_count = num.toString()
                nowPrice =(nowPrice.toInt() - bug_Price).toString()
                fbinding?.priceText?.text=nowPrice
                Log.d("price","-누른후  가격 : ${fbinding?.priceText?.text}")
                //여기서 total_price를 textView로 넘겨줘야함.
                notifyDataSetChanged()
                Log.d("업데이트 후 data","${dataset[position]}")
            }
        }
        viewHolder.binding.allDelete.setOnClickListener {
            //여기 눌렀을 때 price_text에서 dataset[price] 전체를 없애기.
            //delete button 눌렀을때 현재
            Log.d("button","${position} 번째 x버튼 눌려슴")
            Log.d("업데이트 전 data","${dataset[position]}")
            Log.d("price","x 누르기전 가격 : ${fbinding?.priceText?.text}")
            var bug_Price = dataset[position].price.toInt() * dataset[position].number_count.toInt()
            nowPrice = (nowPrice.toInt() - bug_Price).toString()
            fbinding?.priceText?.text=nowPrice
            Log.d("price","x 누른 후  가격 : ${fbinding?.priceText?.text}")
            setPosition(position)
            removeItem(getPosition())
            //Log.d("업데이트 후 data","${dataset[position]}")
        }
    }


    override fun getItemCount(): Int {
        return dataset.size
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