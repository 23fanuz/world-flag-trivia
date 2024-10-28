package com.sfanuz.worldflagtrivia.view

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.sfanuz.worldflagtrivia.R
import com.sfanuz.worldflagtrivia.databinding.FragmentResultBinding

class FragmentResult : Fragment() {

    lateinit var fragmentResultBinding : FragmentResultBinding

    var correctNumber = 0F
    var emptyNumber = 0F
    var wrongNumber = 0F

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        fragmentResultBinding = FragmentResultBinding.inflate(inflater, container, false)

        val args = arguments?.let {
            FragmentResultArgs.fromBundle(it)
        }

        args?.let {
            correctNumber = it.correct.toFloat()
            emptyNumber = it.empty.toFloat()
            wrongNumber = it.wrong.toFloat()
        }

        val barEntriesArrayListCorrect = ArrayList<BarEntry>()
        val barEntriesArrayListEmpty = ArrayList<BarEntry>()
        val barEntriesArrayListWrong = ArrayList<BarEntry>()

        barEntriesArrayListCorrect.add(BarEntry(0F, correctNumber))
        barEntriesArrayListEmpty.add(BarEntry(1F, emptyNumber)) // Update x position
        barEntriesArrayListWrong.add(BarEntry(2F, wrongNumber)) // Update x position

        val barDataSetCorrect = BarDataSet(barEntriesArrayListCorrect, "Correct Number").apply {
            color = Color.GREEN
            valueTextSize = 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }
        val barDataSetEmpty = BarDataSet(barEntriesArrayListEmpty, "Empty Number").apply {
            color = Color.BLUE
            valueTextSize = 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }
        val barDataSetWrong = BarDataSet(barEntriesArrayListWrong, "Wrong Number").apply {
            color = Color.RED
            valueTextSize = 24F
            setValueTextColors(arrayListOf(Color.BLACK))
        }

        val barData = BarData(barDataSetCorrect, barDataSetEmpty, barDataSetWrong).apply {
            barWidth = 0.3F // Adjust bar width if needed
        }

        fragmentResultBinding.resultChart.apply {
            data = barData
            description.isEnabled = false // Hide description if you don't need it
            xAxis.valueFormatter = IndexAxisValueFormatter(arrayOf("Correct", "Empty", "Wrong"))
            xAxis.position = XAxis.XAxisPosition.BOTTOM
            xAxis.setDrawGridLines(false)
            axisLeft.axisMinimum = 0F
            axisRight.axisMinimum = 0F
            invalidate() // Refresh the chart with new data
        }


        fragmentResultBinding.buttonNewQuiz.setOnClickListener {


        }

        fragmentResultBinding.buttonExit.setOnClickListener {



        }
        return fragmentResultBinding.root
    }

}