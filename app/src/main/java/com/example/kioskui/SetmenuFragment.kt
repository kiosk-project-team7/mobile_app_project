package com.example.kioskui

import android.annotation.SuppressLint
import android.app.AlertDialog.THEME_DEVICE_DEFAULT_LIGHT
import android.app.AlertDialog.THEME_HOLO_LIGHT
import android.app.ProgressDialog.show
import android.content.DialogInterface
import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.content.res.AppCompatResources.getDrawable
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kioskui.databinding.FragmentMenuBinding
import com.example.kioskui.databinding.FragmentSetmenuBinding

class SetmenuFragment : Fragment() {

    private lateinit var binding: FragmentSetmenuBinding
    private var checkedItem: Int = 0

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

        // 메뉴 사진 누르면 다이얼로그
        binding.menu1Img.setOnClickListener {
            val cDialogView =
                LayoutInflater.from(view.context).inflate(R.layout.custom_dialog, null)

            val drawable = getDrawable(view.context ,R.drawable.set_01_black_onion_chicken)
            val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
            val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)
            imageView.setImageDrawable(drawable)
            textView.setText("메뉴1 설명-----")

            val mBuilder = AlertDialog.Builder(view.context)
                .setView(cDialogView)
                .setTitle("블랙어니언치킨버거 세트")
                .setIcon(drawable)
                .setPositiveButton("바로 담기", null)
                
            val burgerName = "블랙어니언치킨버거 세트"

            mBuilder.setNegativeButton("닫기", null)
            mBuilder.show()

            val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
            cusButton.setOnClickListener {
                val items =
                    arrayOf<String>("추가옵션 선택 안함", "치즈 추가", "패티 추가", "베이컨 추가", "양상추 추가", "00추가", "00추가", "00추가")

                AlertDialog.Builder(view.context, R.style.Theme_KioskUI_Alert).run {
                    setTitle("블랙어니언치킨버거 세트")
                    setIcon(R.drawable.set_01_black_onion_chicken)
                    setSingleChoiceItems(items,
                        checkedItem,
                        object : DialogInterface.OnClickListener {
                            override fun onClick(
                                p0: DialogInterface?,
                                which: Int,
                            ) {
                                Log.d("선택", "${items[which]}이 선택되었습니다.")
                                textView.setText("${burgerName}에 ${items[which]} 옵션을 선택하셨습니다.")
                                //textView.setText("${burgerName}")
                            }
                        })
                    setPositiveButton("담기", null)
                    setNegativeButton("취소", null)
                    show()
                }
            }

            val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
            recButton.setOnClickListener {

            }
        }

        binding.menu2Img.setOnClickListener {
            val cDialogView =
                LayoutInflater.from(view.context).inflate(R.layout.custom_dialog, null)

            val drawable = getDrawable(view.context ,R.drawable.set_02_black_onion)
            val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
            val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)
            imageView.setImageDrawable(drawable)
            textView.setText("메뉴2 설명-----")

            val mBuilder = AlertDialog.Builder(view.context)
                .setView(cDialogView)
                .setTitle("블랙어니언와퍼 세트")
                .setIcon(drawable)
                .setPositiveButton("바로 담기", null)


            mBuilder.setNegativeButton("닫기", null)
            mBuilder.show()

            val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
            cusButton.setOnClickListener {
                val items =
                    arrayOf<String>("00추가", "00추가", "00추가", "00추가", "00추가", "00추가", "00추가", "00추가")

                AlertDialog.Builder(view.context).run {
                    setTitle("Test")
                    setIcon(R.drawable.ic_launcher_background)
                    setSingleChoiceItems(items,
                        checkedItem,
                        object : DialogInterface.OnClickListener {
                            override fun onClick(
                                p0: DialogInterface?,
                                which: Int,
                            ) {
                                Log.d("선택", "${items[which]}이 선택되었습니다.")
                            }
                        })
                    setPositiveButton("담기", null)
                    setNegativeButton("취소", null)
                    show()
                }
            }

            val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
            recButton.setOnClickListener {

            }
        }

        /*val items = arrayOf<String>("00추가","00추가","00추가","00추가","00추가","00추가","00추가","00추가")

            AlertDialog.Builder(view.context).run {
                setTitle("Test")
                setIcon(R.drawable.ic_launcher_background)
                setSingleChoiceItems(items,
                checkedItem,
                object : DialogInterface.OnClickListener{
                    override fun onClick(
                        p0: DialogInterface?,
                        which: Int,
                    ){
                        Log.d("선택", "${items[which]}이 선택되었습니다." )
                    }
                })
                setPositiveButton("담기", null)
                setNegativeButton("취소", null)
                show()
            }
        }*/
    }
}