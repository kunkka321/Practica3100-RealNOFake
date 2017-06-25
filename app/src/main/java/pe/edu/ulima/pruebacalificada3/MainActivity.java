package pe.edu.ulima.pruebacalificada3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity implements AdapterView.OnClickListener,OnCompetenciasCargadasListener{

    ListView lviCompeticion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competicion);

        lviCompeticion = (ListView) findViewById(R.id.lviCompeticion);
        new CompeticionManager().obtenerCompeticion(this);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCompetenciasCargadas(List<Competencia> competencias) {



        ListadoCompetenciaAdapter adapter =
                new ListadoCompetenciaAdapter(this,competencias);
        lviCompeticion.setAdapter(adapter);


    }

    @Override
    public void onError(String error) {

    }
}

