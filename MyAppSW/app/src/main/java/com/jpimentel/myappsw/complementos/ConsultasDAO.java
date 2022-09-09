package com.jpimentel.myappsw.complementos;

import android.content.Context;

import com.jpimentel.myappsw.basededatossw.ClienteVO;

public interface ConsultasDAO {

    public boolean insertarSW(ClienteVO cvo, Context context);
}
