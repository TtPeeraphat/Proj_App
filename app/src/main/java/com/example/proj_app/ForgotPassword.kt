package com.example.proj_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class ForgotPassword : AppCompatActivity() {

    var FgP_edtEmail: EditText?=null
    var FgP_submitbtn: Button?=null
    var Fgp_backbtn:ImageButton?=null
    var FgP_summit:Button?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        init()
        Fgp_backbtn?.setOnClickListener {
            var intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
        FgP_summit!!.setOnClickListener {
            validateEmail()
        }
    }
    private fun validateEmail():Boolean {
        val userEmail = FgP_edtEmail!!.text.toString().trim()
        //define pattern
        //val checkEmail = "[a-zA-Z0-9]+@[a-z]+.+[a-z]"
        val checkEmail = "[a-zA-Z0-9._-]+@kkumail.com"
        val checkEmail1 = "[a-zA-Z0-9._-]+@kku.ac.th"
        if (userEmail.isEmpty()) {
            FgP_edtEmail!!.setError("Field can not be empty")
            return false

        } else if (!userEmail.matches(checkEmail.toRegex()) &&
            !userEmail.matches(checkEmail1.toRegex())
        ) {
            FgP_edtEmail!!.setError("Invalid Email")
            return false
        } else {
            FgP_edtEmail!!.setError(null)
            return true
        }
    }
    fun init(){

    FgP_submitbtn = findViewById(R.id.forgot_submitbtn)
    FgP_edtEmail = findViewById(R.id.forgot_emailtxt)
        Fgp_backbtn = findViewById(R.id.forgot_backbtn)
        FgP_summit = findViewById(R.id.forgot_submitbtn)


}
}