package com.example.businesscard

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.util.Log
import androidx.core.text.bold
import androidx.core.text.color
import androidx.core.text.scale
import kotlinx.android.synthetic.main.activity_text_style.*

class TextStyleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_style)
        setSpannableByKtx()
        Log.d("TextStyleActivity:", "onCreate")
    }

    private fun setSpannableByKtx(){
        val text = "Color"
        val textSample = "Color = Purple Red Orange Yellow Pink Black Blue Green White Brown"

        val spannable = SpannableStringBuilder()
        spannable.color(Color.parseColor("#657482")) {
            scale(1.5f) {
                bold {
                    append(text)
                }
            }
        }
        spannable.color(Color.parseColor("#000000")) {
            append(textSample)
        }

        textSpan.text = spannable

    }

    override fun onStart() {
        super.onStart()
        Log.d("TextStyleActivity:", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TextStyleActivity:", "onStop")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TextStyleActivity:", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TextStyleActivity:", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TextStyleActivity:", "onRestart")
    }

    override fun onDestroy() {
        Log.d("TextStyleActivity:", "onDestroy")
        super.onDestroy()
    }
}