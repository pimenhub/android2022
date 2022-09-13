package com.jpimentel.myappsw.basededatossw;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jpimentel.myappsw.R;
import com.jpimentel.myappsw.complementos.Constantes;
import com.jpimentel.myappsw.complementos.ConsultasDAO;

import org.json.JSONArray;
import org.json.JSONException;
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
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    null,this);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public boolean buscarIdSW(ClienteVO cvo, Context context,
                              Response.Listener listener, Response.ErrorListener errorListener) {
        boolean resultado = false;
        try {
            String url = Constantes.IPSERVER+"apiRestPhpSw2022/buscarId.php?codigoCliente="+cvo.getCodCliente();
            RequestQueue requestQueue = Volley.newRequestQueue(context);
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,
                    listener,errorListener);
            requestQueue.add(jsonObjectRequest);
            resultado = true;
        }
        catch (Exception e){
            Toast.makeText(context, "Error en la conexion "+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        return resultado;
    }

    @Override
    public boolean respuestaBusquedaID(ClienteVO cvo, JSONObject respuesta) {
        boolean resultado = false;
        JSONArray jsonArray = respuesta.optJSONArray("cliente");
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            cvo.setCodCliente(jsonObject.optInt("cod_cliente"));
            cvo.setNombreCliente(jsonObject.optString("nombre_cliente"));
            cvo.setApellidoCliente(jsonObject.optString("apellido_cliente"));
            cvo.setCorreCliente(jsonObject.optString("correo_cliente"));
            cvo.setFechaNacimientoCliente(jsonObject.optString("fecha_nacimiento_cliente"));
            cvo.setLimiteCreditoCliente(jsonObject.optDouble("limite_credito_cliente"));
            String identificadorDeError = jsonObject.optString("error");

            if(identificadorDeError.isEmpty())
                resultado = true;
            else
                resultado = false;

        }
        catch (JSONException e){
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void onResponse(JSONObject response) {
        switch (banderaDeUso){

        }
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        switch (banderaDeUso){
            case 1://INSERTAR
                System.err.println(error);
                break;
        }
    }

}
