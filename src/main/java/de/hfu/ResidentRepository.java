package de.hfu;

import java.util.List;

//import de.hfu.residents.domain.Resident;

/**
 * @author Stefan Betermieux
 */
public interface ResidentRepository {

  List<Resident> getResidents();

}