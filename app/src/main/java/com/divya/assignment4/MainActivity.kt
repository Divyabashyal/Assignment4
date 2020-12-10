package com.divya.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var digitDisplay =StringBuilder()
    private var operation: Char = ' '
    private var leftSide: Double = 0.0
    private var rightSide: Double = 0.0
    private lateinit var tvResult: TextView

    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button
    private lateinit var btn5: Button
    private lateinit var btn6: Button
    private lateinit var btn7: Button
    private lateinit var btn8: Button
    private lateinit var btn9: Button
    private lateinit var btn0: Button
    private lateinit var btnAdd: Button
    private lateinit var btnSubtract: Button
    private lateinit var btnMultiply: Button
    private lateinit var btnDot: Button
    private lateinit var btnEqual: Button
    private lateinit var btnDivide: Button
    private lateinit var btnClearall: Button
    private lateinit var btnClear: Button
    private lateinit var btnPercent: Button
    private lateinit var btnDelete: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResult)
        tvResult.text = "0"
        buttonInitialize()
    }
    private fun buttonInitialize() {
        buttonBind()
        operationalButtons()
        functionalButtons()
    }
    private fun buttonBind() {
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnAdd = findViewById(R.id.btnAdd)
        btnSubtract = findViewById(R.id.btnSubtract)
        btnClear = findViewById(R.id.btnClear)
        btnDot = findViewById(R.id.btnDot)
        btnMultiply = findViewById(R.id.btnMultiply)
        btnEqual = findViewById(R.id.btnEqual)
        btnDelete = findViewById(R.id.btnDelete)
        btnDivide = findViewById(R.id.btnDivide)
        btnPercent = findViewById(R.id.btnPercent)
        btnClearall = findViewById(R.id.btnClearall)


        btn1.setOnClickListener {
            appendDigits("1")
        }
        btn2.setOnClickListener {
            appendDigits("2")
        }

        btn3.setOnClickListener {
            appendDigits("3")
        }

        btn4.setOnClickListener {
            appendDigits("4")
        }

        btn5.setOnClickListener {
            appendDigits("5")
        }

        btn6.setOnClickListener {
            appendDigits("6")
        }

        btn7.setOnClickListener {
            appendDigits("7")
        }

        btn8.setOnClickListener {
            appendDigits("8")
        }

        btn9.setOnClickListener {
            appendDigits("9")
        }

        btn0.setOnClickListener {
            appendDigits("0")
        }

        btnDot.setOnClickListener {
            appendDigits(".")
        }

    }


    private fun appendDigits(digit: String) {


        digitDisplay.append(digit)


        tvResult.text = digitDisplay.toString()
    }


    private fun selectOperation(c: Char) {

        operation = c
        leftSide = digitDisplay.toString().toDouble()
        digitDisplay.clear()
    }


    private fun operationalButtons() {

        btnAdd.setOnClickListener {
            selectOperation('A')
            tvResult.text = "+"
        }

        btnSubtract.setOnClickListener {
            selectOperation('S')
            tvResult.text = "-"
        }

        btnMultiply.setOnClickListener() {
            selectOperation('M')
            tvResult.text = "*"
        }

        btnPercent.setOnClickListener {
            selectOperation('P')
            tvResult.text = "%"
        }
        btnDivide.setOnClickListener {
            selectOperation('D')
            tvResult.text = "/"
        }

    }

    private fun functionalButtons() {
        btnClearall.setOnClickListener {
            digitDisplay.clear()
            tvResult.text = "0"
        }

        btnClear.setOnClickListener {
            if (digitDisplay.length <= 0)
            {
                return@setOnClickListener

            }
            else{
                clearDigit()
            }
        }

        btnDelete.setOnClickListener {
            if (digitDisplay.length <= 0)
            {
                return@setOnClickListener

            }
            else{
                clearDigit()
            }
        }

        btnEqual.setOnClickListener {
            calculation()
        }

    }


    private fun calculation() {
        rightSide = digitDisplay.toString().toDouble()
        digitDisplay.clear()
        when (operation) {

            'A' -> {
                val sum = OperationsHelper.add(leftSide, rightSide)
                tvResult.text = sum.toString()
                digitDisplay.append(sum)
            }
            'S' -> {
                val subtract = OperationsHelper.subtract(leftSide, rightSide)
                tvResult.text = subtract.toString()
                digitDisplay.append(subtract)
            }
            'M' -> {
                val multiply = OperationsHelper.multiply(leftSide, rightSide)
                tvResult.text = multiply.toString()
                digitDisplay.append(multiply)
            }
            'P' -> {
                val percentage = OperationsHelper.percentage(leftSide, rightSide)
                tvResult.text = percentage.toString()
                digitDisplay.append(percentage)
            }
            'D' -> {
                val div = OperationsHelper.divison(leftSide, rightSide)
                tvResult.text = div.toString()
                digitDisplay.append(div)
            }
        }
    }


    private fun clearDigit() {

        val length = digitDisplay.length

        digitDisplay.deleteCharAt(length - 1)
        tvResult.text = digitDisplay.toString()

    }
    class OperationsHelper {
        companion object {


            fun add(left_hand_side: Double, right_hand_side: Double): Double {
                val sum = left_hand_side + right_hand_side
                return sum
            }


            fun subtract(left_hand_side: Double, right_hand_side: Double): Double {
                val subtract = left_hand_side - right_hand_side
                return subtract
            }

            fun multiply(left_hand_side: Double, right_hand_side: Double): Double {
                val product = left_hand_side * right_hand_side
                return product
            }


            fun percentage(left_hand_side: Double, right_hand_side: Double): Double {
                val percentage = (left_hand_side /100 )* right_hand_side
                return percentage
            }

            fun divison(left_hand_side: Double, right_hand_side: Double): Double {
                val division = left_hand_side/right_hand_side
                return division
            }
        }
    }
}