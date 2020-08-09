package com.free.cityfeature

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.free.cityfeature.di.CityInjector
import com.free.cityfeature.viewmodel.CityViewModel
import com.free.core.di.CoreApplication
import kotlinx.android.synthetic.main.city_activity.*
import javax.inject.Inject

class CityActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CityViewModel> { viewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.city_activity)
        setSupportActionBar(toolbar)
        CityInjector.init(this.application as CoreApplication)

        with(viewModel) {


            progress.observe(this@CityActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })

            error.observe(this@CityActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })
            getWeatherStatus.observe(this@CityActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })
        }

    }

}
