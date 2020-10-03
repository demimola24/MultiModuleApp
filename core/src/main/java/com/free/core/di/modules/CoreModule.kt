package com.free.core.di.modules

import android.app.Application
import android.content.Context
import com.free.core.BuildConfig
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class CoreModule {
//    @Singleton
//    @Provides
//    internal fun provideContext(): Context {
//        return app.applicationContext
//    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient =
        OkHttpClient.Builder().addInterceptor(interceptor).build()

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()


    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun provideRetrofitBuilder(client: OkHttpClient, gson: Gson
    ): Retrofit {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.5/")
            .callFactory(client)
            .addConverterFactory(GsonConverterFactory.create(gson))

        //get the okhttp3 client for retrofit so that we can inject the
        //client key into every request

        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val okhttp3clientBuilder = OkHttpClient.Builder()
            .addInterceptor {

             val request = it.request().newBuilder()
                .addHeader("Accept", "application/json")
               // .addHeader("Content-Type", "application/json")
                .addHeader("x-request-client-key", "")
                .addHeader("Authorization","Bearer $")
                .build()

            it.proceed(request)
        }
            .addInterceptor(logging)
            .readTimeout(63, TimeUnit.SECONDS)
        return  retrofitBuilder.client(okhttp3clientBuilder.build()).build()

    }
}