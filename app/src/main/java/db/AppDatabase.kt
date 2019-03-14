package db

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import db.dao.ActivityDao
import db.dao.PersonDao
import db.entities.Person
import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration
import db.entities.ToDoItem


@Database(entities = [Person::class,
    ToDoItem::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getPersonDao() : PersonDao
    abstract fun getActivityDao() : ActivityDao


    companion object {

        private const val DB_NAME = "person.db"

        var instance: AppDatabase? = null


        fun getDatabase(context: Context): AppDatabase? {
            if(instance == null){
                synchronized(AppDatabase::class.java) {
                    instance = Room.databaseBuilder(context,
                        AppDatabase::class.java, DB_NAME)
                        .build()
                }
            }

            return instance
        }
    }


}