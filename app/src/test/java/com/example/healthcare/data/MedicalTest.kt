package com.example.healthcare.data

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MedicalTest {

    private lateinit var medical: Medical

    @Before
    fun createClassInstance(){
        medical = Medical("Abebe", "Kebede", "42","Male", "Yekatit", "Gemechu", 456, "March",
            "Good")
    }
    @Test
    fun test_default_values(){
        val defaultMedical = Medical("Shemsu", "Siraj", "33", "Male", "Minilik" , "Aschalew" , 331,
            "Ginbot" , "Bad Condition")
        Assert.assertEquals(331, defaultMedical.card)

    }
}