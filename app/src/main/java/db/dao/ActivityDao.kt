package db.dao

import android.arch.persistence.room.*
import db.entities.ToDoItem

@Dao
interface ActivityDao{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertActivity(activity: ToDoItem)

    @Update
    fun updateActivity(activity: ToDoItem)

    @Delete
    fun deleteActivity(activity: ToDoItem)

    //@Transaction
    @Query("SELECT * FROM toDo where person_id = :person_id")
    fun getActivitiesById(person_id: Int): List<ToDoItem>
}