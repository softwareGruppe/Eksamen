package no.hiof.larseknu.oblig4.controller;

import io.javalin.http.Context;
import no.hiof.larseknu.oblig4.model.Planet;
import no.hiof.larseknu.oblig4.model.PlanetSystem;
import no.hiof.larseknu.oblig4.repository.IUniversityRepository;

import java.util.*;

public class PlanetController {
    private IUniversityRepository universityRepository;

    public PlanetController(IUniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public void getPlanets(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String sortBy = context.queryParam("sort_by");
        ArrayList<Planet> planets = universityRepository.getPlanets(planetSystemName);

        if (sortBy != null) {
            switch (sortBy) {
                case "name":
                    Collections.sort(planets);
                    break;
                case "mass":
                    planets.sort((o1, o2) -> (int) (o1.getMass() - o2.getMass()));
                    break;
                case "radius":
                    planets.sort((o1, o2) -> {
                        if (o1.getRadius() < o2.getRadius())
                            return -1;
                        else if(o1.getRadius() > o2.getRadius())
                            return 1;
                        return 0;
                    });
                    break;
                case "number":
                    planets.sort((o1, o2) ->{
                        if(o1.distanceToCentralBody(0) < o2.distanceToCentralBody(0))
                            return -1;
                        else if(o1.distanceToCentralBody(0) > o2.distanceToCentralBody(0))
                            return 1;
                        return 0;
                    });
                    break;
            }
        }


        context.json(planets);
    }

    public void getPlanet(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");

        context.json(universityRepository.getPlanet(planetSystemName, planetName));
    }

}
