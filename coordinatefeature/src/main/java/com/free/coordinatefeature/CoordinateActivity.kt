package com.free.coordinatefeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.coordinate_activity.*

class CoordinateActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinate_activity)
        setSupportActionBar(toolbar)
        //CoreApplication.coreComponent(this@MainActivity).inject(this)

    }

}
