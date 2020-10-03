package com.free.cityfeature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.free.cityfeature.di.CityInjector
import com.free.cityfeature.viewmodel.CityViewModel
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.city_activity.*
import kotlinx.android.synthetic.main.content_main.*
import javax.inject.Inject

class CityActivity : AppCompatActivity()  {
//
//    @Inject
//    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    @Inject
     lateinit var viewModelProviderFactory: ViewModelProvider.Factory
//

    private val viewModel by viewModels<CityViewModel> { viewModelProviderFactory }


//    override fun androidInjector(): AndroidInjector<Any> {
//        return androidInjector
//    }



    override fun onCreate(savedInstanceState: Bundle?) {
        CityInjector.init(this@CityActivity)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_activity)
        setSupportActionBar(toolbar)

        viewModel.generateWeatherStatus("2267226")

        with(viewModel) {

            progress.observe(this@CityActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })

            error.observe(this@CityActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    weather_degree.text = "N/A"
                }
            })
            getWeatherStatus.observe(this@CityActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    val value = it.main.temp_max
                    weather_degree.text = "$value ${0x00B0.toChar()}F"
                }
            })
        }

    }

}
