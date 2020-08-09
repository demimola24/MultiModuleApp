package com.free.cityfeature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.free.cityfeature.di.CityInjector
import com.free.core.di.CoreApplication
import kotlinx.android.synthetic.main.city_activity.*

class CityActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_activity)
        setSupportActionBar(toolbar)
        CityInjector.init(this.application as CoreApplication)

    }

}
