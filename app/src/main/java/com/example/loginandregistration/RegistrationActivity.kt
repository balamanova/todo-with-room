package com.example.loginandregistration

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import db.AppDatabase
import db.entities.Person
import kotlinx.android.synthetic.main.activity_registration_acitivity.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration_acitivity)
    }

    fun signUp(view: View) {

        val name = reg_name.editableText.toString()
        val password = reg_password.editableText.toString()
        val surname = reg_surname.editableText.toString()
        val email = reg_email.editableText.toString()

        AsyncTask.execute {
            val person = AppDatabase.getDatabase(applicationContext)
                ?.getPersonDao()
                ?.getPersonByEmail(
                    email = email
                )

            if (person == null) {
                AppDatabase.getDatabase(applicationContext)
                    ?.getPersonDao()
                    ?.insertPerson(
                        Person(
                            name = name,
                            surname = surname,
                            password = password,
                            email = email
                        )
                    )
                runOnUiThread {
                    back(view)
                }

            } else {
                runOnUiThread {
                    Toast.makeText(this@RegistrationActivity, getString(R.string.user_exists_error), Toast.LENGTH_SHORT)
                        .show()

                }

            }


        }
    }
        fun back(view: View) = startActivity(Intent(this, MainActivity::class.java))


        // private fun initUI(name: String, password: String, surname: String, email: String) {

}
