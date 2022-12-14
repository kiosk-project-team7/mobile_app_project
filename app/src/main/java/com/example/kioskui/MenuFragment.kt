package com.example.kioskui

import android.content.Context
import android.graphics.drawable.Drawable
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.MainActivity.menuInit.Companion.data
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.databinding.FragmentSetmenuBinding
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.kioskui.MainActivity.menuInit.Companion.check
import com.example.kioskui.MainActivity.menuInit.Companion.mprice
import com.example.kioskui.MainActivity.menuInit.Companion.pdata
import com.example.kioskui.MainActivity.menuInit.Companion.total_price

data class Itemview(
    val Menu: Drawable,
    val Menu_name: CharSequence,
    var number_count: String,
    var toping: String?,
    var drink: String?,
    var sidemenu: String?,
    var price: Int,
    var total_price: Int,
    )
data class PriceView(
    var tPrice : Double
)
class MenuFragment : Fragment() {

    private val sharedViewModel: OrderViewModel by activityViewModels()
    lateinit var binding: FragmentMenuBinding
    private var checkedItem: Int = 0
    private var setmenuFragment: SetmenuFragment? = null
    private var singleFragment: SingleFragment? = null
    private var sideFragment: SideFragment? = null
    private var drinkFragment: DrinkFragment? = null

    private lateinit var mainActivity : MainActivity

    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            menuFragemnt = this@MenuFragment
        }
        // ??????, ??????, ?????????, ?????? ????????? ?????? ?????? ??????
        binding.btn1.setOnClickListener {
            setmenuFragment = SetmenuFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, setmenuFragment!!).commit()
//            binding.btn1.setBackgroundColor()
        }
        binding.btn2.setOnClickListener {
            singleFragment = SingleFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, singleFragment!!).commit()
        }
        binding.btn3.setOnClickListener {
            sideFragment = SideFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, sideFragment!!).commit()
        }
        binding.btn4.setOnClickListener {
            drinkFragment = DrinkFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, drinkFragment!!).commit()
        }

        val recyclerView : RecyclerView = mainActivity.findViewById(R.id.step_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(mainActivity)

        //?????? ????????? ????????? ????????? ?????????.
        //binding.stepRecyclerview.layoutManager=recyclerView.layoutManager
        //binding.stepRecyclerview.layoutManager = LinearLayout(this)

            //val clickadapter = stepAdapter(data) //??? ?????? ??????.
            //binding.stepRecyclerview.adapter = stepAdapter(data)

                val mAdapter = stepAdapter(data, binding)
                binding.stepRecyclerview.adapter = mAdapter

                binding.stepRecyclerview.addItemDecoration(
                    DividerItemDecoration(mainActivity, LinearLayoutManager.VERTICAL)
                )
                sharedViewModel.liveData.observe(mainActivity, Observer {
                    (binding.stepRecyclerview.adapter as stepAdapter).setData(it as MutableList<Itemview>)

                })

        //?????? ????????? ????????? ?????? ??? ????????? ??????.
        /*
        binding.priceBtn.setOnClickListener {
            sharedViewModel.setPrice(total_price.toString())
            binding.priceText.visibility=(View.VISIBLE)
            if(total_price==0){
                binding.priceText.visibility=(View.INVISIBLE)
            }
        }

         */
        // ????????????, ?????? ?????? ????????? ????????????
        binding.backBtn.setOnClickListener {
            Toast.makeText(activity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.Fragment_Inout)
        }
        binding.comBtn.setOnClickListener {
            Toast.makeText(activity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
            //data.clear()
            (binding.stepRecyclerview.adapter as stepAdapter).remove_all()
            findNavController().navigate(R.id.Fragment_Pay)
        }


    }

    /*
    fun set_Price(Price : String)
    {
        var money = Price.toInt()
        var now_Price = binding.priceText.text.toString().toInt()
        binding.priceText.text=(money+now_Price).toString()
    }
    */
}