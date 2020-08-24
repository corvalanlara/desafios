package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Handler.Callback {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Utilizamos view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Respondemos al evento onClick dependiendo del estado del servicio
        binding.button.setOnClickListener {
            when (ForegroundService.running) {
                true -> {
                    ForegroundService.stopService(this)
                    binding.button.text = getString(R.string.message_start)
                }
                false -> { // el servicio no está corriendo aún
                    ForegroundService.startService(this, getString(R.string.message_2_user), Handler(this))
                    binding.button.text = getString(R.string.message_stop)
		    binding.textView.text = "0"
                }
            }
        }
    }

    override fun handleMessage(msg: Message): Boolean {
        Log.d("Activity", "handleMessage ${msg.data}")
	binding.textView.text = msg.data.getInt("Count").toString()
        return true
    }
}
