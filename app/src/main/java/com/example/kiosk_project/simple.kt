package com.example.kiosk_project

import android.app.AlertDialog

import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.AlteredCharSequence
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import android.widget.VideoView
import com.example.kiosk_project.databinding.DialogBinding
import com.example.kiosk_project.databinding.FragmentSimpleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var binding:FragmentSimpleBinding
lateinit var dbinding:DialogBinding
/**
 * A simple [Fragment] subclass.
 * Use the [simple.newInstance] factory method to
 * create an instance of this fragment.
 */

class simple : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentSimpleBinding.inflate(layoutInflater)

        //return inflater.inflate(R.layout.fragment_simple, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbinding = DialogBinding.inflate(layoutInflater)
        var checkedItem:Int=0
        binding.bugerImage.setOnClickListener{
            Log.d("jaehan","햄버거버튼이 눌렸습니다"+activity)
            val dbinding=DialogBinding.inflate(layoutInflater)
            val items=arrayOf<String>("추천","사용자설정") //
            AlertDialog.Builder(activity).run{
                setIcon(android.R.drawable.sym_def_app_icon)
                setTitle("햄버거")
                dbinding.basic.setOnClickListener{
                    Log.d("jaehan","기본버튼눌림")

                    //메뉴제공 안하고 바로 결제창
                }
                dbinding.detail.setOnClickListener{
                    Log.d("jaehan","사용자설정버튼 눌림")
                    val intent = Intent(activity, detailmenu::class.java)
                    startActivity(intent)
                    //상세 메뉴창
                }
                /*
                setSingleChoiceItems(
                    items,
                    checkedItem,
                    object : DialogInterface.OnClickListener {
                        override fun onClick(p0: DialogInterface?, p1: Int) {
                            checkedItem=p1
                            Log.d("jaehan","선택된 문자열은 = ${items[p1]}")
                        }
                    }
                )
                 */
                setCancelable(false) //외부 클릭 종료
                setView(dbinding.root)
                show()

            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment set.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            set().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onResume() {
        super.onResume()

    }
    override fun onDestroy() {
        super.onDestroy()
    }
}