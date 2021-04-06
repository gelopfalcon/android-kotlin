package com.example.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Inicializacion
        val rollButton: Button = findViewById(R.id.roll_button)
        val resultText: TextView = findViewById(R.id.id_helloWorld)

        rollButton.setOnClickListener { rollDice(resultText) }
    }

    private fun rollDice(resultText: TextView) {
        var randomInt = (1..6).random()
        resultText.text = randomInt.toString()
        Toast.makeText(this, "button clicked", Toast.LENGTH_SHORT).show()
    }
}