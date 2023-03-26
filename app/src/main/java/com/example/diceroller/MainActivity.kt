package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button1)
        rollButton.setOnClickListener {
            rollDice()
            rollDiceNew()
        }
    }

    private fun rollDiceNew() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextViewNew: TextView = findViewById(R.id.textView1)
        resultTextViewNew.text = diceRoll.toString()
    }


    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextViewNew: TextView = findViewById(R.id.textView1)
        resultTextView.text = diceRoll.toString()
        resultTextViewNew.text = diceRoll.toString()
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}

