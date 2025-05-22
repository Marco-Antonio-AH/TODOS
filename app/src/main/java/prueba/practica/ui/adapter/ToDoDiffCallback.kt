package prueba.practica.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import prueba.practica.model.ToDoEntity

class ToDoDiffCallback : DiffUtil.ItemCallback<ToDoEntity>() {
    override fun areItemsTheSame(oldItem: ToDoEntity, newItem: ToDoEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ToDoEntity, newItem: ToDoEntity): Boolean {
        return oldItem == newItem
    }
}
