package com.example.task1

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.task1.databinding.ActivityMainBinding

class MainActivity: AppCompatActivity() {
    lateinit var loginBinding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences


    var Email:String?=null
    var Password:String?=null
    var Remember:Boolean=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding = ActivityMainBinding.inflate(layoutInflater)


        setContentView(R.layout.activity_main)


        loginBinding.Login.setOnClickListener {
            Log.d("Message","On resume call")
            sharedPreferences=getSharedPreferences("userdata", MODE_PRIVATE)
            Email=sharedPreferences.getString("username","")
            Password=sharedPreferences.getString("password","")
//

            if(Email.toString() == loginBinding.Email.text.toString()
                && Password.toString() == loginBinding.Password.text.toString()){
                val intent=Intent(this@MainActivity,
                    DashboardActivity::class.java)


                startActivity(intent)
            }else{
                Toast.makeText(applicationContext,"Invalid ",Toast.LENGTH_LONG).show()

            }




        }


        loginBinding.Register.setOnClickListener {

            sharedPreferences=getSharedPreferences("userdata", MODE_PRIVATE)
            Email=loginBinding.Email.text.toString()
            Password=loginBinding.Password.text.toString()

            var editor =sharedPreferences.edit()
            editor.putString("Email",Email)
            editor.putString("password",Password)
            editor.putBoolean("Remember",true
            )

            editor.apply()

            Toast.makeText(applicationContext,"Data saved successfully", Toast.LENGTH_LONG).show()


        }






        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.Remember)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onPause() {
        Log.d("Message","On pause call")
//        sharedPreferences=getSharedPreferences("username", MODE_PRIVATE)
//        username=loginBinding.textOne.text.toString()
//        password=loginBinding.textTwo.text.toString()
//
//        var editor =sharedPreferences.edit()
//        editor.putString("username",username)
//        editor.putString("password",password)
//
//        Toast.makeText(applicationContext,"Data saved", Toast.LENGTH_LONG).show()
//
//


        super.onPause()
    }

    override fun onResume() {

        super.onResume()
    }

}
