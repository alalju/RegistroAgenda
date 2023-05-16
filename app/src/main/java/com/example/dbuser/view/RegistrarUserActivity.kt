package com.example.dbuser.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.dbuser.MainActivity
import com.example.dbuser.R
import com.example.dbuser.dtoUser.UserDto
import com.example.dbuser.userDbHelper.InterfaceUserDao.IOperationUserDao
import com.example.dbuser.userDbHelper.userDao.OperationUserDao

class RegistrarUserActivity : AppCompatActivity(), IOperationUserDao {
    private lateinit var nombre: EditText
    private lateinit var apellidoP: EditText
    private lateinit var apellidoM: EditText
    private lateinit var numeroTel: EditText
    private lateinit var email: EditText
    private lateinit var buttonGuardar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_user)
        initControl()
        buttonGuardar.setOnClickListener {
            lateinit var user:UserDto
            var name:String=nombre.text.toString()
            var lastName:String= apellidoM.text.toString() +" "+ apellidoP.text.toString()
            var phone: String = numeroTel.text.toString()
            var email: String = numeroTel.text.toString()
            user= UserDto(name,lastName,phone,email)
            if(user!=null){
                insertUser(user)
                val intent =  Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }



    private fun initControl(){
        nombre = findViewById(R.id.ru_edt_nombre_usuario)
        apellidoP = findViewById(R.id.ru_edt_apellido_paterno_usuario)
        apellidoM = findViewById(R.id.ru_edt_apellido_materno_usuario)
        numeroTel = findViewById(R.id.ru_edt_numero_telefono_usuario)
        email = findViewById(R.id.ru_edt_correo_usuario)
        buttonGuardar = findViewById(R.id.ru_btn_guardar)
    }

    override fun insertUser(userDto: UserDto): Int {
        var insert:IOperationUserDao= OperationUserDao(this)
        return insert.insertUser(userDto)
    }

    override fun updateUser(userDto: UserDto): Int {
        TODO("Not yet implemented")
    }

    override fun selectUsers(): ArrayList<UserDto> {
        TODO("Not yet implemented")
    }

    override fun selectUserName(name: String): ArrayList<UserDto> {
        TODO("Not yet implemented")
    }

    override fun deleteUser(name: String): Int {
        TODO("Not yet implemented")
    }

    override fun deleteUserID(idUser: String): Int {
        TODO("Not yet implemented")
    }
}