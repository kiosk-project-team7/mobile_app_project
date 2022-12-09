package com.example.kioskui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kioskui.databinding.FragmentMenuBinding


data class Itemview(
    val Menu: Int,
    val Menu_name: String?,
    val number_count: String, val toping: String?, val drink: String?, val sidemenu: String?)
class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding
    private var checkedItem: Int = 0
    private var str : String? = null
    private var setmenuFragment: SetmenuFragment? = null
    private var singleFragment: SingleFragment? = null
    private var sideFragment: SideFragment? = null
    private var drinkFragment: DrinkFragment? = null


    private lateinit var mainActivity: MainActivity

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
        val recyclerView: RecyclerView = mainActivity.findViewById(R.id.step_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(mainActivity)

            var data = arrayListOf<Itemview>()
            // 세트, 단품, 사이드, 음료 누르면 음식 종류 변경
            binding.btn1.setOnClickListener {
                setmenuFragment = SetmenuFragment()
                Log.d("exit", "setmenu 프래그먼트를 들어갔습니다")
                mainActivity.fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment1, setmenuFragment!!).commit()
                Log.d("exit", "세트메뉴 프래그먼트를 나갔습니다")
                //todo 데이터넣기
            }
            binding.btn2.setOnClickListener {
                singleFragment = SingleFragment()
                Log.d("exit", "단품 프래그먼트를 나갔습니다")
                mainActivity.fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment1, singleFragment!!).commit()
                Log.d("exit", "단품 프래그먼트를 나갔습니다")
                Log.d("햄버거", "data에 햄버거가 들어갔습니다 : ${data}")
            }
            binding.btn3.setOnClickListener {
                sideFragment = SideFragment()
                Log.d("exit", "sidemenu 프래그먼트를 들어갔습니다")
                mainActivity.fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment1, sideFragment!!).commit()
                Log.d("exit", "sidemenu 프래그먼트를 나갔습니다")
            }
            binding.btn4.setOnClickListener {
                drinkFragment = DrinkFragment()
                Log.d("exit", "음료 프래그먼트를 나갔습니다")
                mainActivity.fragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment1, drinkFragment!!).commit()
                Log.d("exit", "음료 프래그먼트를 나갔습니다")
            }


            binding.stepRecyclerview.adapter = stepAdapter(data)
            binding.stepRecyclerview.addItemDecoration(
                DividerItemDecoration(mainActivity, LinearLayoutManager.VERTICAL)
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