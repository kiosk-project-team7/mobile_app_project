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
import com.example.kioskui.databinding.FragmentSideBinding
import com.example.kioskui.databinding.FragmentSingleBinding

class SideFragment : Fragment() {

    private lateinit var binding: FragmentSideBinding
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
        binding = FragmentSideBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 메뉴 사진 누르면 다이얼로그
        binding.apply{
            lifecycleOwner = viewLifecycleOwner
            viewModel = sharedViewModel
            sidemenuFragemnt = this@SideFragment
        }

        /*fun onclick(img : Drawable, ptext : TextView)
        {
            dialog(img,ptext.text)
            price = binding.menu1Prc.text.toString().toInt()
        }*/

        binding.menu1Img.setOnClickListener {
            price = binding.menu1Prc.text.toString().substring(0 until 4).toInt()
            menu_num=0
            dialog(binding.menu1Img.drawable, binding.menu1Txt.text, R.string.sidemenu1_txt)

        }

        binding.menu2Img.setOnClickListener {
            price = binding.menu2Prc.text.toString().substring(0 until 4).toInt()
            menu_num=1
            dialog(binding.menu2Img.drawable, binding.menu2Txt.text, R.string.sidemenu2_txt)

        }

        binding.menu3Img.setOnClickListener {
            price = binding.menu3Prc.text.toString().substring(0 until 4).toInt()
            menu_num=2
            dialog(binding.menu3Img.drawable, binding.menu3Txt.text, R.string.sidemenu3_txt)

        }

        binding.menu4Img.setOnClickListener {
            price = binding.menu4Prc.text.toString().substring(0 until 4).toInt()
            menu_num=3
            dialog(binding.menu4Img.drawable, binding.menu4Txt.text, R.string.sidemenu4_txt)

        }

        binding.menu5Img.setOnClickListener {
            price = binding.menu5Prc.text.toString().substring(0 until 4).toInt()
            menu_num=4
            dialog(binding.menu5Img.drawable, binding.menu5Txt.text, R.string.sidemenu5_txt)

        }

        binding.menu6Img.setOnClickListener {
            price = binding.menu6Prc.text.toString().substring(0 until 4).toInt()
            menu_num=5
            dialog(binding.menu6Img.drawable, binding.menu6Txt.text, R.string.sidemenu6_txt)

        }

        binding.menu7Img.setOnClickListener {
            price = binding.menu7Prc.text.toString().substring(0 until 4).toInt()
            menu_num=6
            dialog(binding.menu7Img.drawable, binding.menu7Txt.text, R.string.sidemenu7_txt)

        }

        binding.menu8Img.setOnClickListener {
            price = binding.menu8Prc.text.toString().substring(0 until 4).toInt()
            menu_num=7
            dialog(binding.menu8Img.drawable, binding.menu8Txt.text, R.string.sidemenu8_txt)

        }

        binding.menu9Img.setOnClickListener {
            price = binding.menu9Prc.text.toString().substring(0 until 4).toInt()
            menu_num=8
            dialog(binding.menu9Img.drawable, binding.menu9Txt.text, R.string.sidemenu9_txt)

        }

        binding.menu10Img.setOnClickListener {
            price = binding.menu10Prc.text.toString().substring(0 until 4).toInt()
            menu_num=9
            dialog(binding.menu10Img.drawable, binding.menu10Txt.text, R.string.sidemenu10_txt)

        }

        binding.menu11Img.setOnClickListener {
            price = binding.menu11Prc.text.toString().substring(0 until 4).toInt()
            menu_num=10
            dialog(binding.menu11Img.drawable, binding.menu11Txt.text, R.string.sidemenu11_txt)

        }

        binding.menu12Img.setOnClickListener {
            price = binding.menu12Prc.text.toString().substring(0 until 4).toInt()
            menu_num=11
            dialog(binding.menu12Img.drawable, binding.menu12Txt.text, R.string.sidemenu12_txt)

        }
    }

    fun init() {
        price = 0
        tprice = 0
        dprice = 0
        sprice = 0
        toppingtext = ""
        drinktext = ""
        sidetext = ""
    }

    // 클릭하면 화면 출력 함수
    @SuppressLint("ResourceType")
    private fun dialog(img: Drawable, tv: CharSequence, exp: Int) {
        // 메뉴 선택 다이얼로그
        val data = mutableListOf<Itemview>()
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog_side, null)

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

        val eventHandler = object : DialogInterface.OnClickListener {
            override fun onClick(p0: DialogInterface?, p1: Int) {

                if (p1 == DialogInterface.BUTTON_POSITIVE) {
                    Toast.makeText(activity, "담기버튼을 눌렀습니다", Toast.LENGTH_SHORT).show()
                    now_step_price = sprice + price
                    total_price += now_step_price
                    menu_opt = 0
                    whenSelected(menu_opt, menu_num)
                    data.add(
                        Itemview(
                            img,
                            tv,
                            "1",
                            toppingtext,
                            drinktext,
                            sidetext,
                            now_step_price,
                            now_step_price
                        )
                    )
                    init()
                    Log.d("data", "${data}")
                    sharedViewModel.addData(data)
                    sharedViewModel.setPrice(total_price.toString())
                    pdata.add(total_price.toString() + "원")
                    stepAdapter(data, FragmentMenuBinding.inflate(layoutInflater))

                } else if (p1 == DialogInterface.BUTTON_NEGATIVE) {
                    Toast.makeText(activity, "닫기버튼을 눌렀습니다", Toast.LENGTH_SHORT).show()
                }
            }
        }

        mBuilder?.setNegativeButton("닫기",null)
        mBuilder?.setPositiveButton("담기", eventHandler)
        mBuilder?.show()

    }
}
