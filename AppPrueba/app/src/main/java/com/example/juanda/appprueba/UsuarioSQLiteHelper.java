package com.example.juanda.appprueba;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuarioSQLiteHelper extends SQLiteOpenHelper {

    //Variable que contiene la sentencia de creacion de la base de datos
    String sql = "CREATE TABLE Cliente (Identificacion INTEGER, Nombres TEXT, Apellidos TEXT, Direccion TEXT, Correo TEXT, Telefono TEXT)";


    public UsuarioSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Este metodo se ejecuta automaticamente cuando la base de datos no está creada.
        //Cuando se hace el primer llamado, la base de datos se crea.
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo se ejecuta cuando la version de la base de datos ha cambiado,
        //Por lo que se deben definir todos los parametros de migracion del ESQUEMA anterior al nuevo.
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL(sql);
    }
}
