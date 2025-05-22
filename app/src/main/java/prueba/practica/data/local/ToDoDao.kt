package prueba.practica.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import prueba.practica.model.ToDoEntity

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todos")
    suspend fun getAll(): List<ToDoEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(todos: List<ToDoEntity>)

    @Delete
    suspend fun delete(todo: ToDoEntity)

    @Query("DELETE FROM todos WHERE completed = 1")
    suspend fun deleteCompleted()
}
