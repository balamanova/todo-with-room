package db.dao

import android.arch.persistence.room.*
import db.entities.Person

@Dao
interface PersonDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPerson(person: Person)

    @Update
    fun updatePerson(person: Person)

    @Delete
    fun deletePerson(person: Person)

    @Query("SELECT * FROM person where email=:email and password = :password")
    fun getPersonByEmailAndPassword(email: String, password: String): Person

    @Query("SELECT * FROM person where email=:email")
    fun getPersonByEmail(email: String): Person
}