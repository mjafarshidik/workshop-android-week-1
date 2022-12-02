package com.developer.week1.ui

import android.content.Intent
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.developer.week1.R
import com.developer.week1.data.User
import com.developer.week1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val binding: ActivityMainBinding by viewBinding()
    private lateinit var dateOfBirth: String
    private lateinit var testType: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //setDataUser()
        getData()
    }

//    private fun setDataUser() {
//        val dataUser = intent.getParcelableExtra<User>("update")
//        if (dataUser?.status == "update") {
//            edtDateOfBirth.setText(dataUser.dateOfBirth)
//    }

    private fun getData() {
        binding.apply {
            val selectedTestType = rgType.checkedRadioButtonId
            val rbTestType = findViewById<RadioButton>(selectedTestType)

            dateOfBirth = edtDate.text.toString()
            testType = rbTestType.text.toString()

            if (dateOfBirth == "" || dateOfBirth.isEmpty()) {
                edtDate.error = "Silahkan isi data tanggal terlebih dahulu"
                edtDate.requestFocus()
            } else {
                saveDate(dateOfBirth, testType)
            }
        }
    }

    private fun saveDate(dateOfBirth: String, testType: String) {
        binding.apply {
            val user = User()
            user.dateOfBirt = dateOfBirth
            user.dateOfBirt = testType

            if (cbSetuju.isChecked){
                val intent = Intent(this@MainActivity, ConfirmActivity::class.java)
                intent.putExtra("USER", user)
                startActivity(intent)
            } else {
                Toast.makeText(this@MainActivity, "Setujui terlebih dahulu", Toast.LENGTH_LONG).show()
            }
        }
    }
}