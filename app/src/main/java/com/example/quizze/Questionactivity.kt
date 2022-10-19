package com.example.quizze

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_questionactivity.*

class Questionactivity : AppCompatActivity() {

    private var currentPosition: Int = 1
    private var questionList: ArrayList<QuestionData>? = null
    private var selectedOption: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questionactivity)

        questionList = setData.getQuestion()

        setquestion()

        opt_1.setOnClickListener {
            selectedOptionStyle(opt_1, 1)
        }
        opt_2.setOnClickListener {
            selectedOptionStyle(opt_2, 2)
        }
        opt_3.setOnClickListener {
            selectedOptionStyle(opt_3, 3)
        }
        opt_4.setOnClickListener {
            selectedOptionStyle(opt_4, 4)
        }
        submit_button.setOnClickListener {
            if (selectedOption != 0) {
                val question = questionList!![currentPosition - 1]
                if (selectedOption != question.correct_ans) {
                    setColor(selectedOption, R.drawable.wrong_question_option)
                }
                setColor(question.correct_ans, R.drawable.correct_question_option)
                if (currentPosition == questionList!!.size)
                    submit_button.text = "FINISH"
                else
                    submit_button.text = "GO TO NEXT"
            } else {
                currentPosition++
                when {
                    currentPosition <= questionList!!.size -> {
                        setquestion()
                    }
                    else->{
                        Toast.makeText(this,"hello",Toast.LENGTH_SHORT).show()
                    }
                }


            }
            selectedOption=0

        }


    }

    fun setColor(opt: Int, color: Int) {
        when (opt) {
            1 -> {
                opt_1.background = ContextCompat.getDrawable(this, color)
            }
            2 -> {
                opt_2.background = ContextCompat.getDrawable(this, color)
            }
            3 -> {
                opt_3.background = ContextCompat.getDrawable(this, color)
            }
            4 -> {
                opt_4.background = ContextCompat.getDrawable(this, color)
            }

        }

    }

    fun setquestion() {
        val question = questionList!![currentPosition - 1]
        setoptionstyle()


        progress_bar.progress = currentPosition
        progress_text.text = "${currentPosition}" + "/" + "5"
        question_text.text = question.question
        opt_1.text = question.option_one
        opt_2.text = question.option_two
        opt_3.text = question.option_three
        opt_4.text = question.option_four
    }

    fun setoptionstyle() {
        var optionList: ArrayList<TextView> = arrayListOf()
        optionList.add(0, opt_1)
        optionList.add(0, opt_2)
        optionList.add(0, opt_3)
        optionList.add(0, opt_4)
        for (op in optionList) {
            op.setTextColor(Color.parseColor("#555151"))
            op.background = ContextCompat.getDrawable(this, R.drawable.question_option)
            op.typeface = Typeface.DEFAULT
        }
    }

    fun selectedOptionStyle(view: TextView, opt: Int) {
        setoptionstyle()
        selectedOption = opt
        view.background = ContextCompat.getDrawable(this, R.drawable.selected_question_option)
        view.typeface = Typeface.DEFAULT_BOLD
        view.setTextColor(Color.parseColor("#000000"))
    }
}