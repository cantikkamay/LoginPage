package com.cantikka.loginpage

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val textView: TextView = findViewById(R.id.textView)
        val textView2: TextView = findViewById(R.id.textView2)
        val logoutButton: Button = findViewById(R.id.button)

        val email = intent.getStringExtra("email") ?: ""

        if (email.isNotEmpty()) {
            val username = email.substringBefore("@gmail.com")
            textView.text = "Halo $username"
            Log.d("Activity", "User berhasil masuk dengan email: $email")
        } else {
            textView.text = "Halo Pengguna"
            Log.d("Activity", "User masuk tanpa email")
        }

        textView2.text = "Hello World !!"

        logoutButton.setOnClickListener {
            Log.d("Activity", "User berhasil logout")
            finish()
        }
    }
}
