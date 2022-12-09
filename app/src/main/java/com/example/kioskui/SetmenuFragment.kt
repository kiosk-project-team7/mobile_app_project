package com.example.kioskui

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

import com.example.kioskui.databinding.FragmentSetmenuBinding
import com.example.kioskui.model.OrderViewModel
import androidx.fragment.app.activityViewModels
import com.example.kioskui.MainActivity.menuInit.Companion.count

//

class SetmenuFragment : Fragment() {
    private val sharedViewModel : OrderViewModel by activityViewModels()
    private lateinit var binding: FragmentSetmenuBinding
    //    private var checkedItem: Int = 0

    private var menuFragment: MenuFragment? = null

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
        binding = FragmentSetmenuBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.apply{
            lifecycleOwner =viewLifecycleOwner
            viewModel = sharedViewModel
            setmenuFragemnt = this@SetmenuFragment
        }
        var dataset : ArrayList<Itemview>
        // 메뉴 사진 누르면 다이얼로그
        binding.menu1Img.setOnClickListener {
            dialog(binding.menu1Img.drawable, binding.menu1Txt.text)
        }

        binding.menu2Img.setOnClickListener {
            dialog(binding.menu2Img.drawable, binding.menu2Txt.text)
        }

        binding.menu3Img.setOnClickListener {
            dialog(binding.menu3Img.drawable, binding.menu3Txt.text)
        }

        binding.menu4Img.setOnClickListener {
            dialog(binding.menu4Img.drawable, binding.menu4Txt.text)
        }

        binding.menu5Img.setOnClickListener {
            dialog(binding.menu5Img.drawable, binding.menu5Txt.text)
        }

        binding.menu6Img.setOnClickListener {
            dialog(binding.menu6Img.drawable, binding.menu6Txt.text)
        }

        binding.menu7Img.setOnClickListener {
            dialog(binding.menu7Img.drawable, binding.menu7Txt.text)
        }

        binding.menu8Img.setOnClickListener {
            dialog(binding.menu8Img.drawable, binding.menu8Txt.text)
        }

        binding.menu9Img.setOnClickListener {
            dialog(binding.menu9Img.drawable, binding.menu9Txt.text)
        }

        binding.menu10Img.setOnClickListener {
            dialog(binding.menu10Img.drawable, binding.menu10Txt.text)
        }

        binding.menu11Img.setOnClickListener {
            dialog(binding.menu11Img.drawable, binding.menu11Txt.text)
        }

        binding.menu12Img.setOnClickListener {
            dialog(binding.menu12Img.drawable, binding.menu12Txt.text)
        }


    }

    // 클릭하면 화면 출력 함수
    private fun dialog(img: Drawable, tv: CharSequence){
        // 메뉴 선택 다이얼로그
        val data = ArrayList<Itemview>()
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog, null)

        val logo = cDialogView.findViewById<ImageView>(R.id.logo)
        val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
        val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)

        imageView.setImageDrawable(img)
        textView.setText(tv)


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
        cusButton.setOnClickListener {
            val c2DialogView =
                LayoutInflater.from(view?.context).inflate(R.layout.custom_option, null)
            val eventHandler = object : DialogInterface.OnClickListener{
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    if(p1 == DialogInterface.BUTTON_POSITIVE)
                    {

                        Toast.makeText(activity,"담기버튼을 눌렀습니다",Toast.LENGTH_SHORT).show()
                        //data.add(Itemview(R.drawable.side_01_21cm_cheesestick,textView.toString(),"1","피클","콜라","감자튀김"))
                        data.add(Itemview(img,tv,"1","피클","콜라","감자튀김"))
                        Log.d("data","${data}")
                        sharedViewModel.addData(data)
                        stepAdapter(data)
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
            }

//            mBuilder2?.setPositiveButton("담기",null)
//            mBuilder2?.setNegativeButton("닫기", null)
//            mBuilder2?.show()
        }

        // 추천 버튼 누를 시
        val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
        recButton.setOnClickListener {

        }
    }

}