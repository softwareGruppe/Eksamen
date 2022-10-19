package no.hiof.larseknu.oblig4.repository;

//for å kjøre programmet, med delete, create og update, endre alle steder med CSV/JSON til å være JSON. Endre også returnen til getPlanetSystem

import com.fasterxml.jackson.databind.ObjectMapper;
import no.hiof.larseknu.oblig4.model.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class universeJSONrepository implements IUniversityRepository {
    private List<PlanetSystem> planetSystems;

    public void writeJSON(String filnavn, List<PlanetSystem> planetsystems) {
        ObjectMapper objectmapper = new ObjectMapper();

        try {
            objectmapper.writerWithDefaultPrettyPrinter().writeValue(new File(filnavn), planetsystems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeJSON(File filnavn, List<PlanetSystem> planetsystems) {
        ObjectMapper objectmapper = new ObjectMapper();

        try {
            objectmapper.writerWithDefaultPrettyPrinter().writeValue(filnavn, planetsystems);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<PlanetSystem> readJSON(String filnavn){
        List<PlanetSystem> planetSystems = new ArrayList<>();

        ObjectMapper objectmapper = new ObjectMapper();

        try {
            PlanetSystem[] systemArray = objectmapper.readValue(new File(filnavn), PlanetSystem[].class);
            planetSystems = Arrays.asList(systemArray);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return planetSystems;
    }
    public List<PlanetSystem> readJSON(File filnavn){
        List<PlanetSystem> planetSystems = new ArrayList<>();

        ObjectMapper objectmapper = new ObjectMapper();

        try {
            PlanetSystem[] systemArray = objectmapper.readValue(filnavn, PlanetSystem[].class);
            planetSystems = Arrays.asList(systemArray);
        } catch (IOException e) {
            e.printStackTrace();
        }


        return planetSystems;
    }


    @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        List<PlanetSystem> planetSystems = readJSON("planets_100.JSON");
        PlanetSystem planetsystem = null;
        for (PlanetSystem planetSystem : planetSystems) {
            if (planetSystem.getName().equals(planetSystemName)) {
                planetsystem = planetSystem;
            }
        }
        return planetsystem;
    }

    @Override
    public List<PlanetSystem> getPlanetSystems() {
        return readJSON("planets_100.JSON");
    }

    @Override
    public Planet getPlanet(String planetSystemName, String planetName) {
        return getPlanetSystem(planetSystemName).getPlanet(planetName);
    }

    @Override
    public ArrayList<Planet> getPlanets(String planetSystemName) {
        return getPlanetSystem(planetSystemName).getPlanets();
    }

    @Override
    public List<PlanetSystem> newPlanet(String plansys, String name, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl) {
        List<PlanetSystem> planetsystems = readJSON("planets_100.JSON");
        for (PlanetSystem p: planetsystems){
            ArrayList<Planet> planetArray = new ArrayList<>();
                for(Planet planet: p.getPlanets()){
                        planetArray.add(planet);
                    }
                if(p.getName().equals(plansys)){
                    planetArray.add(new Planet(name, Double.parseDouble(mass), Double.parseDouble(radius), Double.parseDouble(SMA), Double.parseDouble(eccen), Double.parseDouble(orbitalP),p.getCenterStar(), pictureUrl));
                }
                p.setPlanets(planetArray);
            }
        writeJSON("planets_100.JSON", planetsystems);
        return readJSON("planets_100.JSON");
    }


    @Override
    public List<PlanetSystem> alterPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl) {
        List<PlanetSystem> planetsystems = readJSON("planets_100.JSON");
        for(PlanetSystem p: planetsystems){
            if(p.getName().equals(plansys)){
                for(Planet planet: p.getPlanets()){
                    if(planet.getName().equals(navn)){
                        planet.setMass(Double.parseDouble(mass));
                        planet.setRadius(Double.parseDouble(radius));
                        planet.setSemiMajorAxis(Double.parseDouble(SMA));
                        planet.setEccentricity(Double.parseDouble(eccen));
                        planet.setOrbitalPeriod(Double.parseDouble(orbitalP));
                        planet.setPictureUrl(pictureUrl);
                    }
                }
            }
        }
        writeJSON("planets_100.JSON", planetsystems);
        return readJSON("planets_100.JSON");
    }

    @Override
    public List<PlanetSystem> deletePlanet(String plansys, String name) {
        List<PlanetSystem> planetsystems = readJSON("planets_100.Json");
        ArrayList<Planet> planetArray = new ArrayList<>();
        for (PlanetSystem p: planetsystems){
            if(p.getName().equals(plansys)){
                for(Planet planet: p.getPlanets()){
                    if(!planet.getName().equals(name) && !p.getPlanets().contains(planet.getName())){
                        planetArray.add(planet);
                    }}
                p.setPlanets(planetArray);
                    }
                }
        writeJSON("planets_100.JSON",planetsystems);
        return planetsystems;
}

}
