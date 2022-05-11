package com.saico.contactlist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.saico.contactlist.databinding.ItemContactBinding
import com.saico.contactlist.model.Person

class ContactsAdapter(private val dataSet: List<Person>): RecyclerView.Adapter<ContactsAdapter.ViewHolder>() {

    /**
     * Proporciona una referencia al tipo de vistas que está utilizando
     * (custom ViewHolder).
     */
    class ViewHolder(private val binding: ItemContactBinding) : RecyclerView.ViewHolder(binding.root) {
        var picture: ImageView = binding.pictureImage
        var fullName: TextView = binding.fullnameText
        var email: TextView = binding.emailText
        var additionalText: TextView = binding.aditionalText
        var btnViewDetail: Button = binding.btnGoTeacher
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Crear una nueva vista, que define la interfaz de usuario del elemento de la lista
        val itemBinding = ItemContactBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    // Reemplazar el contenido de una vista (invocado por el administrador de diseño)
    override fun onBindViewHolder(binding: ViewHolder, position: Int) {

        // Obtenga el elemento de su conjunto de datos en esta posición y reemplace el contenido de la vista con ese elemento

        val person: Person = this.dataSet[position]

        val context = binding.itemView.context

        val idRes = context.resources.getIdentifier(person.picture, "drawable", context.packageName)

        binding.fullName.text = person.fullName
        binding.email.text = person.email
        binding.picture.setImageResource(idRes)

        binding.picture.setOnClickListener {
            Toast.makeText(context, "Click Picture $position", Toast.LENGTH_SHORT).show()
        }

        if (person.id == 400) {
            binding.additionalText.visibility = View.VISIBLE
        }

        if (person.id == 600) {
            binding.btnViewDetail.visibility = View.VISIBLE
            binding.btnViewDetail.setOnClickListener {
                Toast.makeText(context, "Show Detail Teacher ${person.fullName}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    //Devuelve el tamaño de tu conjunto de datos (invocado por el administrador de diseño)
    override fun getItemCount(): Int = dataSet.size
}