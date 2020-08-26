package com.crisspian.martes_25_08_coroutines

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.view.View
import com.crisspian.martes_25_08_coroutines.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
	
	boton.setOnClickListener(View.OnClickListener {
		Toast.makeText(this, "No está ná pegao", Toast.LENGTH_SHORT).show()
	})

        val urls = listOf<String>(
	    	"https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg",
            	"https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg",
            	"https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg",
            	"https://apod.nasa.gov/apod/image/1908/M61-HST-ESO-S1024.jpg"
	)
        val prol = listOf(progressBAR, progressBAR1, progressBAR2, progressBAR3)
        val imgl = listOf(nasa_image,nasa_image1,nasa_image2,nasa_image3)

        CoroutineScope(Dispatchers.Main).launch {
		for (i in 0 until urls.size) {
			prol[i].visibility = View.VISIBLE
                	var img = doInBackground(urls[i])
			prol[i].visibility = View.GONE
			imgl[i].setImageBitmap(img)
		    }
        }
    }

    suspend fun doInBackground(url: String) : Bitmap? {
	var result: Bitmap? = null
        withContext(Dispatchers.Default) {
                try {
                    val inputStream = URL(url).openStream()
                    result = BitmapFactory.decodeStream(inputStream)
                } catch (e: Exception) {
                    Log.e("eRRoR", e.message.toString())
                    e.printStackTrace()
                }
        }
	return result
    }

}
