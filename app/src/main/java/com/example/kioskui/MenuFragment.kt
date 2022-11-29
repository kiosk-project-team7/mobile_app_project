package com.example.kioskui

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.FragmentMenuBinding

data class Itemview(val Menu:String, val Menu_name : String, val number : String, val number_count : String, val price_text : String,val price : String)
class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
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

        // 세트, 단품, 사이드, 음료 누르면 음식 종류 변경
        binding.btn1.setOnClickListener {
            //새로운 navigation으로 메뉴 바꾸기
            setmenuFragment = SetmenuFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, setmenuFragment!!).commit()
        }
        binding.btn2.setOnClickListener {
            //새로운 navigation으로 메뉴 바꾸기
            singleFragment = SingleFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, singleFragment!!).commit()
        }
        binding.btn3.setOnClickListener {
            //새로운 navigation으로 메뉴 바꾸기
            sideFragment = SideFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, sideFragment!!).commit()
        }
        binding.btn4.setOnClickListener {
            //새로운 navigation으로 메뉴 바꾸기
            drinkFragment = DrinkFragment()
            mainActivity.fragmentManager.beginTransaction().replace(R.id.nav_host_fragment1, drinkFragment!!).commit()
        }

        val recyclerView : RecyclerView = mainActivity.findViewById(R.id.step_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        //binding.stepRecyclerview.layoutManager=recyclerView.layoutManager
        val data = ArrayList<Itemview>()
        for(i in 1..20) {
            data.add(Itemview("메뉴이름", "햄버거", "수량", "1", "가격", "10000원"))
            data.add(Itemview("메뉴이름", "햄버거", "수량", "1", "가격", "10000원"))
            data.add(Itemview("메뉴이름", "햄버거", "수량", "1", "가격", "10000원"))
            data.add(Itemview("메뉴이름", "햄버거", "수량", "1", "가격", "10000원"))
        }
        binding.stepRecyclerview.adapter=stepAdapter(data)
        binding.stepRecyclerview.addItemDecoration(
            DividerItemDecoration(mainActivity,LinearLayoutManager.VERTICAL)
        )


        // 돌아가기, 완료 버튼 누르면 넘어가기
        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Inout)
        }
        binding.comBtn.setOnClickListener {
            findNavController().navigate(R.id.Fragment_Pay)
        }

    }

}