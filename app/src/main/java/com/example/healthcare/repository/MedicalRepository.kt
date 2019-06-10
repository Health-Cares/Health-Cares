package com.example.healthcare.repository

import androidx.lifecycle.LiveData
import com.example.healthcare.data.Medical
import com.example.healthcare.data.MedicalApiService
import com.example.healthcare.data.MedicalDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


class MedicalRepository(private val medicalDao: MedicalDao, private val medicalApiService: MedicalApiService.Companion){

    fun allMedical(): LiveData<List<Medical>> = medicalDao.getAllMedicals()


    suspend fun insertMedical(medical: Medical): Response<Medical> =
        withContext(Dispatchers.IO){
        medicalApiService.insertMedicals(medical).await()
    }
    suspend fun deleteMedical(medical: Medical): Response<Void> =
        withContext(Dispatchers.IO){
        medicalApiService.deleteMedicals(medical).await()
    }
    suspend fun updateMedical(medical: Medical):  Response<Medical> =
        withContext(Dispatchers.IO){
        medicalApiService.updateMedicals(medical).await()
    }
}


