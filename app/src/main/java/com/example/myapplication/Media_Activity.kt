package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.SeekBar
import android.widget.Toast

class Media_Activity : AppCompatActivity() {

    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var runnable: Runnable

    private var handler: Handler = Handler()
    private var pause:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media)

        //аудиодорожка
        val seek_bar = findViewById<SeekBar>(R.id.seek_bar)
        seek_bar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean)
            {
                if(b){
                    mediaPlayer.seekTo(i*1000)
                }
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })

        fun initializeSeekBar (){
//            seek_bar.max = mediaPlayer.seconds
//
//            runnable = Runnable {
//                seek_bar.progress = mediaPlayer.currentSeconds
//
//                tv_pass.text
//            }


        }


            //https://java-blog.ru/kotlin/kotlin-android-media-player-prostoe-ispolzovanie



        //воспоизведение звука
        val playBtn = findViewById<Button>(R.id.playBtn)
        playBtn.setOnClickListener {
            if(pause){
                mediaPlayer.seekTo(mediaPlayer.currentPosition)
                mediaPlayer.start()
                pause = false
                Toast.makeText(this,"media playing",Toast.LENGTH_SHORT).show()
            }else{

                mediaPlayer = MediaPlayer.create(applicationContext,R.raw.school_bell)
                mediaPlayer.start()
                Toast.makeText(this,"media playing",Toast.LENGTH_SHORT).show()
            }
            initializeSeekBar ()


            //остановка воспроизведения
            val stopBtn = findViewById<Button>(R.id.stopBtn)
            stopBtn.setOnClickListener {
                if (mediaPlayer.isPlaying||pause.equals(true)){
                    pause=false


                }

            }

            //пауза воспроизведения
            val pauseBtn = findViewById<Button>(R.id.pauseBtn)
            playBtn.setOnClickListener {
                if(mediaPlayer.isPlaying){
                    mediaPlayer.pause()
                    pause=true
                    playBtn.isEnabled=true
                    pauseBtn.isEnabled=false
                    stopBtn.isEnabled=true
                    Toast.makeText(this,"media pause",Toast.LENGTH_LONG).show()
                }
            }


        }

    }
}