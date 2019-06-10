package com.example.healthcare.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.healthcare.data.Medical
import com.example.healthcare.data.MedicalApiService
import com.example.healthcare.repository.MedicalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response

class MedicalViewModel(application: Application): AndroidViewModel(application) {

    val firstname = "Yabii"
    val lastname = "Biruk"



    private val medicalRepository: MedicalRepository

    init {
        val medicalApiService = MedicalApiService.getInstance()
        medicalRepository = MedicalRepository(medicalApiService)
    }
    private val _getResponse = MutableLiveData<Response<Medical>>()
    val getResponse:LiveData<Response<Medical>>
    get() = _getResponse
    private val _updateResponse = MutableLiveData<Response<Medical>>()
    val updateResponse: LiveData<Response<Medical>>
        get() = _updateResponse
    private val _insertResponse = MutableLiveData<Response<Medical>>()
    val insertResponse: LiveData<Response<Medical>>
        get() = _insertResponse
    private val _deleteResponse = MutableLiveData<Response<Medical>>()
    val deleteResponse: MutableLiveData<Response<Medical>>
        get() = _deleteResponse

    fun insertMedical(medical: Medical) = viewModelScope.launch(Dispatchers.IO) {
        medicalRepository.insertMedical(medical)
    }
    fun deleteMedical(medical: Medical) = viewModelScope.launch {

        medicalRepository.deleteMedical(medical)
    }
    fun updateMedical(medical: Medical) = viewModelScope.launch {
        medicalRepository.updateMedical(medical)
    }
}


