package com.example.healthcare.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "medicals")
data class Medical (@PrimaryKey @ColumnInfo(name = "first_name") val fname:String,
                    @ColumnInfo(name = "last_name") val lname:String,
                    @ColumnInfo(name = "hospital") val hospital:String,
                    @ColumnInfo(name = "doctor") val doctor:String,
                    @ColumnInfo(name= "card") val card:Int,
                    @ColumnInfo(name = "check") val check:String
): Serializable

