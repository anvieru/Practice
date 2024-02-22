package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.icu.number.IntegerWidth
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    //private lateinit var textView: TextView
    private lateinit var buttonAudio: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //textView = findViewById(R.id.textView)
        buttonAudio = findViewById(R.id.button_Audio)

        buttonAudio.setOnClickListener {
            //Toast.makeText(applicationContext,"Hi",Toast.LENGTH_LONG).show()
            val media_layout = Intent(this, Media_Activity::class.java)
            startActivity(media_layout)
        }




        val buttonPlus = findViewById<Button>(R.id.button_Plus)
//для 2го способа добавляем 2 строчки снизу textView и timeClick...
        val textView = findViewById<TextView>(R.id.textView)
        var timeClick = 0
        buttonPlus.setOnClickListener {
            //способ 1
//            val countString = textView.text.toString()
//            var count:Int = Integer.parseInt(countString)
//            count++
//            textView.text=count.toString()
            //способ 2
        timeClick=timeClick+1 //+=1
        textView.text=timeClick.toString()
        }

        val buttonMinus = findViewById<Button>(R.id.button_Minus)
        buttonMinus.setOnClickListener {
            timeClick-=1
            textView.text=timeClick.toString()
        }
        val buttonToast = findViewById<Button>(R.id.button_Toast)
        buttonToast.setOnClickListener {
            Toast.makeText(applicationContext,"Hi",Toast.LENGTH_LONG).show()
        }
        val buttonRandom = findViewById<Button>(R.id.button_Random)
        buttonRandom.setOnClickListener {
            val random_layout = Intent(this, Random_Activity::class.java)
            val countString = textView.text.toString()
            val count = Integer.parseInt(countString)
            random_layout.putExtra(Random_Activity.TOTAL_COUNT, count)
            startActivity(random_layout)
        }

    }}









//        val button: Button = findViewById(R.id.btnNewLayout)
//
//        button.setOnClickListener {
//            val newL = Intent(this,MainActivity2::class.java)
//        startActivity(newL)}

//        btnNewLayout = findViewById(R.id.btnNewLayout)
//
//        btnNewLayout.setOnClickListener {
//            val newLayout = Intent(this, MainActivity2::class.java)
//            startActivity(newLayout)
//        }


    //val button: Button = findViewById(R.id.btnNewLayout)


//    fun btnclickk() {
//        /*val text = "Привет"
//        val duration = Toast.LENGTH_SHORT
//        val toast = Toast.makeText(applicationContext,text,duration)
//        toast.show()*/
//        Toast.makeText(applicationContext, "Привет", Toast.LENGTH_LONG).show()
//    }

   // }}


