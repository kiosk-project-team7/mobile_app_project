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
import com.example.kioskui.MainActivity.menuInit.Companion.detail
import com.example.kioskui.MainActivity.menuInit.Companion.dop
import com.example.kioskui.MainActivity.menuInit.Companion.menu_num
import com.example.kioskui.MainActivity.menuInit.Companion.menu_opt
import com.example.kioskui.databinding.FragmentSetmenuBinding
import com.example.kioskui.model.OrderViewModel
import com.example.kioskui.MainActivity.menuInit.Companion.mprice
import com.example.kioskui.MainActivity.menuInit.Companion.pdata
import com.example.kioskui.MainActivity.menuInit.Companion.selectedAmt
import com.example.kioskui.MainActivity.menuInit.Companion.sop
import com.example.kioskui.MainActivity.menuInit.Companion.stock
import com.example.kioskui.MainActivity.menuInit.Companion.top
import com.example.kioskui.MainActivity.menuInit.Companion.total_num
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
    var string =""
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

        // ?????? ?????? ????????? ???????????????
        binding.apply{
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            singlemenuFragemnt= this@SingleFragment
        }

        for(i in 0 until 12){
            Log.d("test","${i}")
            if(stock[0][i]==0){
                when(i){
                    0 -> {
                        Log.d("test","????????? ??????????????????:")
                        binding.menu1Img.alpha = 0.3f

                    }
                    1 ->{
                        binding.menu2Img.alpha=0.3f

                    }
                    2 -> {
                        Log.d("test","????????? ??????????????????:")
                        binding.menu3Img.alpha = 0.3f

                    }
                    3 ->{
                        binding.menu4Img.alpha=0.3f

                    }
                    4 -> {
                        Log.d("test","????????? ??????????????????:")
                        binding.menu5Img.alpha = 0.3f

                    }
                    5 ->{
                        binding.menu6Img.alpha=0.3f

                    }
                    6 -> {
                        Log.d("test","????????? ??????????????????:")
                        binding.menu7Img.alpha = 0.3f

                    }
                    7 ->{
                        binding.menu8Img.alpha=0.3f

                    }
                    8 -> {
                        Log.d("test","????????? ??????????????????:")
                        binding.menu9Img.alpha = 0.3f

                    }
                    9 ->{
                        binding.menu10Img.alpha=0.3f

                    }
                    10 -> {
                        Log.d("test","????????? ??????????????????:")
                        binding.menu11Img.alpha = 0.3f

                    }
                    11 ->{
                        binding.menu12Img.alpha=0.3f
                    }
                }
            }
        }

        binding.menu1Img.setOnClickListener {
            string = binding.menu1Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            Log.d("price ", "${price}")
            menu_num=0
            dialog(binding.menu1Img.drawable, binding.menu1Txt.text, R.string.menu1_txt)

        }

        binding.menu2Img.setOnClickListener {
            string = binding.menu2Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=1
            dialog(binding.menu2Img.drawable, binding.menu2Txt.text, R.string.menu2_txt)

        }

        binding.menu3Img.setOnClickListener {
            string = binding.menu3Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=2
            dialog(binding.menu3Img.drawable, binding.menu3Txt.text, R.string.menu3_txt)

        }

        binding.menu4Img.setOnClickListener {
            string = binding.menu4Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=3
            dialog(binding.menu4Img.drawable, binding.menu4Txt.text, R.string.menu4_txt)

        }

        binding.menu5Img.setOnClickListener {
            string = binding.menu5Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=4
            dialog(binding.menu5Img.drawable, binding.menu5Txt.text, R.string.menu5_txt)

        }

        binding.menu6Img.setOnClickListener {
            string = binding.menu6Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=5
            dialog(binding.menu6Img.drawable, binding.menu6Txt.text, R.string.menu6_txt)

        }

        binding.menu7Img.setOnClickListener {
            string = binding.menu7Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=6
            dialog(binding.menu7Img.drawable, binding.menu7Txt.text, R.string.menu7_txt)

        }

        binding.menu8Img.setOnClickListener {
            string = binding.menu8Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=7
            dialog(binding.menu8Img.drawable, binding.menu8Txt.text, R.string.menu8_txt)

        }

        binding.menu9Img.setOnClickListener {
            string = binding.menu9Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=8
            dialog(binding.menu9Img.drawable, binding.menu9Txt.text, R.string.menu9_txt)

        }

        binding.menu10Img.setOnClickListener {
            string = binding.menu10Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=9
            dialog(binding.menu10Img.drawable, binding.menu10Txt.text, R.string.menu10_txt)

        }

        binding.menu11Img.setOnClickListener {
            string = binding.menu11Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=10
            dialog(binding.menu11Img.drawable, binding.menu11Txt.text, R.string.menu11_txt)

        }

        binding.menu12Img.setOnClickListener {
             string = binding.menu12Prc.text.toString().substring(0 until 4)
            price = binding.menu12Prc.text.toString().toInt()
            menu_num=11
            dialog(binding.menu12Img.drawable, binding.menu12Txt.text, R.string.menu12_txt)

        }
    }

    fun init(){
        tprice=0
        dprice=0
        sprice=0
        toppingtext=""
        drinktext=""
        sidetext=""
    }
    // ???????????? ?????? ?????? ??????
    @SuppressLint("ResourceType")
    private fun dialog(img: Drawable, tv: CharSequence, exp: Int){
        // ?????? ?????? ???????????????
        val data = mutableListOf<Itemview>()
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog, null)

        val logo = cDialogView.findViewById<ImageView>(R.id.logo)
        val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
        val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)
        val menuName = cDialogView.findViewById<TextView>(R.id.menuname)
        val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)

        val string = getString(exp)

        imageView.setImageDrawable(img)
        menuName.setText(tv)
        textView.setText(string)
        cusButton.setText("?????? ??????")

        val mBuilder = view?.let {
            AlertDialog.Builder(it.context)
                .setView(cDialogView)
                .setTitle(tv)
                .setIcon(logo.drawable)
        }
        val eventHandler2 = object : DialogInterface.OnClickListener{
            override fun onClick(p0: DialogInterface?, p1: Int) {

                if(p1 == DialogInterface.BUTTON_POSITIVE)
                {
                    Toast.makeText(activity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
                    now_step_price=dprice+sprice+tprice+price
                    total_price+=now_step_price
                    menu_opt=0
//                    total_num++
                    stock[menu_opt][menu_num]--
                    selectedAmt[4][menu_num]++
                    data.add(Itemview(img,tv,"1",toppingtext,drinktext,sidetext,now_step_price,now_step_price))
                    init()
                    total_num++
                    Log.d("data","${data}")
                    sharedViewModel.addData(data)
                    sharedViewModel.setPrice(total_price.toString())
                    pdata.add(total_price.toString()+"???")
                    stepAdapter(data, FragmentMenuBinding.inflate(layoutInflater))
                }
                else if(p1==DialogInterface.BUTTON_NEGATIVE){
                    Toast.makeText(activity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
                }
            }
        }
        mBuilder?.setPositiveButton("?????? ??????",eventHandler2)
        mBuilder?.setNegativeButton("??????", null)
        mBuilder?.show()

        // ???????????? ?????? ?????? ??? ???????????????

        cusButton.setOnClickListener {
            val c2DialogView =
                LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog_single, null)

            val eventHandler = object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    if(p1 == DialogInterface.BUTTON_POSITIVE)
                    {
                        Toast.makeText(activity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
                        now_step_price=dprice+sprice+tprice+price
                        total_price+=now_step_price
                        menu_opt=0
                        total_num++
                        //whenSelected(menu_opt, menu_num)
                        stock[menu_opt][menu_num]--
                        selectedAmt[4][menu_num]++
                        selectedAmt[3][top]++
                        data.add(Itemview(img,tv,"1",toppingtext,drinktext,sidetext,now_step_price,now_step_price))
                        init()
                        Log.d("data","${data}")
                        sharedViewModel.addData(data)
                        sharedViewModel.setPrice(total_price.toString())
                        pdata.add(total_price.toString()+"???")
                        stepAdapter(data, FragmentMenuBinding.inflate(layoutInflater))
                    }
                    else if(p1==DialogInterface.BUTTON_NEGATIVE){
                        Toast.makeText(activity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
                    }
                }
            }

            val mBuilder2 = view?.let {
                AlertDialog.Builder(it.context)
                    .setView(c2DialogView)
                    .setTitle("????????????")
                    .setIcon(logo.drawable)
                    .setPositiveButton("??????", eventHandler)
                    .setNegativeButton("??????", eventHandler)
                    .show()
                //??????
                val trdg1 = c2DialogView.findViewById<RadioGroup>(R.id.toppingrg1)

                val trb1 = c2DialogView.findViewById<RadioButton>(R.id.topping1rb)
                val trb2 = c2DialogView.findViewById<RadioButton>(R.id.topping2rb)
                val trb3 = c2DialogView.findViewById<RadioButton>(R.id.topping3rb)
                val trb4 = c2DialogView.findViewById<RadioButton>(R.id.topping4rb)
                val trb5 = c2DialogView.findViewById<RadioButton>(R.id.topping5rb)


                trdg1.setOnCheckedChangeListener { radioGroup, checkedId ->
                    Log.d("radio", "????????? ????????????")
                    if (trb1.isChecked == true || trb2.isChecked == true || trb3.isChecked == true ||  trb4.isChecked == true || trb5.isChecked==true) {
                        when (checkedId) {
                            R.id.topping1rb -> {
                                toppingtext = "?????????"
                                tprice = 500
                                top=1
                            }
                            R.id.topping2rb -> {
                                toppingtext = "??????"
                                tprice = 500
                                top=2
                            }
                            R.id.topping3rb -> {
                                toppingtext = "?????????"
                                tprice = 300
                                top=3
                            }
                            R.id.topping4rb -> {
                                toppingtext = "?????????"
                                tprice = 300
                                top=4
                            }
                            R.id.topping5rb -> {
                                toppingtext = "??????"
                                tprice = 300
                                top=5
                            }
                        }
                    }
                }
            }
        }

        // ?????? ?????? ?????? ???
        val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)

        recButton.setOnClickListener {
            Toast.makeText(mainActivity,"??????????????? ???????????????",Toast.LENGTH_SHORT).show()
            tprice=500
            now_step_price=dprice+sprice+tprice+price
            total_price+=now_step_price
            menu_opt=0
            total_num++
            init()
            stock[menu_opt][menu_num]--
            selectedAmt[4][menu_num]++
            data.add(Itemview(img,tv,"1","?????????","","",now_step_price,now_step_price))
            Log.d("data","${data}")
            sharedViewModel.addData(data)
            sharedViewModel.setPrice(total_price.toString())
            pdata.add(total_price.toString()+"???")
            stepAdapter(data, FragmentMenuBinding.inflate(layoutInflater))

        }
    }


}