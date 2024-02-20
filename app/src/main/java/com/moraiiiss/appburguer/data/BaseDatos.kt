package com.moraiiiss.appburguer.data

import android.annotation.SuppressLint
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

    override fun onCreate(db: SQLiteDatabase) {//creamos la tabla hamburguesas
        val SQL_CREATE_HAMBURGUESAS_TABLE = "CREATE TABLE " + HamburguesaEntry.TABLE_NAME + " (" +
                HamburguesaEntry.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                HamburguesaEntry.COLUMN_NOMBRE + " TEXT NOT NULL, " +
                HamburguesaEntry.COLUMN_TIPO + " TEXT, " +
                HamburguesaEntry.COLUMN_PRECIO + " REAL, " +
                HamburguesaEntry.COLUMN_IMAGEN + " BLOB);"
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
                put(HamburguesaEntry.COLUMN_NOMBRE, hamburguesa[0] as String)
                put(HamburguesaEntry.COLUMN_TIPO, hamburguesa[1] as String)
                put(HamburguesaEntry.COLUMN_PRECIO, hamburguesa[2] as Double)
                put(HamburguesaEntry.COLUMN_IMAGEN, hamburguesa[3] as Int)
            }

            val newRowId = db.insert(HamburguesaEntry.TABLE_NAME, null, values)
        }
    }

    @SuppressLint("Range")
    fun obtenerTodasLasHamburguesas(): List<Hamburguesas> {
        val hamburguesas = mutableListOf<Hamburguesas>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM " + HamburguesaEntry.TABLE_NAME, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex(HamburguesaEntry.COLUMN_ID))
                val nombre = cursor.getString(cursor.getColumnIndex(HamburguesaEntry.COLUMN_NOMBRE))
                val tipo = cursor.getString(cursor.getColumnIndex(HamburguesaEntry.COLUMN_TIPO))
                val precio = cursor.getFloat(cursor.getColumnIndex(HamburguesaEntry.COLUMN_PRECIO))
                val imagen = cursor.getInt(cursor.getColumnIndex(HamburguesaEntry.COLUMN_IMAGEN))
                hamburguesas.add(Hamburguesas(id, nombre, tipo, precio, imagen))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return hamburguesas
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + HamburguesaEntry.TABLE_NAME)
        onCreate(db)
    }


}
