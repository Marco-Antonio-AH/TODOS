package prueba.practica.data.repository

import prueba.practica.data.local.ToDoDao
import prueba.practica.model.ToDoEntity
import prueba.practica.data.remote.ApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToDoRepository @Inject constructor(
    private val api: ApiService,
    private val dao: ToDoDao
) {
    suspend fun fetchTodos(forceRefresh: Boolean = false): List<ToDoEntity> {
        val cached = dao.getAll()
        if (cached.isNotEmpty() && !forceRefresh) return cached
        return try {
            val response = api.getTodos()
            val mapped = response.map { ToDoEntity(it.id, it.title, it.completed) }
            dao.insertAll(mapped)
            mapped
        } catch (e: Exception) {
            cached // fallback to local
        }
    }

    suspend fun updateTodo(todo: ToDoEntity) = dao.insertAll(listOf(todo))
    suspend fun deleteTodo(todo: ToDoEntity) = dao.delete(todo)
}
