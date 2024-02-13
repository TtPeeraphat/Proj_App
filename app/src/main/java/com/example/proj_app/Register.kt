package com.example.proj_app

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class Register : AppCompatActivity() {
    var Regis_back:ImageButton?=null
    var Regis_user:EditText?=null
    var Regis_pass:EditText?=null
    var Regis_cpass:EditText?=null
    var Regis_email:EditText?=null
    var Regis_summit:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        init()
        Regis_back?.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        Regis_summit!!.setOnClickListener {
            validateEmail()
        }
        Regis_summit!!.setOnClickListener {
            if(validaUsername()&&validatePassword()&&validateCpassword()&&validateEmail()){
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage("Register Success :)")
                    .setCancelable(false)
                    .setPositiveButton(" Next ", DialogInterface.OnClickListener {
                            dialog, id ->
                        var intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    })

                val alert = dialogBuilder.create()
                alert.setTitle("Hello User!")
                alert.show()
            }
        }


    }
        private fun validaUsername():Boolean{
            val username = Regis_user!!.text.toString().trim()
            if(username.isEmpty()) {
                Regis_user!!.setError("Field can not be empty")
                return false
            }else if(!(username.length>=6)&&(username.length<=20)) {
                Regis_user!!.setError("username lenght 6-20")
                return false
            }else{
                Regis_user!!.setError(null)
                return true
            }
        }

        private  fun validatePassword():Boolean{
            val uPass: String = Regis_pass!!.text.toString().trim()
            val checkPassword = "^"+".*[a-zA-Z]"+"+[0-9]"
            if(uPass.isEmpty()){
                Regis_pass?.setError("Field can not be empty")
                return false
            }else if(!uPass.matches(checkPassword.toRegex())&&uPass.length<4){
                Regis_pass?.setError("Password should contain 4 character!")
                return false
            }else{
                Regis_pass?.setError(null)
                return true
            }
        }
        private fun validateCpassword(): Boolean {
            val confirmPass = Regis_cpass!!.text.toString().trim()
            val userPass = Regis_cpass!!.text.toString().trim()
            if (confirmPass.isEmpty()) {
                Regis_cpass!!.setError("Field can not be empthy ")
                return false
            } else if (!confirmPass.equals(userPass)) {
                Regis_cpass!!.setError("password and confirm must equal")
                return false
            } else {
                Regis_cpass!!.setError(null)
                return true
            }
        }

        private fun validateEmail():Boolean {
            val userEmail = Regis_email!!.text.toString().trim()
            //define pattern
            //val checkEmail = "[a-zA-Z0-9]+@[a-z]+.+[a-z]"
            val checkEmail = "[a-zA-Z0-9._-]+@kkumail.com"
            val checkEmail1 = "[a-zA-Z0-9._-]+@kku.ac.th"
            if (userEmail.isEmpty()) {
                Regis_email!!.setError("Field can not be empty")
                return false

            } else if (!userEmail.matches(checkEmail.toRegex()) &&
                !userEmail.matches(checkEmail1.toRegex())
            ) {
                Regis_email!!.setError("Invalid Email")
                return false
            } else {
                Regis_email!!.setError(null)
                return true
            }
        }
            fun init() {
                Regis_back = findViewById(R.id.Regis_backbtn)
                Regis_user = findViewById(R.id.register_usernametxt)
                Regis_pass = findViewById(R.id.register_passtxt)
                Regis_cpass = findViewById(R.id.register_confirmpasstxt)
                Regis_email = findViewById(R.id.register_emailtxt)
                Regis_summit = findViewById(R.id.register_submitbtn)
            }

}