package pe.edu.ulima.pruebacalificada3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sodm on 6/23/2017.
 */

public class ListadoCompetenciaAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<Competencia> mCompetencia;

    public ListadoCompetenciaAdapter(
            Context context, List<Competencia> competencias){
        mCompetencia = competencias;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mCompetencia.size();
    }

    @Override
    public Object getItem(int i) {

        return mCompetencia.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if (view == null){
            view = mInflater.inflate(R.layout.item_competicion, viewGroup, false);

            viewHolder = new ViewHolder();
            viewHolder.tviCompeticion =
                    (TextView) view.findViewById(R.id.tviCompeticion);
            viewHolder.tviNroEquipo=(TextView)view.findViewById(R.id.tviNroEquipo);

            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }

        Competencia competencia = mCompetencia.get(i);
        viewHolder.tviCompeticion.setText(competencia.getLeague());
        viewHolder.tviNroEquipo.setText(String.valueOf(competencia.getNumberOfTeams()));

        return view;


    }

    class ViewHolder{
        TextView tviCompeticion;
        TextView tviNroEquipo;
    }
}
