package com.act.form.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbContactos extends DbHelper {

    private Context context;

    public DbContactos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarContacto(String nombre, String telefono, String correo_electronico) {
        long id = -1; // Inicializar a un valor predeterminado en caso de error
        try {
            SQLiteDatabase db = getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("telefono", telefono);
            values.put("correo_electronico", correo_electronico);

            id = db.insert(DbHelper.TABLE_CONTACTOS, null, values);
        } catch (Exception ex) {
            ex.printStackTrace(); // Imprime la traza de la excepción
        }
        return id;
    }
}
