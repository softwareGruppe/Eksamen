package no.hiof.larseknu.oblig4.repository;

import no.hiof.larseknu.oblig4.model.Planet;
import no.hiof.larseknu.oblig4.model.PlanetSystem;

import java.util.ArrayList;
import java.util.List;

public interface IUniversityRepository {
    PlanetSystem getPlanetSystem(String planetSystemName);

     List<PlanetSystem> getPlanetSystems();

     Planet getPlanet(String planetSystemName, String planet);

     ArrayList<Planet> getPlanets(String planetSystemName);

    List<PlanetSystem> newPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl);

    List<PlanetSystem> alterPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl);

    List<PlanetSystem> deletePlanet(String plansys, String navn);
}
