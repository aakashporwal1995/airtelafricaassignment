package com.aakashporwal.airtelafricaassignment

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class SpeakerTestActivity : AppCompatActivity() {

    private val testViewModel: TestViewModel by viewModels()

    private lateinit var textToSpeech: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker_test)

        textToSpeech = TextToSpeech(applicationContext,
            OnInitListener { status ->
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setSpeechRate(0.8f)
                    textToSpeech.language = Locale.US
                }
            })

        findViewById<Button>(R.id.button_speak).setOnClickListener {
            if (!textToSpeech.isSpeaking) {
                textToSpeech.speak("Airtel Africa Assignment", TextToSpeech.QUEUE_FLUSH, null)
            }
        }

        findViewById<EditText>(R.id.editText_input).setOnEditorActionListener { editText, action, _ ->
            if (action == EditorInfo.IME_ACTION_DONE) {
                if (testViewModel.checkMessage(editText.text.toString())) {
                    Toast.makeText(
                        this@SpeakerTestActivity,
                        "Your speakers are working fine.",
                        Toast.LENGTH_LONG
                    ).show()
                    editText.text = ""
                    return@setOnEditorActionListener false
                } else {
                    Toast.makeText(
                        this@SpeakerTestActivity,
                        "Incorrect Input",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
            return@setOnEditorActionListener true
        }
    }
}