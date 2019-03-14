package com.example.loginandregistration

import android.content.Intent
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import db.AppDatabase
import db.entities.ToDoItem
import kotlinx.android.synthetic.main.activity_add.*
import java.lang.Exception

class Add : AppCompatActivity() {

    lateinit var sharedPreference:SharedPreference;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        sharedPreference = SharedPreference(this);

        var priority_list = arrayOf(getString(R.string.high),
            getString(R.string.low),
            getString(R.string.medium))

        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, priority_list)
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner!!.setAdapter(aa)
    }

    fun save(view: View){
        val title = toDoTitle.editableText.toString()
        val content = content.editableText.toString()
        val priority = spinner.selectedItem.toString()
        val personId = sharedPreference.getCurrentId()
        try{
            setData(title, content, priority, personId)
            Toast.makeText(this, getString(R.string.isSaved), Toast.LENGTH_SHORT).show()

            goToHome(view);
        } catch (e: Exception){
            Toast.makeText(this, getString(R.string.notSaved), Toast.LENGTH_SHORT).show()
        }
    }

    fun setData(title: String, content: String, priority: String, personId: Int) {
        AsyncTask.execute {
            val activity = AppDatabase.getDatabase(applicationContext)
                ?.getActivityDao()
                ?.insertActivity(
                    ToDoItem(
                        title = title,
                        content = content,
                        priority = priority,
                        person_id = personId
                    )
                )

        }
    }

    fun goToHome(view: View) = startActivity(Intent(this, HomeActivity::class.java))


}
