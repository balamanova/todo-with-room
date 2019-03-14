package com.example.loginandregistration

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.loginandregistration.adapter.ActionAdapter
import db.AppDatabase
import db.entities.Person
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreference:SharedPreference;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreference = SharedPreference(this);

        if(sharedPreference.getIsLogged()){
            goToHome()
        }
    }

     fun signIn(view: View){

        val email = login_email.editableText.toString()
        val password = login_pass.editableText.toString()


            AsyncTask.execute {
                val person = AppDatabase.getDatabase(applicationContext)
                    ?.getPersonDao()
                    ?.getPersonByEmail(
                        email = email
                    )
                runOnUiThread {
                    if(person == null){
                        Toast.makeText(this@MainActivity, getString(R.string.no_user_error), Toast.LENGTH_SHORT).show()
                    } else {
                        sharedPreference.setId(person.person_id!!)
                        goToHome();
                    }
                }
            }

    }

    fun signUp(view: View) = startActivity(Intent(this, RegistrationActivity::class.java))

    fun goToHome() = startActivity(Intent(this, HomeActivity::class.java))

}
