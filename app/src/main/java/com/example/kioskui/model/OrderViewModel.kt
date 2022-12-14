package com.example.kioskui.model
import android.icu.text.NumberFormat
import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.example.kioskui.Itemview
import com.example.kioskui.MainActivity.menuInit.Companion.pdata
import com.example.kioskui.MenuFragment
import com.example.kioskui.PriceView
import com.example.kioskui.stepAdapter

class OrderViewModel : ViewModel() {
    val data = arrayListOf<Itemview>()
    val liveData = MutableLiveData<List<Itemview>>()
    private val h_image = MutableLiveData<ImageView>(null) //image
    val image : LiveData<ImageView> = h_image

    private val h_toping = MutableLiveData<String>("") //toping
    val toping : LiveData<String> = h_toping

    private val h_drink = MutableLiveData<String>("") //drink
    val drink : LiveData<String> = h_drink
    private val h_side = MutableLiveData<String>("") //sidemenu
    val side : LiveData<String> = h_side
    private val h_name = MutableLiveData<String>("")
    val bugname : LiveData<String> = h_name
    private val _price = MutableLiveData<Int>()
    val price_ : LiveData<String> = Transformations.map(_price) {
            _price.value.toString() + "원"
    }
    var np : Int=0
    var now_price :Int =0
    private var _total = MutableLiveData<Int>()
    val total : LiveData<String> = Transformations.map(_total)
    {
        _total.value.toString() + "원"
    }
    fun set_image(img : ImageView)
    {
        h_image.value=img
    }
    fun calculate(){
        _total.value=_price.value
    }
    fun set_toping(top : String)
    {
        h_toping.value=top
    }
    fun set_drink(drink : String)
    {
        h_drink.value=drink
    }
    fun set_side(side : String)
    {
        h_side.value=side
    }
    fun set_name(name : String)
    {
        h_name.value=name
    }
     fun setPrice(p : String){
         Log.d("setPrice","버튼을 눌렸슴, ${p}")
        _price.value=p.toInt()
         updatePrice()
    }
    fun updatePrice(){

        _total.value=_price.value
        Log.d("uppdatePrice","버튼을 눌렸슴, ${_total.value}")
    }
    fun todotodo(todo : Itemview)
    {
        liveData.value=data
    }
    /*
    fun addPrice(todo : MutableList<PriceView>)
    {
        Log.d("addprice","${todo[0]}")
        pdata.add(todo[0])
    }
    */
    fun addData(todo: MutableList<Itemview>)
    {
        Log.d("data","${todo[0]}")
        data.add(todo[0])
        liveData.value=data
    }
    fun deleteData(todo : ArrayList<Itemview>)
    {
        data.remove(todo[0])
        liveData.value=data
    }
    fun get_price(p:String){
        setPrice(p)
    }
}