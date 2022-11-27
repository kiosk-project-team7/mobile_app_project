package com.example.kiosk_project

import android.app.AlertDialog
import android.os.Bundle
import android.text.AlteredCharSequence
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.kiosk_project.databinding.DialogBinding
import com.example.kiosk_project.databinding.FragmentSimpleBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
lateinit var binding:FragmentSimpleBinding
lateinit var dbinding:DialogBinding
var check:Boolean=false
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
        binding.bugerImage.setOnClickListener{
            Log.d("jaehan","햄버거버튼이 눌렸습니다"+activity)
            val dbinding=DialogBinding.inflate(layoutInflater)
            AlertDialog.Builder(activity).run{
                setTitle("햄버거")
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

    override fun onDestroy() {
        super.onDestroy()
    }
}