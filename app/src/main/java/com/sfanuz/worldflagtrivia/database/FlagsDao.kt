package com.sfanuz.worldflagtrivia.database

import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import androidx.core.view.ContentInfoCompat.Flags
import com.sfanuz.worldflagtrivia.model.FlagsModel
import com.techmania.flagquizwithsqlitedemo.DatabaseCopyHelper

class FlagsDao {

    fun getRandomData(helper: DatabaseCopyHelper) : ArrayList<FlagsModel> {
        val recordsList = ArrayList<FlagsModel>()
        val database : SQLiteDatabase = helper.readableDatabase
        val cursor : Cursor = database.rawQuery("SELECT * FROM flags ORDER BY RANDOM() LIMIT 10", null)

        val idIndex = cursor.getColumnIndex("flag_id")
        val countryNameIndex = cursor.getColumnIndex("country_name")
        val flagNameIndex = cursor.getColumnIndex("flag_name")

        while (cursor.moveToNext()) {

            val record = FlagsModel(cursor.getInt(idIndex), cursor.getString(countryNameIndex), cursor.getString(flagNameIndex))
            recordsList.add(record)
        }

        cursor.close()
        return recordsList

    }


    fun getRandomThreeRecords(helper: DatabaseCopyHelper, id : Int) : ArrayList<FlagsModel> {
        val recordsList = ArrayList<FlagsModel>()
        val database : SQLiteDatabase = helper.readableDatabase
        val cursor : Cursor = database.rawQuery("SELECT * FROM flags WHERE flag_id != ? ORDER BY RANDOM() LIMIT 3", arrayOf(id.toString()))

        val idIndex = cursor.getColumnIndex("flag_id")
        val countryNameIndex = cursor.getColumnIndex("country_name")
        val flagNameIndex = cursor.getColumnIndex("flag_name")

        while (cursor.moveToNext()) {

            val record = FlagsModel(cursor.getInt(idIndex), cursor.getString(countryNameIndex), cursor.getString(flagNameIndex))
            recordsList.add(record)
        }

        cursor.close()
        return recordsList

    }



}