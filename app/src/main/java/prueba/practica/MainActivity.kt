package prueba.practica

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import prueba.practica.databinding.ActivityMainBinding
import prueba.practica.ui.screen.ToDoScreen

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var screen: ToDoScreen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        screen = ToDoScreen(
            activity = this,
            binding = binding
        )

        screen.initialize()
    }
}
