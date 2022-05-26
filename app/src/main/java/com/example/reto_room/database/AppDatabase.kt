package com.example.reto_room.database

import androidx.room.Database
import androidx.room.RoomDatabase

const val TABLE_USERS="users"
const val DATABASE_VERSION=1
const val DATABASE_NAME="appdatabase.sqlite"


@Database(entities = [UserEntity::class],
    version = DATABASE_VERSION
)
abstract class AppDatabase : RoomDatabase(){
    abstract  fun userDao(): UserDao
}