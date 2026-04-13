package com.example.assignment1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var inputTime: EditText
    private lateinit var outputText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        inputTime = findViewById(R.id.inputTime)
        outputText = findViewById(R.id.outputText)
        val btnSuggest = findViewById<Button>(R.id.btnSuggest)
        val btnReset = findViewById<Button>(R.id.btnReset)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        btnSuggest.setOnClickListener {
            val time = inputTime.text.toString().lowercase().trim()

            when (time) {
                "morning" -> {
                    outputText.text = "Send a 'Good morning' text to a family member"
                }
                "mid-morning" -> {
                    outputText.text = "Send a quick thank you to a colleague"
                }
                "afternoon" -> {
                    outputText.text = "Share a meme or interesting link"
                }
                "afternoon snack time" -> {
                    outputText.text = "Send a 'thinking of you' message"
                }
                "dinner" -> {
                    outputText.text = "Call a friend for a 5-minute catch-up"
                }
                "night" -> {
                    outputText.text = "Leave a thoughtful comment on a friend's post"
                }
                else -> {
                    outputText.text = "Invalid input. Please enter a valid time like Morning or Afternoon."
                }
            }
        }

        btnReset.setOnClickListener {
            inputTime.text.clear()
            outputText.text = ""
        }
    }
}
