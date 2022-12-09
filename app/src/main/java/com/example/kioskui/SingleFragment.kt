package com.example.kioskui

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.kioskui.databinding.FragmentSetmenuBinding
import com.example.kioskui.databinding.FragmentSingleBinding

class SingleFragment : Fragment() {
    private lateinit var binding: FragmentSingleBinding
    private var checkedItem: Int = 0

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

        binding.menu1Img.setOnClickListener {
            dialog(1, binding.menu1Img.drawable, binding.menu1Txt.text)
        }

        binding.menu2Img.setOnClickListener {
            dialog(2, binding.menu2Img.drawable, binding.menu2Txt.text)
        }

        binding.menu3Img.setOnClickListener {
            dialog(3, binding.menu3Img.drawable, binding.menu3Txt.text)
        }

        binding.menu4Img.setOnClickListener {
            dialog(4, binding.menu4Img.drawable, binding.menu4Txt.text)
        }

        binding.menu5Img.setOnClickListener {
            dialog(5, binding.menu5Img.drawable, binding.menu5Txt.text)
        }

        binding.menu6Img.setOnClickListener {
            dialog(6, binding.menu6Img.drawable, binding.menu6Txt.text)
        }

        binding.menu7Img.setOnClickListener {
            dialog(7, binding.menu7Img.drawable, binding.menu7Txt.text)
        }

        binding.menu8Img.setOnClickListener {
            dialog(8, binding.menu8Img.drawable, binding.menu8Txt.text)
        }

        binding.menu9Img.setOnClickListener {
            dialog(9, binding.menu9Img.drawable, binding.menu9Txt.text)
        }

        binding.menu10Img.setOnClickListener {
            dialog(10, binding.menu10Img.drawable, binding.menu10Txt.text)
        }

        binding.menu11Img.setOnClickListener {
            dialog(11, binding.menu11Img.drawable, binding.menu11Txt.text)
        }

        binding.menu12Img.setOnClickListener {
            dialog(12, binding.menu12Img.drawable, binding.menu12Txt.text)
        }

       /* // 메뉴 사진 누르면 다이얼로그
        binding.menu1Img.setOnClickListener {
            val cDialogView =
                LayoutInflater.from(view.context).inflate(R.layout.custom_dialog, null)
            val mBuilder = AlertDialog.Builder(view.context)
                .setView(cDialogView)
                .setTitle("옵션 선택")


            mBuilder.setNegativeButton("닫기", null)
            mBuilder.show()

            val cusButton = cDialogView.findViewById<Button>(R.id.cus_btn)
            cusButton.setOnClickListener {
                val items =
                    arrayOf<String>("양상추 0원", "양파 0원", "토마토 0원", "마요네즈 0원", "케찹 0원", "직화특제소스", "베이컨1장", "치즈1장", "할라피뇨2조각", "피클")

                AlertDialog.Builder(view.context, R.style.Theme_KioskUI_Alert).run {
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
*/
    }

    private fun dialog(menuNum: Int, img: Drawable, tv: CharSequence){
        // 메뉴 선택 다이얼로그
        val cDialogView =
            LayoutInflater.from(view?.context).inflate(R.layout.custom_dialog, null)

        val logo = cDialogView.findViewById<ImageView>(R.id.logo)
        val imageView = cDialogView.findViewById<ImageView>(R.id.menu_img)
        val textView = cDialogView.findViewById<TextView>(R.id.menu_tv)

        imageView.setImageDrawable(img)
        textView.setText(tv)
        //MainActivity.menuInit.whenSelected(menuNum)
        textView.setText("${MainActivity.menuInit.desc[menuNum-1]}")

        val mBuilder = view?.let {
            AlertDialog.Builder(it.context, R.style.Theme_KioskUI_Alert)
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
                LayoutInflater.from(view?.context).inflate(R.layout.custom2_dialog, null)

            val mBuilder2 = view?.let {
                AlertDialog.Builder(it.context)
                    .setView(c2DialogView)
                    .setTitle("사용자화")
                    .setIcon(logo.drawable)
            }

            mBuilder2?.setPositiveButton("담기",null)
            mBuilder2?.setNegativeButton("닫기", null)
            mBuilder2?.show()
        }

        // 추천 버튼 누를 시
        val recButton = cDialogView.findViewById<Button>(R.id.rec_btn)
        recButton.setOnClickListener {

        }
    }
}