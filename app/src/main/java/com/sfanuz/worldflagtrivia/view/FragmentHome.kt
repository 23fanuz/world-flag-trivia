package com.sfanuz.worldflagtrivia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sfanuz.worldflagtrivia.R
import com.sfanuz.worldflagtrivia.databinding.FragmentHomeBinding

class FragmentHome : Fragment() {


lateinit var fragmentHomeBinding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        fragmentHomeBinding = FragmentHomeBinding.inflate(inflater,container, false)

        fragmentHomeBinding.buttonStart.setOnClickListener {

        }


        return fragmentHomeBinding.root
    }


}