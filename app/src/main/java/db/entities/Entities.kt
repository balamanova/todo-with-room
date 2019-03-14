package db.entities

import android.arch.persistence.room.*
import android.os.Parcel
import android.os.Parcelable
import android.provider.ContactsContract


@Entity(tableName = "person")
data class Person(
    @PrimaryKey(autoGenerate = true)
    val person_id: Int? =null,
    @ColumnInfo(name = "name") val name :String,
    @ColumnInfo(name = "surname") val surname :String,
    @ColumnInfo(name = "password") val password :String,
    @ColumnInfo(name = "email") val email :String

    )

@Entity(tableName = "toDo")
data class ToDoItem(

    @PrimaryKey(autoGenerate = true)
    val todo_id: Int? =null,
    @ColumnInfo(name = "title") val title :String,
    @ColumnInfo(name = "content") val content :String,
    @ColumnInfo(name = "priority") val priority :String,
    @ColumnInfo(name = "person_id") val person_id: Int
)