package com.example.simpletimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private lateinit var textView : TextView
    private lateinit var button: Button
    private lateinit var button2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)


        button.setOnClickListener {
            Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()

            startTimer()
        }

        button2.setOnClickListener {
            Toast.makeText(this, "new button clicked", Toast.LENGTH_SHORT).show()
        }
    }

    private fun startTimer() {
        GlobalScope.launch(Dispatchers.Main) {
            for (i in 1..10) {
                delay(1000)

                println("$i seconds on ${Thread.currentThread().name}")
                updateUI(i)

            }
        }

    }

    private fun updateUI(i : Int) {
        textView.text = i.toString()
//        withContext(Dispatchers.Main) {
//            textView.text = i.toString()
//        }
    }
}