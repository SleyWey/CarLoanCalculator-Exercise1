package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var carpriceInput: EditText
    lateinit var downpaymentInput: EditText
    lateinit var loanperiodInput: EditText
    lateinit var interestRateInput: EditText
    lateinit var carloan: TextView
    lateinit var interest: TextView
    lateinit var monthlyrepayment: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        carpriceInput = findViewById(R.id.editTextCarPrice)
        downpaymentInput = findViewById(R.id.editTextDownPayment)
        loanperiodInput = findViewById(R.id.editTextLoanPeriod)
        interestRateInput = findViewById(R.id.editTextInterestRate)
        carloan = findViewById(R.id.textViewLoan)
        interest = findViewById(R.id.textViewInterest)
        monthlyrepayment = findViewById(R.id.textViewMonthlyRepayment)

        val calculateButton: Button = findViewById(R.id.buttonCalculate)
        val resetButton: Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener { calculate() }
        resetButton.setOnClickListener{ reset() }
    }

    private fun calculate(){
        val carloanAns = Integer.parseInt(carpriceInput.text.toString()) - Integer.parseInt(downpaymentInput.text.toString())
        val interestAns = Integer.parseInt(carloanAns.toString()) * Integer.parseInt(interestRateInput.text.toString()) * Integer.parseInt(loanperiodInput.text.toString())
        val monthlyrepaymentAns = (Integer.parseInt(carloanAns.toString()) + Integer.parseInt(interestAns.toString())) / Integer.parseInt(loanperiodInput.text.toString()) / 12

        carloan.setText("Loan: "+carloanAns.toString())
        interest.setText("Interest: "+interestAns.toString())
        monthlyrepayment.setText("Monthly Repayment: "+monthlyrepaymentAns)


    }

    private fun reset(){
        carpriceInput.setText("");
        downpaymentInput.setText("");
        loanperiodInput.setText("");
        interestRateInput.setText("");

        carloan.setText("Loan:");
        interest.setText("Interst:");
        monthlyrepayment.setText("Monthly Repayment:");
    }
}
