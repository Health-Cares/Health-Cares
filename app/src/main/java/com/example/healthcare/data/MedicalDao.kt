package com.example.healthcare.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MedicalDao {

    @Query("SELECT * from medicals ORDER BY first_name")
    fun getAllMedicals(): LiveData<List<Medical>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMedicals(medical: Medical):Long
}

