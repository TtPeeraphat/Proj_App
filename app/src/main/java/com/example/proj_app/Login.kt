package com.example.proj_app

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class Login : AppCompatActivity() {
    var forgot_passbtn:ImageButton?=null
    var regisbtn:ImageButton?=null
    var loginbtn:Button?=null
    var edtUser:EditText?=null
    var edtPass:EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
        forgot_passbtn?.setOnClickListener{
            var intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
        }
        regisbtn?.setOnClickListener{
            var intent = Intent(this,Register::class.java)
            startActivity(intent)
        }
        loginbtn!!.setOnClickListener {
            if(validaUsername()&&validatePassword()){
                val dialogBuilder = AlertDialog.Builder(this)
                dialogBuilder.setMessage("Login Success :)")
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
        val username = edtUser!!.text.toString().trim()
        if(username.isEmpty()) {
            edtUser!!.setError("Field can not be empty")
            return false
        }else if(!(username.length>=6)&&(username.length<=20)) {
            edtUser!!.setError("username lenght 6-20")
            return false
        }else{
            edtUser!!.setError(null)
            return true
        }
    }
    private  fun validatePassword():Boolean{
        val uPass: String = edtPass!!.text.toString().trim()
        val checkPassword = "^"+".*[a-zA-Z]"+".+[0-9]"+".{2,}"
        return if(uPass.isEmpty()){
            edtPass?.setError("field can not be empty")
            false
        }else if(!uPass.matches(checkPassword.toRegex())){
            edtPass?.setError("Password should contain 4 character!")
            false
        }else{
            edtPass?.setError(null)
            true
        }
    }
    fun init (){
        forgot_passbtn = findViewById(R.id.login_forgotBtn)
        regisbtn = findViewById(R.id.login_registerBtn)
        loginbtn = findViewById(R.id.login_loginBtn)
    }
}