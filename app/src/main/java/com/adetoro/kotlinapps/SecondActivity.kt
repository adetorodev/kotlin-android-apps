package com.adetoro.kotlinapps

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {

    lateinit var lotteryNum: TextView
    lateinit var resultText: TextView
    lateinit var shareBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.second_activity)
        lotteryNum = findViewById(R.id.lotteryNumber)
        resultText = findViewById(R.id.resultView)
        shareBtn = findViewById(R.id.shareBtn)

        val randomNumbers = genreateRandomNumber(6)

        resultText.text = randomNumbers

        var username = recieveUserName()

        shareBtn.setOnClickListener{
            shareResult(username, randomNumbers)
        }


    }

    fun genreateRandomNumber(count: Int): String{
        var randomNumber = List(count){
//            val random = java.util.Random()
//            val randomNum = random.nextInt(43)

            (1..42).random()
        }
        return randomNumber.joinToString(" ")
    }

    fun recieveUserName():String{
        var bundle:Bundle? = intent.extras

        var username = bundle?.getString("username").toString()

        return username
    }

    fun shareResult(username: String, generatedNums:String){

        // implicit Intents
        var i = Intent(Intent.ACTION_SEND)

        i.setType("text/plain")
        i.putExtra(Intent.EXTRA_SUBJECT,"$username generates these numbers")
        i.putExtra(Intent.EXTRA_TEXT,"The Lottery numbers are $generatedNums")
        startActivity(i)
    }
}