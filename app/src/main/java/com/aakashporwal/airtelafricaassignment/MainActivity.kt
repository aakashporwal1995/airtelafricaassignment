package com.aakashporwal.airtelafricaassignment

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button_speaker).setOnClickListener {
            startActivity(Intent(this@MainActivity, SpeakerTestActivity::class.java))
        }

        findViewById<Button>(R.id.button_mic).setOnClickListener {
            startActivity(Intent(this@MainActivity, MicTestActivity::class.java))
        }
    }
}