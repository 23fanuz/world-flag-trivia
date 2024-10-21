package com.sfanuz.worldflagtrivia.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sfanuz.worldflagtrivia.R
import com.sfanuz.worldflagtrivia.database.FlagsDao
import com.sfanuz.worldflagtrivia.databinding.FragmentQuizBinding
import com.sfanuz.worldflagtrivia.model.FlagsModel
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper

class FragmentQuiz : Fragment() {

    lateinit var fragmentQuizBinding : FragmentQuizBinding

    var flagList = ArrayList<FlagsModel>()

    var correctNumber = 0
    var wrongNumber = 0
    var emptyNumber = 0
    var questionNumber = 0

    lateinit var correctFlag : FlagsModel
    var wrongFlags = ArrayList<FlagsModel>()
    val dao = FlagsDao()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragmentQuizBinding = FragmentQuizBinding.inflate(inflater, container, false)


        flagList = dao.getRandomData(DatabaseCopyHelper(requireActivity()))

        showData()


        fragmentQuizBinding.buttonA.setOnClickListener {

        }

        fragmentQuizBinding.buttonB.setOnClickListener {

        }

        fragmentQuizBinding.buttonC.setOnClickListener {

        }

        fragmentQuizBinding.buttonD.setOnClickListener {

        }

        fragmentQuizBinding.buttonNext.setOnClickListener {

        }

        return fragmentQuizBinding.root
    }

    private fun showData() {

        fragmentQuizBinding.textViewQuestion.text = resources.getString(R.string.question_number).plus(" ").plus(questionNumber + 1)

        correctFlag = flagList[questionNumber]

        fragmentQuizBinding.imageViewFlag.setImageResource(resources.getIdentifier(correctFlag.flagName, "drawable", requireActivity().packageName))

        wrongFlags = dao.getRandomThreeRecords(DatabaseCopyHelper(requireActivity()),correctFlag.id)





    }

}