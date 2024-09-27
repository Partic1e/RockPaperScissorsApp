package com.example.rockpaperscissors

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val stoneButton = findViewById<View>(R.id.rockbutton) as Button
        stoneButton.setOnClickListener { view ->
            val intent = Intent(view.context, SecondActivity::class.java)
            intent.putExtra("key", "rock")
            view.context.startActivity(intent)
        }

        val paperButton = findViewById<View>(R.id.paperbutton) as Button
        paperButton.setOnClickListener { view ->
            val intent = Intent(view.context, SecondActivity::class.java)
            intent.putExtra("key", "paper")
            view.context.startActivity(intent)
        }

        val scissorsButton = findViewById<View>(R.id.scissorsbutton) as Button
        scissorsButton.setOnClickListener { view ->
            val intent = Intent(view.context, SecondActivity::class.java)
            intent.putExtra("key", "scissors")
            view.context.startActivity(intent)
        }
    }
}