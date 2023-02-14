package com.harjot.activityfragmentinteraction

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.harjot.activityfragmentinteraction.databinding.FragmentBlankBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment : Fragment(),ActivityInterface{
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentBlankBinding
    lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity=activity as MainActivity
        mainActivity.activityInterface=this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentBlankBinding.inflate(layoutInflater)
        binding.fragment.setOnClickListener {
            mainActivity.fragmentFunction()
        }
        // Inflate the layout for this fragment
        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun textChange(text: String) {
        binding.tvText.setText(text)
    }

    override fun colorchange(color: Int) {
        when(color){
            1->binding.fragment.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.red))
            2->binding.fragment.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.green))
            3->binding.fragment.setBackgroundColor(ContextCompat.getColor(mainActivity, R.color.yellow))
        }
    }
}