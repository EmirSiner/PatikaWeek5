package com.example.patikaweek5.ui.loadingprocess

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import com.example.patikaweek5.R


class LoadingProgressBar(context: Context) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.layout_loading_progress)
        window?.setBackgroundDrawableResource(R.color.transparent)
        setCancelable(false)
    }
}