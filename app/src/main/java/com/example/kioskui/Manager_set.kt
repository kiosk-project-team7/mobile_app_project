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
import com.example.kioskui.MainActivity.menuInit.Companion.selectedAmt
import com.example.kioskui.MainActivity.menuInit.Companion.stock
import com.example.kioskui.MainActivity.menuInit.Companion.total_num
import com.example.kioskui.MainActivity.menuInit.Companion.total_price
import com.example.kioskui.MainActivity.menuInit.Companion.whenSelected
import com.example.kioskui.databinding.FragmentManagerSetBinding
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.databinding.FragmentSingleBinding

class Manager_set : Fragment() {

    private lateinit var binding: FragmentManagerSetBinding
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
        binding = FragmentManagerSetBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 메뉴 사진 누르면 다이얼로그



        binding.menu1Img.setOnClickListener {
            string = binding.menu1Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            Log.d("price ", "${price}")
            menu_num=0
            dialog(binding.menu1Img.drawable, binding.menu1Txt.text)

        }

        binding.menu2Img.setOnClickListener {
            string = binding.menu2Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=1
            dialog(binding.menu2Img.drawable, binding.menu2Txt.text)

        }

        binding.menu3Img.setOnClickListener {
            string = binding.menu3Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=2
            dialog(binding.menu3Img.drawable, binding.menu3Txt.text)

        }

        binding.menu4Img.setOnClickListener {
            string = binding.menu4Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=3
            dialog(binding.menu4Img.drawable, binding.menu4Txt.text)

        }

        binding.menu5Img.setOnClickListener {
            string = binding.menu5Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=4
            dialog(binding.menu5Img.drawable, binding.menu5Txt.text)

        }

        binding.menu6Img.setOnClickListener {
            string = binding.menu6Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=5
            dialog(binding.menu6Img.drawable, binding.menu6Txt.text)

        }

        binding.menu7Img.setOnClickListener {
            string = binding.menu7Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=6
            dialog(binding.menu7Img.drawable, binding.menu7Txt.text)

        }

        binding.menu8Img.setOnClickListener {
            string = binding.menu8Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=7
            dialog(binding.menu8Img.drawable, binding.menu8Txt.text)

        }

        binding.menu9Img.setOnClickListener {
            string = binding.menu9Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=8
            dialog(binding.menu9Img.drawable, binding.menu9Txt.text)

        }

        binding.menu10Img.setOnClickListener {
            string = binding.menu10Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=9
            dialog(binding.menu10Img.drawable, binding.menu10Txt.text)

        }

        binding.menu11Img.setOnClickListener {
            string = binding.menu11Prc.text.toString().substring(0 until 4)
            price = string.toInt()
            menu_num=10
            dialog(binding.menu11Img.drawable, binding.menu11Txt.text)

        }

        binding.menu12Img.setOnClickListener {
            string = binding.menu12Prc.text.toString().substring(0 until 4)
            price = binding.menu12Prc.text.toString().toInt()
            menu_num=11
            dialog(binding.menu12Img.drawable, binding.menu12Txt.text)

        }
    }

    // 클릭하면 화면 출력 함수
    @SuppressLint("ResourceType", "MissingInflatedId")
    private fun dialog(img: Drawable, tv: CharSequence) {
        // 메뉴 선택 다이얼로그
        val data = mutableListOf<Itemview>()
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.manager_detail, null)

        val logo = cDialogView.findViewById<ImageView>(R.id.logo)
        val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
        val menuName = cDialogView.findViewById<TextView>(R.id.menuname)
        val priceView = cDialogView.findViewById<TextView>(R.id.detail_price)
        priceView.text=price.toString()+"원"
        imageView.setImageDrawable(img)
        menuName.setText(tv)
        val numView = cDialogView.findViewById<TextView>(R.id.detail_count)
        val profit =cDialogView.findViewById<TextView>(R.id.detail_profit)
        profit.setText("${selectedAmt[0][menu_num]*price}원")
        numView.setText("${stock[0][menu_num]}개")

        val mBuilder = view?.let {
            AlertDialog.Builder(it.context)
                .setView(cDialogView)
                .setTitle(tv)
                .setIcon(logo.drawable)
        }


        mBuilder?.setNegativeButton("닫기", null)
        mBuilder?.show()

        // 사용자화 버튼 선택 시 다이얼로그
    }

}