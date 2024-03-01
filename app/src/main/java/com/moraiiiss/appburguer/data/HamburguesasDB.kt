package com.moraiiiss.appburguer.data

import com.moraiiiss.appburguer.data.HamburguesasDBScheme.TABLE_NAME

object HamburguesasDBScheme {


    const val TABLE_NAME = "Hamburguesas"
    const val COLUMN_ID = "id"
    const val COLUMN_NOMBRE = "nombre"
    const val COLUMN_TIPO = "tipo"
    const val COLUMN_PRECIO = "precio"
    const val COLUMN_IMAGEN = "imagen"
}
const val SQL_CREATE_HAMBURGUESAS_ENTRIES = """
    CREATE TABLE ${HamburguesasDBScheme.TABLE_NAME} (
        ${HamburguesasDBScheme.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,
        ${HamburguesasDBScheme.COLUMN_NOMBRE} TEXT NOT NULL,
        ${HamburguesasDBScheme.COLUMN_TIPO} TEXT,
        ${HamburguesasDBScheme.COLUMN_PRECIO} REAL,
        ${HamburguesasDBScheme.COLUMN_IMAGEN} BLOB
    )"""

const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"