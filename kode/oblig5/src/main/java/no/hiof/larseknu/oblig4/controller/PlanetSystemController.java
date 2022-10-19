package no.hiof.larseknu.oblig4.controller;

import io.javalin.http.Context;
import no.hiof.larseknu.oblig4.repository.IUniversityRepository;



public class PlanetSystemController {
    private IUniversityRepository universityRepository;

    public PlanetSystemController(IUniversityRepository universeRepository) {
        this.universityRepository = universeRepository;
    }

    public void getAllPlanetSystems(Context context) {
        context.json(universityRepository.getPlanetSystems());
    }

    public void getPlanetSystem(Context context) {
        String planetSystemName = context.pathParam("planet-system-id");
        context.json(universityRepository.getPlanetSystem(planetSystemName));
    }

    public void newPlanet(Context context){
        String planetSystemName = context.pathParam("planet-system-id");
        String planetName = context.formParam("name");
        String planetMass = context.formParam("mass");
        String planetRadius = context.formParam("radius");
        String planetSMA = context.formParam("semiMajorAxis");
        String planetEccen = context.formParam("eccentricity");
        String planetOrbitalP = context.formParam("orbitalPeriod");
        String planetPicture = context.formParam("pictureUrl");
        context.json(universityRepository.newPlanet(planetSystemName, planetName, planetMass, planetRadius, planetSMA, planetEccen, planetOrbitalP, planetPicture));
        context.redirect("/planet-systems/" + planetSystemName);
    }
    public void deletePlanet(Context context){
        String plansys = context.pathParam("planet-system-id");
        String name = context.pathParam("planet-id");
        context.json(universityRepository.deletePlanet(plansys, name));
        context.redirect("/planet-systems/" + plansys);
    }
    public void alterPlanet(Context context){
        String planetSystemname = context.pathParam("planet-system-id");
        String planetName = context.pathParam("planet-id");
        String planetMass = context.formParam("mass");
        String planetRadius = context.formParam("radius");
        String planetSMA = context.formParam("semiMajorAxis");
        String planetOrbitalP = context.formParam("orbitalPeriod");
        String planetEccen = context.formParam("eccentricity");
        String planetPicture = context.formParam("pictureUrl");

        universityRepository.alterPlanet(planetSystemname, planetName, planetMass, planetRadius, planetSMA, planetEccen, planetOrbitalP, planetPicture);
        context.redirect("/planet-systems/" + planetSystemname);
    }
}
