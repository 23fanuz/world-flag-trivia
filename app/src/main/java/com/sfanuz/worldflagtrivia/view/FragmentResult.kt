package com.sfanuz.worldflagtrivia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sfanuz.worldflagtrivia.R
import com.sfanuz.worldflagtrivia.databinding.FragmentResultBinding

class FragmentResult : Fragment() {

    lateinit var fragmentResultBinding : FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragmentResultBinding = FragmentResultBinding.inflate(inflater, container, false)

        fragmentResultBinding.buttonNewQuiz.setOnClickListener {


        }

        fragmentResultBinding.buttonExit.setOnClickListener {



        }
        return fragmentResultBinding.root
    }

}