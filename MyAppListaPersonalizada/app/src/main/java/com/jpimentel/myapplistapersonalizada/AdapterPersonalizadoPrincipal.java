package com.jpimentel.myapplistapersonalizada;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterPersonalizadoPrincipal extends BaseAdapter {

    private Context context;
    private int referenciaLista;
    private ArrayList<Integer> userImages = new ArrayList<>();
    private ArrayList<String> userNames = new ArrayList<>();

    public AdapterPersonalizadoPrincipal(Context context, int referenciaLista, ArrayList<Integer> userImages, ArrayList<String> userNames) {
        this.context = context;
        this.referenciaLista = referenciaLista;
        this.userImages = userImages;
        this.userNames = userNames;
    }

    public AdapterPersonalizadoPrincipal() {
    }

    @Override
    public int getCount() {
        return this.userNames.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View v = view;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.lista_personalizada_principal, null);

        int userImgDato = this.userImages.get(i);
        String userNameDato = this.userNames.get(i);

        ImageView imageView = v.findViewById(R.id.imgUserList);
        TextView textView = v.findViewById(R.id.txtUserNameList);

        imageView.setImageResource(userImgDato);
        textView.setText(String.valueOf(userNameDato));
        return v;
    }
}
