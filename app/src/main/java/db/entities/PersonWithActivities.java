package db.entities;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import java.util.List;

public class PersonWithActivities {
    @Embedded
    public Person person;
    @Relation(parentColumn = "activity_id", entity = ToDoItem.class, entityColumn = "person_id")
    public List<Person> personList;
}
