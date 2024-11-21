package com.example.paginafinalpmm

import android.os.Bundle
import android.widget.TextView
import android.net.Uri
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Greeting : AppCompatActivity() {
    private lateinit var videoView: VideoView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_greeting)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }

        videoView = findViewById(R.id.videoView)
        val texto = findViewById<TextView>(R.id.textView4)
        val usuario: String = intent.extras?.getString("USER_NAME").orEmpty();

        val videoUri =
            Uri.parse("android.resource://${packageName}/${R.raw.salchicha}")
        videoView.setVideoURI(videoUri)
        videoView.setOnPreparedListener { mp ->
            mp.isLooping = true
            videoView.start()
        }
        texto.text = "Bienvenido " + usuario


    }
}