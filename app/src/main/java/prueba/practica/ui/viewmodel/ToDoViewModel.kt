package prueba.practica.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import prueba.practica.data.repository.ToDoRepository
import prueba.practica.model.ToDoEntity
import javax.inject.Inject

@HiltViewModel
class ToDoViewModel @Inject constructor(
    private val repository: ToDoRepository
) : ViewModel() {

    private val _todos = MutableLiveData<List<ToDoEntity>>()
    val todos: LiveData<List<ToDoEntity>> = _todos

    fun loadTodos(forceRefresh: Boolean = false) {
        viewModelScope.launch {
            _todos.value = repository.fetchTodos(forceRefresh)
        }
    }

    fun toggleCompletion(todo: ToDoEntity) {
        viewModelScope.launch {
            val updated = todo.copy(completed = !todo.completed)
            repository.updateTodo(updated)


            _todos.value = _todos.value?.map {
                if (it.id == updated.id) updated else it
            }
        }
    }


    fun deleteTodo(todo: ToDoEntity) {
        viewModelScope.launch {
            repository.deleteTodo(todo)
            loadTodos()
        }
    }
}
