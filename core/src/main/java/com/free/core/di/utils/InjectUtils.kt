package com.free.core.di.utils

import android.content.Context
import com.free.core.di.CoreComponent
import com.free.core.di.CoreComponentProvider

object InjectUtils {

    fun provideCoreComponent(applicationContext: Context): CoreComponent {
        return if (applicationContext is CoreComponentProvider) {
            (applicationContext as CoreComponentProvider).provideCoreComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement CoreComponentProvider")
        }
    }

}