package com.example.myapplication

import android.view.View
import android.widget.FrameLayout
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
class BaseActivity : AppCompatActivity() {

    lateinit private var mProgessBar : ProgressBar
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)

        val cons_layout = layoutInflater.inflate(R.layout.activity_base,null)

        val frame = cons_layout.findViewById<FrameLayout>(R.id.frame_container)
        val mProgressBar = cons_layout.findViewById<ProgressBar>(R.id.progress_bar)

        layoutInflater.inflate(layoutResID,frame,true)

        super.setContentView(layoutResID)
    }

    fun isVisible(visibility : Boolean){
            if(visibility){
                mProgessBar.visibility = View.VISIBLE
            }else
                mProgessBar.visibility = View.INVISIBLE

    }
}