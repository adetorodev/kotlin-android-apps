package com.adetoro.kotlinapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var titleTextview: TextView
        lateinit var nameEditText: EditText
        lateinit var generatedButton: Button

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        titleTextview = findViewById(R.id.textView)
        nameEditText = findViewById(R.id.editTextname)
        generatedButton = findViewById((R.id.generateBtn))

        generatedButton.setOnClickListener{
            var name:String = nameEditText.text.toString()

            val i = Intent(this, SecondActivity::class.java )

            i.putExtra("username", name)

            startActivity(i)
        }
    }
}