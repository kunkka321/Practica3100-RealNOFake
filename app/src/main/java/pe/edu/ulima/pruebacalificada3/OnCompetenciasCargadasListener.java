package pe.edu.ulima.pruebacalificada3;

import java.util.List;

/**
 * Created by sodm on 6/23/2017.
 */

public interface OnCompetenciasCargadasListener {

    public void onCompetenciasCargadas(List<Competencia> competencias);
    public void onError(String error);
}
