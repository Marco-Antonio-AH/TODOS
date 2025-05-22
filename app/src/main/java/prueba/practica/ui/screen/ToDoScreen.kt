package prueba.practica.ui.screen

import ToDoAdapter
import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import prueba.practica.MainActivity
import prueba.practica.databinding.ActivityMainBinding
import prueba.practica.ui.viewmodel.ToDoViewModel

class ToDoScreen(
    private val activity: MainActivity,
    private val binding: ActivityMainBinding
) {
    private val viewModel by lazy {

        ViewModelProvider(activity)[ToDoViewModel::class.java]
    }

    private val adapter = ToDoAdapter(
        onCheckedChange = { viewModel.toggleCompletion(it) },
        onDelete = { viewModel.deleteTodo(it) }
    )

    fun initialize() {
        setupRecyclerView()
        observeTodos()
        checkNetworkAndLoad()
    }

    private fun setupRecyclerView() {
        binding.todoRecyclerView.layoutManager = LinearLayoutManager(activity)
        binding.todoRecyclerView.adapter = adapter
    }

    private fun observeTodos() {
        viewModel.todos.observe(activity) { todos ->
            adapter.submitList(todos)
        }
    }

    private fun checkNetworkAndLoad() {
        if (isNetworkAvailable()) {
            viewModel.loadTodos(forceRefresh = true)
        } else {
            showMessage("Sin conexión, usando datos locales.")
            viewModel.loadTodos(forceRefresh = false)
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val cm = activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo?.isConnectedOrConnecting == true
    }

    private fun showMessage(msg: String) {
        Snackbar.make(binding.root, msg, Snackbar.LENGTH_LONG).show()
    }
}
