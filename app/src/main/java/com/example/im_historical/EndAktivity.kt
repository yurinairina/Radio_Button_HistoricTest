package com.example.im_historical

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EndActivity : AppCompatActivity() {

        private lateinit var finalPointTV: TextView
        private lateinit var resultTV: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_result)

            finalPointTV = findViewById(R.id.pointTV)
            resultTV = findViewById(R.id.resultTV)

            val result = intent.getIntExtra("result", 0)
            resultTV = findViewById(R.id.resultTV)

            finalPointTV.text = "Баллы: $result"

          //  Quiz().result(result, resultTV)

        }

    }

