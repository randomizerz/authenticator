package com.ntgclarity.authenticator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ntgclarity.authenticator.words.WordsActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btn_login)
        val btnRegistration = findViewById<Button>(R.id.btn_register)

        btnRegistration.setOnClickListener {
            startRegistration()
        }

        btnLogin.setOnClickListener {
            startWords()
        }
    }

    fun startRegistration() {
        val intent = Intent(this, RegistrationActivity::class.java)

        startActivity(intent)
    }
    fun startWords() {
        val intent = Intent(this, WordsActivity::class.java)

        startActivity(intent)
    }
}