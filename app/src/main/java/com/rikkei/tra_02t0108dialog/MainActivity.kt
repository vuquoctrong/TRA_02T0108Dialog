package com.rikkei.tra_02t0108dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var brightnessDialog: BrightnessDialog? = null
    private var pickNumberDialog: PickNumberDialog? = null
    private var pickToppingDialog: PickToppingDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        brightnessDialog = BrightnessDialog()
        pickNumberDialog = PickNumberDialog()
        pickToppingDialog = PickToppingDialog()
        btnDialogBrightness.setOnClickListener(this)
        btnDialogTimesPicket.setOnClickListener(this)
        btnDialogDataPicket.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            btnDialogBrightness.id -> brightnessDialog?.show(supportFragmentManager, null)
            btnDialogTimesPicket.id -> openTimePicker()
            btnDialogDataPicket.id -> openDataPicker()
        }
    }


    private fun openDataPicker() {
        val calendar = Calendar.getInstance()
        val mYear = calendar.get(Calendar.YEAR)
        val mMonth = calendar.get(Calendar.MONTH)
        val mDay = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, _, _, _ ->
                Toast.makeText(this, "$mDay-$mMonth-$mYear", Toast.LENGTH_SHORT).show()
            }, mYear, mMonth, mDay
        )
        datePickerDialog.show()
    }

    private fun openTimePicker() {
        val c = Calendar.getInstance()
        val mHour = c.get(Calendar.HOUR_OF_DAY)
        val mMinute = c.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, _, _ ->
                Toast.makeText(this, "$mHour-$mMinute", Toast.LENGTH_SHORT).show()
            }, mHour, mMinute, false
        )
        timePickerDialog.show()
    }

}
