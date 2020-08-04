package com.free.cityfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.city_activity.*

class CityActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_activity)
        setSupportActionBar(toolbar)
        //CoreApplication.coreComponent(this@MainActivity).inject(this)

    }

}
