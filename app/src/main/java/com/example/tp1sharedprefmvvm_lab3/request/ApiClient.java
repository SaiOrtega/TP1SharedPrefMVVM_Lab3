package com.example.tp1sharedprefmvvm_lab3.request;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tp1sharedprefmvvm_lab3.Model.Usuario;


public class ApiClient {

    private static SharedPreferences sp;

    private static SharedPreferences conectar(Context context){
        if(sp==null){
            sp = context.getSharedPreferences("datos.xml", 0);
        }
        return sp;
    }

    public static void guardar(Context context, Usuario usuario){
        sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong("dni", usuario.getDni());
        editor.putString("nombre", usuario.getNombre());
        editor.putString("apellido", usuario.getApellido());
        editor.putString("mail", usuario.getMail());
        editor.putString("password", usuario.getPassword());
        editor.commit();

    }

    public static Usuario leer(Context context){
        sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "-1");
        String nombre = sp.getString("nombre", "-1");
        String mail = sp.getString("mail", "-1");
        String password = sp.getString("password", "-1");

        Usuario usuario= new Usuario(dni,nombre,apellido,mail,password);
        return usuario;
    }

    public static Boolean login(Context context, String email, String pass){
        Boolean log=false;
        sp = conectar(context);
        Long dni = sp.getLong("dni", -1);
        String apellido = sp.getString("apellido", "-1");
        String nombre = sp.getString("nombre", "-1");
        String mail = sp.getString("mail", "-1");
        String password = sp.getString("password", "-1");
        if (mail.equals(email)&& pass.equals(password)){
           log=true;
        }
        return log;

    }
}
