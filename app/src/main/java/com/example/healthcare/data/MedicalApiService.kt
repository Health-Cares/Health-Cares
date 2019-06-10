package com.example.healthcare.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.*

interface MedicalApiService {

    @GET(value = "medicals/{first_name")
    fun getAllMedicals(@Path("first_name")first_name :Long): Deferred<Response<Medical>>

    @GET("medicals")
    fun getPostsByUserId(@Query("first_name") first_name: Long): Deferred<Response<List<Medical>>>

    @POST("medicals")
    fun insertMedicals(@Body post: Medical): Deferred<Response<Medical>>

    @PUT("medicals/{first_name}")
    fun updateMedicals(@Path("first_name") first_name: Long, @Body post: Medical): Deferred<Response<Medical>>

    @DELETE("medicals/{first_name}")
    fun deleteMedicals(@Path("first_name") first_name: Long): Deferred<Response<Void>>

    companion object {
        private val baseUrl = ""

        fun getInstance(): MedicalApiService{
            val retrofit: Retrofit =  Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .build()

            return retrofit.create(MedicalApiService::class.java)

        }

    }

}