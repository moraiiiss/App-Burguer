package com.moraiiiss.appburguer.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.moraiiiss.appburguer.data.HamburguesasDBHelper
import com.moraiiiss.appburguer.data.HamburguesasDBScheme
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object HamburguesasDBModule {

    @Provides
    fun providesHamburguesasDbHelper(@ApplicationContext context: Context): SQLiteDatabase {
        return HamburguesasDBHelper(context).writableDatabase
    }
}