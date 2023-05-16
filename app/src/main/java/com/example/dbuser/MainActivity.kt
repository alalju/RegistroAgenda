package com.example.dbuser
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dbuser.adapter.AdapterItem
import com.example.dbuser.dtoUser.UserDto
import com.example.dbuser.userDbHelper.InterfaceUserDao.IOperationUserDao
import com.example.dbuser.userDbHelper.userDao.OperationUserDao
import com.example.dbuser.view.ModificarUserActivity
import com.example.dbuser.view.RegistrarUserActivity
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), IOperationUserDao,AdapterItem.OnItemClickListener {
    private lateinit var recView: RecyclerView
    private lateinit var btnInsertar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnInsertar = findViewById(R.id.btnInsertar)
        recView = findViewById(R.id.recyclerView)

        //val datos = MutableList(50) { i -> Agenda("Titulo $i", "Subtítulo Item $i", "Descripción $i") }


        val adaptador = AdapterItem(selectUsers(),this,this)
        recView.setHasFixedSize(true)

        recView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        recView.itemAnimator = DefaultItemAnimator()

        recView.adapter = adaptador



        btnInsertar.setOnClickListener {
            val intent =  Intent(this, RegistrarUserActivity::class.java)
            startActivity(intent)
        }

    }

    override fun insertUser(userDto: UserDto): Int {
        TODO("Not yet implemented")
    }

    override fun updateUser(userDto: UserDto): Int {
        TODO("Not yet implemented")
    }

    override fun selectUsers(): ArrayList<UserDto> {
        var selectUsers: IOperationUserDao = OperationUserDao(this)
        return selectUsers.selectUsers()
    }

    override fun selectUserName(name: String): ArrayList<UserDto> {
        TODO("Not yet implemented")
    }

    override fun deleteUser(name: String): Int {
        var delete:IOperationUserDao= OperationUserDao(this)
        return delete.deleteUser(name)
    }

    override fun deleteUserID(idUser: String): Int {
        var delete:IOperationUserDao= OperationUserDao(this)
        return delete.deleteUserID(idUser)
    }

    override fun clickDelete(actividades: UserDto){
        deleteUserID(actividades.idUser.toString())
    }

    override fun clickUpdate(actividades: UserDto) {
        var intent=  Intent(this, ModificarUserActivity::class.java)
        intent.putExtra("id",actividades.idUser)
        intent.putExtra("nombre",actividades.name)
        intent.putExtra("apellido",actividades.lastName)
        intent.putExtra("tel",actividades.phoneNumber)
        intent.putExtra("email",actividades.userEmail)
        startActivity(intent)
    }
}