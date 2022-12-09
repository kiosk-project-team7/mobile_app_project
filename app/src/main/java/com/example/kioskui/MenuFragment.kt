package com.example.kioskui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.FragmentMenuBinding
//view model import
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
data class Itemview(
    val Menu: Int,
    val Menu_name: String,
    val number_count: String, val toping: String, val drink: String, val sidemenu: String)
//var <property-name> : <property-type> by <delegate-class>()

class MenuFragment : Fragment() {
    private val sharedViewModel : OrderViewModel by activityViewModels()
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
        binding?.apply {
            lifecycleOwner=viewLifecycleOwner
            viewModel=sharedViewModel
            menuFragemnt=this@MenuFragment
        }
        // 세트, 단품, 사이드, 음료 누르면 음식 종류 변경
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
        //위에 코드는 스크롤 방향을 나타냄.
        //binding.stepRecyclerview.layoutManager=recyclerView.layoutManager
        val data = ArrayList<Itemview>()
        for(i in 1..20) {
            //data.add(Itemview(R.drawable.single_01_black_onion_chicken,"햄버거","1","피클","콜라","감자튀김"))
            //data.add(Itemview(R.drawable.side_01_21cm_cheesestick,))
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