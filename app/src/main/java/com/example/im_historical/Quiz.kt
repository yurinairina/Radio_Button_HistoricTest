package com.example.im_historical

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class Quiz {
    private val q1 = Question ("Когда Москва впервые упомянута в летописи:", listOf(
            Answer("988 г.", false),
            Answer("1147 г.", true),
            Answer("990 г.", false),
        ).toList())
    private val q2 = Question(
        "Кто был первым русским царём?", listOf(
            Answer("Иван Грозный", true),
            Answer("Пётр I", false),
            Answer("Алексей Михайлович", false),
        ).toList())
    private val q3 = Question(
        "Кто был последним императором Российской империи?", listOf(
            Answer("Александр III", false),
            Answer("Николай II", true),
            Answer("Михаил II", false),
        ).toList())
    private val q4 = Question(
        "Какая война первой в истории России была  названа войной Отечественной:", listOf(
            Answer("Отечественная война 1941-1945 годов", false),
            Answer("Северная война 1700-1721 годов", false),
            Answer("Отечественная война 1812 года", true),
        ).toList())
    private val q5 = Question("Какой     император отменил в 1861 году  в России крепостное право:", listOf(
            Answer("Николай I", false),
            Answer("Александр II", true),
            Answer("Павел I", false),
        ).toList())
       val questions: List<Question> = listOf(q1, q2, q3, q4, q5)
    private val great = "Отлично!\n"
    private val veryGood = "Xорошо!\n"
    private val good = "Удовлетворительно\n"
    private val unsatisfactory = "Неудовлетворительно.\n"
    private val badly = "Плохо.\n"

    fun result(result: Int, resultTV: TextView) {
        when (result) {
            0 -> resultTV.text = badly
            100 -> resultTV.text = badly
            200 -> resultTV.text = unsatisfactory
            300 -> resultTV.text = good
            400 -> resultTV.text = veryGood
            500 -> resultTV.text = great
        }
    }
}
class Answer(private val answer: String, val isCorrect: Boolean) {
    override fun toString(): String {
        return answer
    } }
class Question(val question: String, val answers: List<Answer>)

