package com.example.rockpaperscissors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)

        val backButton = findViewById<View>(R.id.backButton) as Button
        backButton.setOnClickListener { view ->
            val intent = Intent(view.context, MainActivity::class.java)
            view.context.startActivity(intent)
        }

        val botStep: String = step()
        val myStep: String = intent.getStringExtra("key")!!
        val result: String = solve(myStep, botStep)

        val playerChoiceTextView = findViewById<TextView>(R.id.playerChoiceTextView)
        playerChoiceTextView.text = getString(R.string.my_step_text, myStep)
        val robotChoiceTextView = findViewById<TextView>(R.id.robotChoiceTextView)
        robotChoiceTextView.text = getString(R.string.bot_step_text, botStep)

        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        resultTextView.text = getString(R.string.result_text, result)
    }

    private fun solve(firstValue: String, secondValue: String): String {
        val gameMap = mapOf("rock" to "scissors",
                            "paper" to "rock",
                            "scissors" to "paper")
        return if(secondValue == gameMap[firstValue])
            "You WIN"
        else if(firstValue == gameMap[secondValue])
            "You LOSE"
        else
            "DRAW"
    }

    private fun step(): String {
        val items: Array<String> = arrayOf("rock", "paper", "scissors")
        return items.random()
    }
}