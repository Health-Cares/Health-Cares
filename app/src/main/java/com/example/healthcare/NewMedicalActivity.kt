package com.example.healthcare

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.healthcare.data.Medical
import kotlinx.android.synthetic.main.fragment_add.*

class NewMedicalActivity : AppCompatActivity() {

    private lateinit var saveButton: Button

    private lateinit var firstEditText: EditText
    private lateinit var lastNEditText: EditText
    private lateinit var hospitalEditText: EditText
    private lateinit var doctorNEditText: EditText
    private lateinit var cardNEditText: EditText
    private lateinit var checkEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_add)

        saveButton = save_button
        firstEditText = firstN_editText
        lastNEditText = lastN_editText
        hospitalEditText = hospital_editText
        doctorNEditText = doctorN_editText
        cardNEditText = cardN_editText
        checkEditText = check_editText

        saveButton.setOnClickListener {
            val medical = readFields()
            val replyMedicalIntent = Intent()
            replyMedicalIntent.putExtra("MEDICAL", medical)
            setResult(Activity.RESULT_OK, replyMedicalIntent)
            finish()
            clearFields()
        }
    }

    private fun readFields() = Medical(
            firstEditText.text.toString(),
            lastNEditText.text.toString(),
            hospitalEditText.text.toString(),
            doctorNEditText.text.toString(),
            cardNEditText.text.toString().toInt(),
            checkEditText.text.toString()
        )
    private fun clearFields() {
        firstEditText.setText("")
        lastNEditText.setText("")
        hospitalEditText.setText("")
        doctorNEditText.setText("")
        cardNEditText.setText("")
        checkEditText.setText("")

    }
}
