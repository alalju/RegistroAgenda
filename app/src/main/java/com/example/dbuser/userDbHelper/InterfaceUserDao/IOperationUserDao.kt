package com.example.dbuser.userDbHelper.InterfaceUserDao

import com.example.dbuser.dtoUser.UserDto

interface IOperationUserDao {
     fun insertUser(userDto: UserDto): Int
     fun updateUser(userDto: UserDto): Int
     fun selectUsers(): ArrayList<UserDto>
     fun selectUserName(name: String): ArrayList<UserDto>
     fun deleteUser(name: String): Int
     fun deleteUserID(idUser: String): Int

}