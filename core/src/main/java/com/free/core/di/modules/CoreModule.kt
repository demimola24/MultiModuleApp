package com.free.core.di.modules

import android.content.Context
import com.free.core.di.CoreApplication
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
class CoreModule(val app: CoreApplication) {
    @Singleton
    @Provides
    internal fun provideContext(): Context {
        return app.applicationContext
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
    fun provideRetrofitBuilder(client: Lazy<OkHttpClient>, gson: Gson
    ): Retrofit {

        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("")
            .callFactory(client.value)
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

//    @Provides
//    fun provideRegisterDataSource(retrofit: Retrofit): RegisterDataSource {
//        val service = retrofit.create(RegisterService::class.java)
//        return RegisterRepository(service)
//    }
}