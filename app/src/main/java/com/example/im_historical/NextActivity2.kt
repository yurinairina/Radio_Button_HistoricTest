package com.example.im_historical

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NextActivity2 : AppCompatActivity() {
    private lateinit var questionsCountTV: TextView
    private lateinit var questionTV: TextView
    private lateinit var pointTV: TextView

    private lateinit var answer1RB: RadioButton
    private lateinit var answer2RB: RadioButton
    private lateinit var answer3RB: RadioButton

    private var counter = 1
    private var result = 0
    private var answerRBs = mutableListOf<RadioButton>()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_next2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        questionsCountTV = findViewById(R.id.questionsCountTV)
        pointTV = findViewById(R.id.pointTV)
        questionTV = findViewById(R.id.questionsTV)
        answer1RB = findViewById(R.id.answer1RB)
        answer2RB = findViewById(R.id.answer2RB)
        answer3RB = findViewById(R.id.answer3RB)

        counter = intent.getIntExtra("counter", 0)
        result = intent.getIntExtra("result", 0)

        questionsCountTV.text = "Вопрос № $counter"
        pointTV.text = "Баллы: $result"

        questionTV.text = Quiz().questions[counter - 1].question
        answerRBs = arrayListOf(
            answer1RB,
            answer2RB,
            answer3RB
        )
        for (i in answerRBs.indices) {
            answerRBs[i].text = Quiz().questions[counter - 1].answers[i].toString()
            answerRBs[i].setOnClickListener(radioButtonClickListener)
        }
    }
    private val radioButtonClickListener = View.OnClickListener {
        val radioButton: RadioButton = it as RadioButton
        val checked = radioButton.isChecked
        if (checked) {
            for ((index, rb) in answerRBs.withIndex()) {
                if (radioButton.id == rb.id) {
                    if (Quiz().questions[counter - 1].answers[index].isCorrect) {
                        result += 100
                    }
                    break
                }
            }
            if (counter < Quiz().questions.size) {
                counter++
                val intent = Intent(this, NextActivity2::class.java)
                intent.putExtra("counter", counter)
                intent.putExtra("result", result)
                startActivity(intent)
                finish()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("counter", counter)
                intent.putExtra("result", result)
                startActivity(intent)
                finish()
            }
        }
    }
}



