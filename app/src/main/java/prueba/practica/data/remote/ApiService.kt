package prueba.practica.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("todos")
    suspend fun getTodos(): List<ToDoDto>
}
