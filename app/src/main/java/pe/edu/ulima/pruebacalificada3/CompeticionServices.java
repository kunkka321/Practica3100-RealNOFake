package pe.edu.ulima.pruebacalificada3;

/**
 * Created by sodm on 6/23/2017.
 */

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CompeticionServices {
    @GET("/v1/competitions/?season=2016")
    Call<CompeticionRespuesta> obtenerCompeticion();
}
