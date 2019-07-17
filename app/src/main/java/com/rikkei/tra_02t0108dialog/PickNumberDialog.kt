package com.rikkei.tra_02t0108dialog

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class PickNumberDialog : DialogFragment() {
    companion object{
        fun newIntance() = PickNumberDialog()
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.dialog_picket_number,container)
    }









}