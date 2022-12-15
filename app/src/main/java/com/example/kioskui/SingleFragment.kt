package com.example.kioskui

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.kioskui.MainActivity.menuInit.Companion.menu_num
import com.example.kioskui.MainActivity.menuInit.Companion.menu_opt
import com.example.kioskui.databinding.FragmentSetmenuBinding
import com.example.kioskui.model.OrderViewModel
import com.example.kioskui.MainActivity.menuInit.Companion.mprice
import com.example.kioskui.MainActivity.menuInit.Companion.pdata
import com.example.kioskui.MainActivity.menuInit.Companion.total_price
import com.example.kioskui.MainActivity.menuInit.Companion.whenSelected
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.databinding.FragmentSingleBinding

class SingleFragment : Fragment() {

    private lateinit var binding: FragmentSingleBinding
    private val sharedViewModel : OrderViewModel by activityViewModels()
//    private var checkedItem: Int = 0

    private lateinit var mainActivity : MainActivity
    private var toppingtext : String = " "
    private var sidetext : String = " "
    private var drinktext : String = " "
    private var menuFragment: MenuFragment? = null
    var price =0
    var tprice=0
    var sprice =0
    var dprice=0
    var now_step_price=0
    override fun onAttach(context: Context) {
        super.onAttach(context)

        mainActivity = context as MainActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSingleBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 메뉴 사진 누르면 다이얼로그
        binding.apply{
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            singlemenuFragemnt= this@SingleFragment
        }

       /* fun onclick(img : Drawable, ptext : TextView)
        {
           when(img){
               binding.menu1Img ->{

               }
               binding.menu2Img->{

               }

           }
            price = binding.menu1Prc.text.toString().toInt()
            dialog(img,ptext.text,R.string.menu1_txt)

        }*/
        binding.menu1Img.setOnClickListener {
            price = binding.menu1Prc.text.toString().toInt()
            menu_num=0
            dialog(binding.menu1Img.drawable, binding.menu1Txt.text, R.string.menu1_txt)

        }

        binding.menu2Img.setOnClickListener {
            price = binding.menu2Prc.text.toString().toInt()
            menu_num=1
            dialog(binding.menu2Img.drawable, binding.menu2Txt.text, R.string.menu2_txt)

        }

        binding.menu3Img.setOnClickListener {
            price = binding.menu3Prc.text.toString().toInt()
            menu_num=2
            dialog(binding.menu3Img.drawable, binding.menu3Txt.text, R.string.menu3_txt)

        }

        binding.menu4Img.setOnClickListener {
            price = binding.menu4Prc.text.toString().toInt()
            menu_num=3
            dialog(binding.menu4Img.drawable, binding.menu4Txt.text, R.string.menu4_txt)

        }

        binding.menu5Img.setOnClickListener {
            price = binding.menu5Prc.text.toString().toInt()
            menu_num=4
            dialog(binding.menu5Img.drawable, binding.menu5Txt.text, R.string.menu5_txt)

        }

        binding.menu6Img.setOnClickListener {
            price = binding.menu6Prc.text.toString().toInt()
            menu_num=5
            dialog(binding.menu6Img.drawable, binding.menu6Txt.text, R.string.menu6_txt)

        }

        binding.menu7Img.setOnClickListener {
            price = binding.menu7Prc.text.toString().toInt()
            menu_num=6
            dialog(binding.menu7Img.drawable, binding.menu7Txt.text, R.string.menu7_txt)

        }

        binding.menu8Img.setOnClickListener {
            price = binding.menu8Prc.text.toString().toInt()
            menu_num=7
            dialog(binding.menu8Img.drawable, binding.menu8Txt.text, R.string.menu8_txt)

        }

        binding.menu9Img.setOnClickListener {
            price = binding.menu9Prc.text.toString().toInt()
            menu_num=8
            dialog(binding.menu9Img.drawable, binding.menu9Txt.text, R.string.menu9_txt)

        }

        binding.menu10Img.setOnClickListener {
            price = binding.menu10Prc.text.toString().toInt()
            menu_num=9
            dialog(binding.menu10Img.drawable, binding.menu10Txt.text, R.string.menu10_txt)

        }

        binding.menu11Img.setOnClickListener {
            price = binding.menu11Prc.text.toString().toInt()
            menu_num=10
            dialog(binding.menu11Img.drawable, binding.menu11Txt.text, R.string.menu11_txt)

        }

        binding.menu12Img.setOnClickListener {
            var string = binding.menu12Prc.text.toString().substring(0 until 3)
            price = binding.menu12Prc.text.toString().toInt()
            menu_num=11
            dialog(binding.menu12Img.drawable, binding.menu12Txt.text, R.string.menu12_txt)

        }
    }

    // 클릭하면 화면 출력 함수
    @SuppressLint("ResourceType")
    private fun dialog(img: Drawable, tv: CharSequence, exp: Int){
        // 메뉴 선택 다이얼로그
        val data = mutableListOf<Itemview>()
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog, null)

        val logo = cDialogView.findViewById<ImageView>(R.id.logo)
        val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
        val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)
        val menuName = cDialogView.findViewById<TextView>(R.id.menuname)

        val string = getString(exp)

        imageView.setImageDrawable(img)
        menuName.setText(tv)
        textView.setText(string)

        val mBuilder = view?.let {
            AlertDialog.Builder(it.context)
                .setView(cDialogView)
                .setTitle(tv)
                .setIcon(logo.drawable)
        }


        mBuilder?.setNegativeButton("닫기", null)
        mBuilder?.show()

        // 사용자화 버튼 선택 시 다이얼로그
        val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
        fun init(){
            price=0
            tprice=0
            dprice=0
            sprice=0
            toppingtext=""
            drinktext=""
            sidetext=""
        }
        cusButton.setOnClickListener {
            val c2DialogView =
                LayoutInflater.from(view?.context).inflate(R.layout.custom_option, null)

            val eventHandler = object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    if(p1 == DialogInterface.BUTTON_POSITIVE)
                    {
                        Toast.makeText(activity,"담기버튼을 눌렀습니다",Toast.LENGTH_SHORT).show()
                        now_step_price=dprice+sprice+tprice+price
                        total_price+=now_step_price
                        menu_opt=0
                        whenSelected(menu_opt, menu_num)
                        data.add(Itemview(img,tv,"1",toppingtext,drinktext,sidetext,now_step_price,now_step_price))
                        init()
                        Log.d("data","${data}")
                        sharedViewModel.addData(data)
                        sharedViewModel.setPrice(total_price.toString())
                        pdata.add(total_price.toString()+"원")
                        stepAdapter(data, FragmentMenuBinding.inflate(layoutInflater))

                    }
                    else if(p1==DialogInterface.BUTTON_NEGATIVE){
                        Toast.makeText(activity,"닫기버튼을 눌렀습니다",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            val mBuilder2 = view?.let {
                AlertDialog.Builder(it.context)
                    .setView(c2DialogView)
                    .setTitle("사용자화")
                    .setIcon(logo.drawable)
                    .setPositiveButton("담기",eventHandler)
                    .setNegativeButton("닫기", eventHandler)
                    .show()
                //토핑
                val trdg1 = c2DialogView.findViewById<RadioGroup>(R.id.toppingrg1)
                val trdg2 = c2DialogView.findViewById<RadioGroup>(R.id.toppingrg2)
                val srdg1 = c2DialogView.findViewById<RadioGroup>(R.id.siderg1)
                val srdg2 = c2DialogView.findViewById<RadioGroup>(R.id.siderg2)
                val drdg1 = c2DialogView.findViewById<RadioGroup>(R.id.drinkrg1)
                val drdg2 = c2DialogView.findViewById<RadioGroup>(R.id.drinkrg2)
                val trb1 = c2DialogView.findViewById<RadioButton>(R.id.topping1rb)
                val trb2 = c2DialogView.findViewById<RadioButton>(R.id.topping2rb)
                val trb3 = c2DialogView.findViewById<RadioButton>(R.id.topping3rb)
                val trb4 = c2DialogView.findViewById<RadioButton>(R.id.topping4rb)
                val trb5 = c2DialogView.findViewById<RadioButton>(R.id.topping5rb)

                //side menu
                val srb1 = c2DialogView.findViewById<RadioButton>(R.id.side1rb)
                val srb2 = c2DialogView.findViewById<RadioButton>(R.id.side2rb)
                val srb3 = c2DialogView.findViewById<RadioButton>(R.id.side3rb)
                val srb4 = c2DialogView.findViewById<RadioButton>(R.id.side4rb)
                val srb5 = c2DialogView.findViewById<RadioButton>(R.id.side5rb)
                val srb6 = c2DialogView.findViewById<RadioButton>(R.id.side6rb)
                val srb7 = c2DialogView.findViewById<RadioButton>(R.id.side7rb)
                val srb8 = c2DialogView.findViewById<RadioButton>(R.id.side8rb)

                //음료
                val drb1 = c2DialogView.findViewById<RadioButton>(R.id.drink1rb)
                val drb2 = c2DialogView.findViewById<RadioButton>(R.id.drink2rb)
                val drb3 = c2DialogView.findViewById<RadioButton>(R.id.drink3rb)
                val drb4 = c2DialogView.findViewById<RadioButton>(R.id.drink4rb)
                val drb5 = c2DialogView.findViewById<RadioButton>(R.id.drink5rb)
                val drb6 = c2DialogView.findViewById<RadioButton>(R.id.drink6rb)
                val drb7 = c2DialogView.findViewById<RadioButton>(R.id.drink7rb)
                val drb8 = c2DialogView.findViewById<RadioButton>(R.id.drink8rb)

                trdg1.setOnCheckedChangeListener { radioGroup, checkedId ->
                    Log.d("radio", "첫번째 사이드줄")
                    if(trb1.isChecked==true || trb2.isChecked==true || trb3.isChecked==true || trb4.isChecked==true) {
                        when(checkedId) {
                            R.id.topping1rb -> {
                                toppingtext = "베이컨"
                                tprice= 500
                            }
                            R.id.topping2rb -> {
                                toppingtext = "치즈"
                                tprice=500
                            }
                            R.id.topping3rb -> {
                                toppingtext = "양상추"
                                tprice=300
                            }
                            R.id.topping4rb -> {
                                toppingtext = "토마토"
                                tprice=300
                            }
                        }
                        if (trb5.isChecked)
                            trb5.isChecked = false
                    }
                }
                trdg2.setOnCheckedChangeListener { radioGroup, checkedId ->
                    Log.d("radio", "두번째 사이드줄")
                    if(trb5.isChecked) {
                        when(checkedId) {
                            R.id.topping5rb -> {
                                toppingtext = "피클"
                                tprice=300
                            }
                        }
                        if (trb1.isChecked)
                            trb1.isChecked = false
                        if (trb2.isChecked)
                            trb2.isChecked = false
                        if (trb3.isChecked)
                            trb3.isChecked = false
                        if (trb4.isChecked)
                            trb4.isChecked = false
                    }
                }

                srdg1.setOnCheckedChangeListener { radioGroup, checkedId ->
                    Log.d("radio", "첫번째 사이드줄")
                    if(srb1.isChecked==true || srb2.isChecked==true || srb3.isChecked==true || srb4.isChecked==true) {
                        when(checkedId) {
                            R.id.side1rb -> {
                                sidetext = "치즈스틱"
                                sprice=mprice[2][0]
                            }
                            R.id.side2rb -> {
                                sidetext = "치킨너겟"
                                sprice= mprice[2][1]
                            }
                            R.id.side3rb -> {
                                sidetext = "바삭킹"
                                sprice = mprice[2][2]
                            }
                            R.id.side4rb -> {
                                sidetext = "치즈감자"
                                sprice=mprice[2][3]
                            }
                        }
                        if (srb5.isChecked)
                            srb5.isChecked = false
                        if (srb6.isChecked)
                            srb6.isChecked = false
                        if (srb7.isChecked)
                            srb7.isChecked = false
                        if (srb8.isChecked)
                            srb8.isChecked = false
                    }
                }
                srdg2.setOnCheckedChangeListener { radioGroup, checkedId ->
                    Log.d("radio", "두번째 사이드줄")
                    if(srb5.isChecked==true || srb6.isChecked==true || srb7.isChecked==true || srb8.isChecked==true) {
                        when(checkedId) {
                            R.id.side5rb -> {
                                sidetext = "코올슬로"
                                sprice=mprice[2][4]
                            }
                            R.id.side6rb -> {
                                sidetext = "치즈볼"
                                sprice=mprice[2][5]
                            }
                            R.id.side7rb -> {
                                sidetext = "감자튀김(L)"
                                sprice=mprice[2][6]
                            }
                            R.id.side8rb -> {
                                sidetext = "감자튀김(R)"
                                sprice=mprice[2][7]
                            }
                        }
                        if (srb1.isChecked)
                            srb1.isChecked = false
                        if (srb2.isChecked)
                            srb2.isChecked = false
                        if (srb3.isChecked)
                            srb3.isChecked = false
                        if (srb4.isChecked)
                            srb4.isChecked = false
                    }
                }
                drdg1.setOnCheckedChangeListener { radioGroup, checkedId ->
                    if(drb1.isChecked==true || drb2.isChecked==true || drb3.isChecked==true || drb4.isChecked==true) {
                        when(checkedId) {
                            R.id.drink1rb -> {
                                drinktext = "홍차"
                                dprice= mprice[3][0]
                            }
                            R.id.drink2rb ->{
                                drinktext = "커피"
                                dprice= mprice[3][1]
                            }
                            R.id.drink3rb -> {
                                drinktext = "콜라(R)"
                                dprice=mprice[3][2]
                            }
                            R.id.drink4rb -> {
                                drinktext = "콜라(L)"
                                dprice=mprice[3][3]
                            }
                        }
                        if (drb5.isChecked)
                            drb5.isChecked = false
                        if (drb6.isChecked)
                            drb6.isChecked = false
                        if (drb7.isChecked)
                            drb7.isChecked = false
                        if (drb8.isChecked)
                            drb8.isChecked = false
                    }
                }
                drdg2.setOnCheckedChangeListener { radioGroup, checkedId ->
                    if(drb5.isChecked==true || drb6.isChecked==true || drb7.isChecked==true || drb8.isChecked==true) {
                        when(checkedId) {
                            R.id.drink5rb -> {
                                drinktext = "제로콜라(R)"
                                dprice=mprice[3][4]
                            }
                            R.id.drink6rb -> {
                                drinktext = "제로콜라(L)"
                                dprice=mprice[3][5]
                            }
                            R.id.drink7rb -> {
                                drinktext = "오렌지주스"
                                dprice= mprice[3][6]
                            }
                            R.id.drink8rb -> {
                                drinktext = "시그렘"
                                dprice= mprice[3][7]
                            }
                        }
                        if (drb1.isChecked)
                            drb1.isChecked = false
                        if (drb2.isChecked)
                            drb2.isChecked = false
                        if (drb3.isChecked)
                            drb3.isChecked = false
                        if (drb4.isChecked)
                            drb4.isChecked = false
                    }
                }
            }
        }

        // 추천 버튼 누를 시
        val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
        recButton.setOnClickListener {
            Toast.makeText(mainActivity,"추천버튼을 눌렀습니다",Toast.LENGTH_SHORT).show()

        }
    }

}