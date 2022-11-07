package com.graxa.frutasdoz.util

import android.content.Context
import androidx.room.Room
import com.graxa.frutasdoz.data.ProdutosDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object PodutosModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ProdutosDatabase::class.java,
    "produtos_table"
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ProdutosDatabase) = database.produtosDao()

}