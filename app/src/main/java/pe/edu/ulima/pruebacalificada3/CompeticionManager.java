package pe.edu.ulima.pruebacalificada3;

/**
 * Created by sodm on 6/23/2017.
 */

import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CompeticionManager {

  List<Competencia> competencia=new ArrayList<>();



    public List<Competencia> Arreglo(){

        Competencia comp =new Competencia();
        comp.setLeague("Española");
        comp.setNumberOfTeams(22);
        competencia.add(comp);
        return competencia;
    }



    public void obtenerCompeticion(final OnCompetenciasCargadasListener listener) {

        Log.i("RestauranteManager","VAAMOS");

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CompeticionServices service = retrofit.create(CompeticionServices.class);
        service.obtenerCompeticion().enqueue(new Callback<List<Competencia>>() {
            @Override
            public void onResponse(Call<List<Competencia>> call,
                                   Response<List<Competencia>> response) {
                Log.i("RestauranteManager","" + response.body().size());

                List<Competencia> res_comp =  response.body();

                List<Competencia> competencias = new ArrayList<Competencia>();

                for (int i = 1; i < res_comp.size(); i++) {
                    Competencia c = new Competencia();
                    c.setLeague(response.body().get(i).getCaption());
                    c.setNumberOfTeams(response.body().get(i).getNumberOfTeams());
                    competencias.add(c);
                }
                listener.onCompetenciasCargadas(competencias);
            }

            @Override
            public void onFailure(Call<List<Competencia>> call, Throwable t) {
                Log.i("RestauranteManager", "ERROR : "+t.getMessage());
                listener.onError(t.getMessage());
            }


        });

    }
    }
