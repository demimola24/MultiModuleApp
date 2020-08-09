package com.free.coordinatefeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.free.coordinatefeature.di.CoordinateInjector
import com.free.core.di.CoreApplication
import kotlinx.android.synthetic.main.coordinate_activity.*

class CoordinateActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinate_activity)
        setSupportActionBar(toolbar)
        CoordinateInjector.init(this.application as CoreApplication)

    }

}
