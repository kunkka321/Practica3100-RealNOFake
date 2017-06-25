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

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.football-data.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CompeticionServices service = retrofit.create(CompeticionServices.class);
        service.obtenerCompeticion().enqueue(new Callback<CompeticionRespuesta>() {
            @Override
            public void onResponse(Call<CompeticionRespuesta> call,
                                   Response<CompeticionRespuesta> response) {
                Log.i("RestauranteManager","" + response.body().getResult().size());
                List<Competencia> competencias = new ArrayList<Competencia>();
                for (int i = 1; i < response.body().getResult().size(); i++) {
                    List<String> competencia = response.body().getResult().get(i);
                    competencias.add(new Competencia(Integer.parseInt(competencia.get(0)),

                            competencia.get(1), competencia.get(2),
                            Integer.parseInt(competencia.get(3)), Integer.parseInt(competencia.get(4)),
                            Integer.parseInt(competencia.get(5)), Integer.parseInt(competencia.get(6)),Integer.parseInt(competencia.get(7)),competencia.get(8))



                    );
                }
                listener.onCompetenciasCargadas(competencias);
            }

            @Override
            public void onFailure(Call<CompeticionRespuesta> call, Throwable t) {
                listener.onError(t.getMessage());
            }


        });

    }
    }
