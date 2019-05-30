package com.example.healthcare

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class OneMonth : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_one_month)

        val oneMonthView: TextView = findViewById(R.id.one_month_view)
        oneMonthView.setText("One Month")
    }
}
