package com.jpimentel.myappsw.complementos;

import android.content.Context;
import com.android.volley.Response;
import com.jpimentel.myappsw.basededatossw.ClienteVO;
import org.json.JSONObject;


public interface ConsultasDAO {

    public boolean insertarSW(ClienteVO cvo, Context context);
    public boolean buscarIdSW(ClienteVO cvo, Context context, Response.Listener listener, Response.ErrorListener errorListener);
    public boolean respuestaBusquedaID(ClienteVO cvo, JSONObject respuesta);
}
