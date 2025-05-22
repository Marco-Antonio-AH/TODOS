package prueba.practica.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import prueba.practica.model.ToDoEntity

@Database(entities = [ToDoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun toDoDao(): ToDoDao
}
