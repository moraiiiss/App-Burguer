package com.moraiiiss.appburguer.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.moraiiiss.appburguer.R

class BaseDatos(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "AppBurgerDB.db"
        private const val DATABASE_VERSION = 2
    }

    override fun onCreate(db: SQLiteDatabase) {
        val SQL_CREATE_HAMBURGUESAS_TABLE = "CREATE TABLE " + HamburguesasEntry.TABLE_NAME + " (" +
                HamburguesasEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HamburguesasEntry.COLUMN_NOMBRE + " TEXT NOT NULL, " +
                HamburguesasEntry.COLUMN_TIPO + " TEXT, " +
                HamburguesasEntry.COLUMN_PRECIO + " REAL, " +
                HamburguesasEntry.COLUMN_IMAGEN + " BLOB);"
        db.execSQL(SQL_CREATE_HAMBURGUESAS_TABLE)


        // Insertar varias hamburguesas en la base de datos
        val hamburguesas = listOf(
            arrayOf("Hamburguesa TheUltimate", "Ternera", 5.99, R.drawable.theultimate),
            arrayOf("Hamburguesa Vegana", "Vegana", 6.99, R.drawable.vegana),
            arrayOf("Hamburguesa California", "Carne", 5.49, R.drawable.california),
            arrayOf("Hamburguesa Iberian", "Carne", 6.49, R.drawable.iberianburger),
            arrayOf("Hamburguesa Poulet", "Pollo", 7.99, R.drawable.poulet),
            arrayOf("Hamburguesa Buffalo", "Ternera", 6.99, R.drawable.kingbuffalo),
        )

        for (hamburguesa in hamburguesas) {
            val values = ContentValues().apply {
                put(HamburguesasEntry.COLUMN_NOMBRE, hamburguesa[0] as String)
                put(HamburguesasEntry.COLUMN_TIPO, hamburguesa[1] as String)
                put(HamburguesasEntry.COLUMN_PRECIO, hamburguesa[2] as Double)
                put(HamburguesasEntry.COLUMN_IMAGEN, hamburguesa[3] as Int)
            }

            val newRowId = db.insert(HamburguesasEntry.TABLE_NAME, null, values)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS Hamburguesas")
        onCreate(db)
    }
}