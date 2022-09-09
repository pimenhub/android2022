package com.jpimentel.myappsw.basededatossw;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jpimentel.myappsw.complementos.Constantes;
import com.jpimentel.myappsw.complementos.ConsultasDAO;

import org.json.JSONObject;

public class ClienteDAO implements ConsultasDAO, Response.Listener<JSONObject>,Response.ErrorListener {

    private Integer banderaDeUso = 0;
    @Override
    public boolean insertarSW(ClienteVO cvo, Context context) {
        boolean resultado = false;
        banderaDeUso = Constantes.INSERTAR;
        try {
            //URL por donde se transladaran los valores a los campos definidos como claves
            String url = Constantes.IPSERVER+"apiRestPhpSw2022/insertar.php?nombreCliente="+cvo.getNombreCliente()+
                    "&apellidoCliente="+cvo.getApellidoCliente()+"&correoCliente="+cvo.getCorreCliente()+
                    "&fechaNacimientoCliente="+cvo.getFechaNacimientoCliente()+"&limiteCreditoCliente="+cvo.getLimiteCreditoCliente();
            //Proceso de interaccion con la api
            RequestQueue requestQueue = Volley.newRequestQueue(context);//define el acceso a la activity para salir a consumir el sw
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,this,this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public void onResponse(JSONObject response) {
        switch (banderaDeUso){
            case 1://INSERTAR
                System.out.println("------------------------------Se Inserto Correctamente");
                break;
        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        switch (banderaDeUso){
            case 1://INSERTAR
                System.out.println("------------------------------Error la insertar "+error);
                break;
        }
    }


}
