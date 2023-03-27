package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
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
            rollDiceBottom()
        }
    }

    //Результат нажатої кнопки на екрані
    private fun rollDiceBottom() {
            // Створіть новий об’єкт Dice із 6 сторонами
            val dice = Dice(6)
            val rollDiceBottom = dice.roll()

            // Знайти ImageView
            val diceImage1: ImageView = findViewById(R.id.imageViewBottom)

            // Визначити, який ід для малювання використовувати на основі кидка кубиків
            val drawableResource = when (rollDiceBottom) {
                1 -> R.drawable.dice_1
                2 -> R.drawable.dice_2
                3 -> R.drawable.dice_3
                4 -> R.drawable.dice_4
                5 -> R.drawable.dice_5
                else -> R.drawable.dice_6
            }

            // Оновіть ImageView правильним ід для малювання
            diceImage1.setImageResource(drawableResource)
            //Оновлення результата
            diceImage1.contentDescription = rollDiceBottom.toString()
        }



    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Знайти ImageView
        val diceImage: ImageView = findViewById(R.id.imageView)

        // Визначити, який ід для малювання використовувати на основі кидка кубиків
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        // Оновіть ImageView правильним ід для малювання
        diceImage.setImageResource(drawableResource)
        //Оновлення результата
        diceImage.contentDescription = diceRoll.toString()
    }
}

//Кубики з фіксованою кількістю сторін 6.

class Dice(private val numSides: Int) {
    //Обрання рандомного  числа від 1 до 6 для кубика
    fun roll(): Int {
        return (1..numSides).random()
    }
}