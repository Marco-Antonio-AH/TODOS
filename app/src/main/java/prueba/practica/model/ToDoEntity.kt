package prueba.practica.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todos")
data class ToDoEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val completed: Boolean
)
