package com.ntgclarity.authenticator

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.ntgclarity.authenticator.words.WordsActivity

class MainActivity : AppCompatActivity() {
    val kEmail = "signature"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val shared = getSharedPreferences("user.prf", MODE_PRIVATE)
        val shared = PreferenceManager.getDefaultSharedPreferences(this)
        val etEmail = findViewById<EditText>(R.id.et_email)
        val email = shared.getString(kEmail, null)

        etEmail.setText(email)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegistration = findViewById<Button>(R.id.btn_register)
        val btnSettings = findViewById<Button>(R.id.btn_settings)

        btnRegistration.setOnClickListener {
            startRegistration()
        }

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString()

//            shared.edit()
//                .putString(kEmail, email)
//                .apply()

            updateSignature(email)

            startWords()
        }

        btnSettings.setOnClickListener {
            startSettings()
        }
    }

    fun updateSignature(text: String) {
        val defaultPref = PreferenceManager.getDefaultSharedPreferences(this)

        defaultPref.edit()
            .putString(kEmail, text)
            .apply()
    }

    fun tryFiles() {
        val filename = "hello.txt"
        val output = openFileOutput(filename, MODE_PRIVATE)

        output.write("Hello files!".toByteArray())

        val input = openFileInput(filename)
        val lines = input.bufferedReader().lineSequence()

        Log.d("###", lines.joinToString())

        val files = fileList()

        Log.d("###", files.joinToString())
    }

    fun startRegistration() {
        val intent = Intent(this, RegistrationActivity::class.java)

        startActivity(intent)
    }

    fun startWords() {
        val intent = Intent(this, WordsActivity::class.java)

        startActivity(intent)
    }

    fun startSettings() {
        val intent = Intent(this, SettingsActivity::class.java)

        startActivity(intent)
    }
}