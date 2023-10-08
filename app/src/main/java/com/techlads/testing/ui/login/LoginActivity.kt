package com.techlads.testing.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.techlads.testing.MainActivity
import com.techlads.testing.databinding.ActivityLoginBinding
import com.techlads.testing.ui.compose.gallery.ComposeGalleryActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.gallery?.setOnClickListener {
            startActivity(Intent(this, ComposeGalleryActivity::class.java))
            finish()
        }
    }
}