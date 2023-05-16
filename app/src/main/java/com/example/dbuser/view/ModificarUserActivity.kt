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

class ModificarUserActivity : AppCompatActivity(), IOperationUserDao {
    private lateinit var nombre: EditText
    private lateinit var apellidoP: EditText
    private lateinit var numeroTel: EditText
    private lateinit var email: EditText
    private lateinit var buttonGuardar: Button

    private var id:Long=-1
    private lateinit var nombreUs: String
    private lateinit var apellidosUs:String
    private lateinit var telUs:String
    private lateinit var emailUs:String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_modificar_user)
        initControl()
        putExtra()
        llenarCampos()
        clickGuardar()

    }

    private fun putExtra(){
        val bundle = intent.extras
        val id  =  bundle?.getLong("id")
        if (id != null) {
            this.id=id
        }
        val nombreU  =  bundle?.getString("nombre")
        nombreUs=nombreU.toString()
        val apellidos  =  bundle?.getString("apellido")
        apellidosUs= apellidos.toString()
        val tel  =  bundle?.getString("tel")
        telUs= tel.toString()
        val emailU  =  bundle?.getString("email")
        emailUs=emailU.toString()

    }

    private fun initControl(){
        nombre = findViewById(R.id.mu_edt_nombre_usuario)
        apellidoP = findViewById(R.id.mu_edt_apellido_paterno_usuario)
        numeroTel = findViewById(R.id.mu_edt_numero_telefono_usuario)
        email = findViewById(R.id.mu_edt_correo_usuario)
        buttonGuardar = findViewById(R.id.mu_btn_guardar)
    }

    private fun llenarCampos(){
        nombre.setText(nombreUs)
        apellidoP.setText(apellidosUs)
        numeroTel.setText(telUs)
        email.setText(emailUs)
    }

    private fun clickGuardar(){
        buttonGuardar.setOnClickListener {
            var usuario= UserDto(id,nombreUs,apellidosUs,telUs,emailUs)
            var id=updateUser(usuario)
            if(id>-1){
                System.out.println("Insersion correcta")
            }
            val intent =  Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    override fun insertUser(userDto: UserDto): Int {
        TODO("Not yet implemented")
    }

    override fun updateUser(userDto: UserDto): Int {
        var update: IOperationUserDao= OperationUserDao(this)
        return update.updateUser(userDto)
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