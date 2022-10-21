package com.graxa.frutasdoz.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Produtos::class], version = 1, exportSchema = false)
abstract class ProdutosDatabase: RoomDatabase() {

    abstract fun produtosDao(): ProdutosDao

    companion object{
        @Volatile
        private  var INSTANCE: ProdutosDatabase? = null

        fun getDatabase(context: Context): ProdutosDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ProdutosDatabase::class.java,
                    "produtos_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}