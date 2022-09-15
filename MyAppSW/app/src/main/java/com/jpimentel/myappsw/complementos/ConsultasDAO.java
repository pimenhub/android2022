package com.jpimentel.myappsw.complementos;

import android.content.Context;
import com.android.volley.Response;
import com.jpimentel.myappsw.basededatossw.ClienteVO;
import org.json.JSONObject;

import java.util.ArrayList;


public interface ConsultasDAO {

    public boolean insertarSW(ClienteVO cvo, Context context);
    public boolean buscarIdSW(ClienteVO cvo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respuestaBusquedaID(ClienteVO cvo, JSONObject respuesta);
    public boolean listarMostrarSW(ClienteVO cvo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public ArrayList<ClienteVO> respuestaListarMostrar(JSONObject respuesta);
    public boolean actualizarSW(ClienteVO cvo, Context context);
    public boolean eliminarSW(ClienteVO cvo, Context context);
}

