package com.cantikka.loginpage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText: EditText = findViewById(R.id.username)
        val loginButton: Button = findViewById(R.id.Loginbutton)

        loginButton.setOnClickListener {
            val email = usernameEditText.text.toString().trim()

            if (isValidEmail(email)) {
                Log.d("Activity", "Berhasil login dengan email: $email")
                val intent = Intent(this, LoginActivity::class.java)
                intent.putExtra("email", email)
                startActivity(intent)
            } else {
                Log.e("Activity", "Format email salah: $email")
                usernameEditText.error = "Gunakan format @gmail.com"
            }
        }
    }

    private fun isValidEmail(email: String): Boolean {
        val emailPattern = "^[a-zA-Z0-9._%+-]+@gmail\\.com$".toRegex()
        return email.matches(emailPattern)
    }
}
