package com.example.healthcare.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Medical::class), version = 1)
abstract class MedicalDatabase: RoomDatabase() {

    abstract fun medicalDao():MedicalDao

    companion object {

        @Volatile
        private var INSTANCE: MedicalDatabase? = null

        fun getDatabase(context: Context): MedicalDatabase {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {

                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MedicalDatabase::class.java, "medical_database"
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}


