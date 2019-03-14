package com.example.loginandregistration

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.loginandregistration.adapter.ActionAdapter
import db.AppDatabase
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var sharedPreference:SharedPreference;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sharedPreference = SharedPreference(this);

        initUI();
    }

    fun addActivity(view: View)  = startActivity(Intent(this, Add::class.java))

    fun logOut(view: View){
        sharedPreference.setIsLogged()
        startActivity(Intent(this, MainActivity::class.java))
    }

    private fun initUI() {
        toDoList.layoutManager = LinearLayoutManager(this)

        AsyncTask.execute {

         val activities = AppDatabase.getDatabase(applicationContext)
                ?.getActivityDao()
                ?.getActivitiesById(sharedPreference.getCurrentId())

            runOnUiThread {
                val adapter = ActionAdapter(activities!!)

                toDoList.adapter = adapter
            }
        }

    }
}
