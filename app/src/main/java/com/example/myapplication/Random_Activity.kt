package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlin.random.Random

class Random_Activity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        showRandomNumber ()
    }
//Классы в Kotlin не могут иметь статических членов, ключевое слово static не входит в состав языка.
//Можно пометить объект в классе ключевым словом companion вместе с другим ключевым словом object
// и обращаться к методам и свойствам объекта через имя содержащего его класса без явного указания имени объекта.
    companion object{
        const val TOTAL_COUNT = "total_count"
    }

    fun showRandomNumber(){
        val text_random = findViewById<TextView>(R.id.text_random)
        val text_label = findViewById<TextView>(R.id.text_label)

        val count = intent.getIntExtra(TOTAL_COUNT,0)
        val random = Random(0)

        var randomInt = 0

        if (count>0){
            randomInt = random.nextInt(count+1)
        }

        text_random.text = Integer.toString(randomInt)
        text_label.text = getString(R.string.random_heading,count)

    }
}