import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import prueba.practica.databinding.ItemTodoBinding
import prueba.practica.model.ToDoEntity
import prueba.practica.ui.adapter.ToDoDiffCallback

class ToDoAdapter(
    private val onCheckedChange: (ToDoEntity) -> Unit,
    private val onDelete: (ToDoEntity) -> Unit
) : ListAdapter<ToDoEntity, ToDoAdapter.ToDoViewHolder>(ToDoDiffCallback()) {

    inner class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val binding = ItemTodoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            textViewTitle.text = item.title

            checkBoxCompleted.setOnCheckedChangeListener(null)
            checkBoxCompleted.isChecked = item.completed

            checkBoxCompleted.setOnCheckedChangeListener { _, _ ->
                onCheckedChange(item)
            }

            root.setOnLongClickListener {
                onDelete(item)
                true
            }
        }
    }
}
