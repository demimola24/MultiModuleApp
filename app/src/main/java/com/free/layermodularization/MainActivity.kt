package com.free.layermodularization

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.free.core.di.CoreApplication
import com.free.layermodularization.di.MainInjector
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val manager: SplitInstallManager by lazy {
        SplitInstallManagerFactory.create(this)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        MainInjector.init(this.application as CoreApplication)


        fab.setOnClickListener {_ ->

            val request = SplitInstallRequest.newBuilder()
                .addModule("cityfeature")
                .build()

            manager.startInstall(request)

        }

        manager.registerListener {
            when (it.status()) {
                SplitInstallSessionStatus.DOWNLOADING -> {
                    Log.d("SplitInstallManager","SplitInstallManager: downloading")
                    //showToast("Downloading feature")
                }
                SplitInstallSessionStatus.INSTALLED -> {
//                    val intent = Intent()
//                    intent.setClassName(this, "com.free.cityfeature.CityActivity")
//                    startActivity(intent)
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
