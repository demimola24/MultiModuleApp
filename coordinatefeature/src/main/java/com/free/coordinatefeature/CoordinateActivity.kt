package com.free.coordinatefeature

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.free.coordinatefeature.viewmodel.CoordinateViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import kotlinx.android.synthetic.main.coordinate_activity.*
import javax.inject.Inject

class CoordinateActivity : AppCompatActivity(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>


    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProvider.Factory

    private val viewModel by viewModels<CoordinateViewModel> { viewModelProviderFactory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.coordinate_activity)
        setSupportActionBar(toolbar)

        with(viewModel) {


            progress.observe(this@CoordinateActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })

            error.observe(this@CoordinateActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })
            getWeatherStatus.observe(this@CoordinateActivity, Observer { uiEvent ->
                uiEvent.getContentIfNotHandled()?.let {

                }
            })
        }

    }

}
