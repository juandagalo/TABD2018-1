package com.example.juanda.appprueba;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtIdentificacion;
    EditText edtNombres;
    EditText edtApellidos;
    EditText edtDireccion;
    EditText edtCorreo;
    EditText edtTelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtIdentificacion = (EditText) findViewById(R.id.edtIdentificacion);
        edtNombres = (EditText) findViewById(R.id.edtNombres);
        edtApellidos = (EditText) findViewById(R.id.edtApellidos);
        edtDireccion = (EditText) findViewById(R.id.edtDireccion);
        edtCorreo = (EditText) findViewById(R.id.edtCorreo);
        edtTelefono = (EditText) findViewById(R.id.edtTelefono);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_clientes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.action_add:
                //Acá se trabajan todos los controles que definen al cliente para poderlo ingresar
                String identificacion = edtIdentificacion.getText().toString();
                String nombres = edtNombres.getText().toString();
                String apellidos = edtApellidos.getText().toString();
                String direccion = edtDireccion.getText().toString();
                String correo = edtCorreo.getText().toString();
                String telefono = edtTelefono.getText().toString();

                if(identificacion.length()>0 && nombres.length()>0 && apellidos.length()>0 && direccion.length()>0 && correo.length()>0 && telefono.length()>0){
                    UsuarioSQLiteHelper usuario = new UsuarioSQLiteHelper(this, "BDCLientes",null,2);
                    SQLiteDatabase db = usuario.getWritableDatabase();

                    db.execSQL("INSERT INTO Cliente (Identificacion, Nombres, Apellidos, Direccion, Correo, Telefono) values("+ identificacion +",'"+nombres+"','"+ apellidos +"','"+ direccion +"','"+ correo +"','"+ telefono +"')");
                    db.close();

                    Toast.makeText(this,"El usuario se ha crado exitosamente.",Toast.LENGTH_SHORT).show();
                    edtIdentificacion.setText("");
                    edtNombres.setText("");
                    edtApellidos.setText("");
                    edtDireccion.setText("");
                    edtCorreo.setText("");
                    edtTelefono.setText("");
                }else{
                    Toast.makeText(this,"Debe ingresar todos los datos del usuario.",Toast.LENGTH_SHORT).show();
                }

                return true;
             default:
                 return super.onOptionsItemSelected(item);
        }
    }
}
