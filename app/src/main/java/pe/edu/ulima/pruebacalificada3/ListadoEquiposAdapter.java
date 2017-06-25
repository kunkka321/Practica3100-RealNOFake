package pe.edu.ulima.pruebacalificada3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by sodm on 6/23/2017.
 */


public class ListadoEquiposAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Equipo> mEquipos;

    public ListadoEquiposAdapter(Context context, List<Equipo> equipos) {
        mEquipos=equipos;
        mInflater= LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 0;
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
        return null;
    }
}
