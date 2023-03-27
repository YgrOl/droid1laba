package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Наша кнопка з ід
        val rollButton: Button = findViewById(R.id.button1)

        // Обробник клікання кнопки
        rollButton.setOnClickListener {
            rollDice()
            rollDiceNew()
        }
    }

    //Результат нажатої кнопки на екрані
    private fun rollDiceNew() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Оновлення результата
        val resultTextViewNew: TextView = findViewById(R.id.textView1)
        resultTextViewNew.text = diceRoll.toString()
    }


    //Результат нажатої кнопки на екрані
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        //Оновлення результата
        val resultTextView: TextView = findViewById(R.id.textView)
        resultTextView.text = diceRoll.toString()

    }
}


//Обрання рандомного  числа від 1 до 6 для кубика
class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }

}

