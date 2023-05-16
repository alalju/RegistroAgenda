package com.example.dbuser.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.dbuser.R
import com.example.dbuser.dtoUser.UserDto
import com.example.dbuser.userDbHelper.InterfaceUserDao.IOperationUserDao
import com.example.dbuser.userDbHelper.userDao.OperationUserDao

class AdapterItem(
    private val datos: MutableList<UserDto>,
    private val context:Context,
    val itemClick: OnItemClickListener
) :
    RecyclerView.Adapter<AdapterItem.ActividadesViewHolder>() {

    private lateinit var user: UserDto;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActividadesViewHolder {
        val item = LayoutInflater.from(context)
            .inflate(R.layout.list_item_custom, parent, false)
        return ActividadesViewHolder(item)
    }

    interface OnItemClickListener{
        fun clickDelete(actividades: UserDto)
        fun clickUpdate(actividades: UserDto)
    }

    override fun onBindViewHolder(holder: ActividadesViewHolder, position: Int) {
        val actividades = datos[position]
        var id:String= actividades.idUser.toString()
        holder.bindActividad(actividades)
        holder.btnEdit.setOnClickListener { itemClick.clickUpdate(actividades) }
        holder.btnDelete.setOnClickListener { itemClick.clickDelete(actividades) }
    }

    override fun getItemCount() = datos.size

    class ActividadesViewHolder(val item: View) : RecyclerView.ViewHolder(item) {
        val lblNombre = item.findViewById(R.id.lblNombre) as TextView
        val lblApellido = item.findViewById(R.id.lblApellido) as TextView
        val lblTelefono = item.findViewById(R.id.lblTelefono) as TextView
        val lblEmail = item.findViewById(R.id.lblEmail) as TextView
        val btnEdit= item.findViewById(R.id.btnEdit) as ImageView
        val btnDelete= item.findViewById(R.id.btnDelete) as ImageView

        fun bindActividad(agenda: UserDto) {
            lblNombre.text = agenda.name
            lblApellido.text = agenda.lastName
            lblTelefono.text = agenda.phoneNumber
            lblEmail.text = agenda.userEmail

        }
    }


}