package com.example.healthcare.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MedicalDao {

    @Query("SELECT * from medicals ORDER BY first_name")
    fun getAllMedicals(): LiveData<List<Medical>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicals(medical: Medical):Long

    @Delete
    fun deleteMedicals(medical: Medical):Int

    @Update
    fun updateMedicals(medical: Medical):Int
}

