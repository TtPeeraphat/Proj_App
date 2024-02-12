package com.example.proj_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class ForgotPassword : AppCompatActivity() {
    var FgP_backbtn: ImageButton? =null
    var FgP_edtEmail: EditText?=null
    var FgP_submitbtn: Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        init()
    }
fun init(){
FgP_backbtn = findViewById(R.id.FgP_backbtn)
FgP_submitbtn = findViewById(R.id.FgP_submitbtn)
FgP_edtEmail = findViewById(R.id.FgP_edtEmail)

}
}