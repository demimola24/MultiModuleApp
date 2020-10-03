package com.free.coordinatefeature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.free.coordinatefeature.di.CoordinateInjector
import com.free.coordinatefeature.viewmodel.CoordinateViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.coordinate_activity.*
import javax.inject.Inject

class CoordinateActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoordinateViewModel> { viewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        CoordinateInjector.init(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinate_activity)
        setSupportActionBar(toolbar)

        viewModel.generateWeatherStatus("6.5244","3.3792")

        fab.setOnClickListener {
            viewModel.generateWeatherStatus("6.5244","3.3792")
        }

        with(viewModel) {

            progress.observe(this@CoordinateActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    if(it){
                        weather_degree.text = "...."
                    }
                }
            })

            error.observe(this@CoordinateActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    weather_degree.text = "N/A"
                }
            })
            getWeatherStatus.observe(this@CoordinateActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {
                    val value = it.main.temp_max
                    weather_degree.text = "$value ${0x00B0.toChar()}F"
                }
            })
        }

    }

}
