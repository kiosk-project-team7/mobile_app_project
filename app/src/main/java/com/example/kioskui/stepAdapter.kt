package com.example.kioskui

import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.LayoutItemBinding
import com.example.kioskui.MenuFragment
import androidx.fragment.app.activityViewModels
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.MainActivity.menuInit.Companion.total_price
import com.example.kioskui.MainActivity.menuInit.Companion.check
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.kioskui.MainActivity.menuInit.Companion.data
import com.example.kioskui.MainActivity.menuInit.Companion.menu_num
import com.example.kioskui.MainActivity.menuInit.Companion.menu_opt
import com.example.kioskui.MainActivity.menuInit.Companion.pdata
import com.example.kioskui.MainActivity.menuInit.Companion.selectedAmt
import com.example.kioskui.MainActivity.menuInit.Companion.whenAllDelected
import com.example.kioskui.MainActivity.menuInit.Companion.whenDelected
import androidx.navigation.fragment.findNavController
import com.example.kioskui.MainActivity.menuInit.Companion.whenSelected

class MyViewHolder(val binding :LayoutItemBinding): ViewHolder(binding.root){

    val menuImageView : ImageView = binding.bugerImage
    val menutextView  : TextView = binding.stepMenuName
    var numbertextView : TextView = binding.menuCount
    val topingtextView : TextView = binding.topingList
    val drinktextView : TextView = binding.drinkList
    val sidemenutextView : TextView = binding.sidemenuList
    val imageView : ImageView = binding.bugerImage
    val priceView : TextView = binding.recyclerPrice
}
class stepAdapter(private var dataset : MutableList<Itemview>,var binding2 : FragmentMenuBinding):RecyclerView.Adapter<ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return MyViewHolder(LayoutItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    var mposition = 0
    private var menuFragment = MenuFragment()
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        /*
        if(check==true){
            Log.d("test","${dataset.size}")
            dataset.clear()
            Log.d("test","${dataset.size}")
            //notifyDataSetChanged()
        }
        else{

         */
            val viewHolder = holder as MyViewHolder
            viewHolder.menuImageView.setImageDrawable(dataset[position].Menu)
            viewHolder.menutextView.text = dataset[position].Menu_name
            viewHolder.numbertextView.text = dataset[position].number_count
            viewHolder.topingtextView.text = dataset[position].toping
            viewHolder.drinktextView.text = dataset[position].drink
            viewHolder.sidemenutextView.text = dataset[position].sidemenu
            viewHolder.priceView.text=dataset[position].total_price.toString()+"원"
            binding2.priceText.text = total_price.toString()+"원"

            //binding2.priceRecyclerview.adapter=pAdapter(list)
            if(viewHolder.numbertextView.text=="1")
            {
                viewHolder.binding.minus.alpha = 0.3f
            }
            else
                viewHolder.binding.minus.alpha= 1f

            viewHolder.binding.plus.setOnClickListener{ // + 버튼
                Log.d("button","${position} 번째 +버튼 눌렀슴")
                var num = dataset[position].number_count.toInt()
                num++
                dataset[position].number_count=num.toString()
                var bug_Price = dataset[position].price
                dataset[position].total_price+=bug_Price
                total_price += bug_Price
                binding2.priceText.text = total_price.toString()+"원"
                whenSelected(menu_opt, menu_num)
                notifyDataSetChanged()


                Log.d("업데이트 후 data","${dataset[position]}")
            }
            viewHolder.binding.minus.setOnClickListener{
                var num = dataset[position].number_count.toInt()
                var bug_Price = dataset[position].price
                if(num>1) {
                    num--
                    dataset[position].number_count = num.toString()
                    total_price-=bug_Price
                    whenDelected(menu_opt, menu_num)
                    dataset[position].total_price-=bug_Price
                    notifyDataSetChanged()
                    binding2.priceText.text = total_price.toString()+"원"
                    Log.d("업데이트 후 data","${dataset[position]}")
                }
            }
            viewHolder.binding.allDelete.setOnClickListener {
                var bug_Price = dataset[position].price * dataset[position].number_count.toInt()
                total_price -= bug_Price
                dataset[position].total_price-=bug_Price
                whenAllDelected(menu_opt, menu_num,dataset[position].number_count.toInt())
                setPosition(position)
                removeItem(getPosition())
                binding2.priceText.text = total_price.toString()+"원"
                notifyDataSetChanged()
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
            //notifyDataSetChanged()
        }
    }
    fun setPosition(position: Int){
        mposition=position

    }

    fun remove_all(){
        dataset.clear()
        notifyDataSetChanged()
        binding2.priceText.text= total_price.toString()+"원"

    }

    fun getPosition() : Int{
        return mposition
    }

}
