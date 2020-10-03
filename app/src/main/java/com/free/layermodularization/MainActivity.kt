package com.free.layermodularization

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.free.layermodularization.di.MainInjector
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus
import com.google.gson.Gson
import dagger.android.DispatchingAndroidInjector

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val manager: SplitInstallManager by lazy {
        SplitInstallManagerFactory.create(this)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //CoreApplication.coreComponent(this@MainActivity).inject(this@MainActivity)
        MainInjector.init(this)

        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)



        cityApp.setOnClickListener {

            val request = SplitInstallRequest.newBuilder()
                .addModule("cityfeature")
                .build()

            manager.startInstall(request).addOnSuccessListener {
                val intent = Intent()
                intent.setClassName(this, "com.free.cityfeature.CityActivity")
                startActivity(intent)
            }

        }

        coordinateApp.setOnClickListener {

            val request = SplitInstallRequest.newBuilder()
                .addModule("coordinatefeature")
                .build()

            manager.startInstall(request).addOnSuccessListener {
                val intent = Intent()
                intent.setClassName(this, "com.free.coordinatefeature.CoordinateActivity")
                startActivity(intent)
            }

        }

        manager.registerListener {
            when (it.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> {
                    Log.d("SplitInstallManager","SplitInstallManager: downloading")
                    //showToast("Downloading feature")
                }
                SplitInstallSessionStatus.INSTALLED -> {
                    Log.d("SplitInstallManager","SplitInstallManager: installed")
                }
                else -> { /* Do nothing in this example */ }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
