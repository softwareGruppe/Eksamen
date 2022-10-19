/*package no.hiof.larseknu.oblig4.repository;

//Endre det som er for JSON i filene og erstatt med at den bruker CSV repository, da leser den planets_100 filen, og skriver den tilbake til en ny csv fil.
//Får å få ut riktig data for å lese og skrive filer, endre getPlanetSystems i IUniversityRepository til å returne HashMap<String, PlanetSystem> og ikke List.


import no.hiof.larseknu.oblig4.model.Planet;
import no.hiof.larseknu.oblig4.model.PlanetSystem;
import no.hiof.larseknu.oblig4.model.Star;

import java.io.*;
import java.util.*;

public class UniverseCSVrepository implements IUniversityRepository {

    public static void main(String[] args) {
        skrivTilCSVFil(readCSV("planets_100.CSV"), "planets_100_new.CSV");
    }

    private static HashMap<String, PlanetSystem> readCSV(String filnavn) {
        HashMap<String, PlanetSystem> planetsystems = new HashMap<>();

        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(filnavn))) {
            String linje;

            while ((linje = bufretLeser.readLine()) != null) {

                String[] values = linje.split(",");
                if (!planetsystems.containsKey(values[0]) && !planetsystems.containsValue(values[2])) {
                    Star star = new Star(values[2], Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), values[6]);
                    PlanetSystem planetsystem = new PlanetSystem(values[0], star, values[1]);
                    Planet planet = new Planet(values[7], Double.parseDouble(values[8]), Double.parseDouble(values[9]), Double.parseDouble(values[10]), Double.parseDouble(values[11]), Double.parseDouble(values[12]), star, values[13]);
                    planetsystem.addPlanet(planet);
                    planetsystems.put(values[0], planetsystem);
                } else if (planetsystems.containsKey(values[0])) {
                    PlanetSystem planetsystem = planetsystems.get(values[0]);
                    Star star = planetsystem.getCenterStar();
                    Planet planet = new Planet(values[7], Double.parseDouble(values[8]), Double.parseDouble(values[9]), Double.parseDouble(values[10]), Double.parseDouble(values[11]), Double.parseDouble(values[12]), star, values[13]);
                    planetsystems.get(values[0]).addPlanet(planet);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return planetsystems;
    }

    private static HashMap<String, PlanetSystem> readCSV(File filnavn) {
        HashMap<String, PlanetSystem> planetsystems = new HashMap<>();

        try (BufferedReader bufretLeser = new BufferedReader(new FileReader(filnavn))) {
            String linje;

            while ((linje = bufretLeser.readLine()) != null) {

                String[] values = linje.split(",");
                if (!planetsystems.containsKey(values[0]) && !planetsystems.containsValue(values[2])) {
                    Star star = new Star(values[2], Double.parseDouble(values[3]), Double.parseDouble(values[4]), Double.parseDouble(values[5]), values[6]);
                    PlanetSystem planetsystem = new PlanetSystem(values[0], star, values[1]);
                    Planet planet = new Planet(values[7], Double.parseDouble(values[8]), Double.parseDouble(values[9]), Double.parseDouble(values[10]), Double.parseDouble(values[11]), Double.parseDouble(values[12]), star, values[13]);
                    planetsystem.addPlanet(planet);
                    planetsystems.put(values[0], planetsystem);
                } else if (planetsystems.containsKey(values[0])) {
                    PlanetSystem planetsystem = planetsystems.get(values[0]);
                    Star star = planetsystem.getCenterStar();
                    Planet planet = new Planet(values[7], Double.parseDouble(values[8]), Double.parseDouble(values[9]), Double.parseDouble(values[10]), Double.parseDouble(values[11]), Double.parseDouble(values[12]), star, values[13]);
                    planetsystems.get(values[0]).addPlanet(planet);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return planetsystems;
    }

    private static void skrivTilCSVFil(HashMap<String, PlanetSystem> planetsystems, File filnavn) {
        try (BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(filnavn))) {
            for (PlanetSystem planetsystem : planetsystems.values()) {
                ArrayList<Planet> planets = planetsystem.getPlanets();
                for(Planet p: planets){
                bufretSkriver.write(planetsystem.getName() + "," + planetsystem.getPictureUrl() + "," + planetsystem.getCenterStar().getName() + "," + planetsystem.getCenterStar().getMass() + "," + planetsystem.getCenterStar().getRadius() + "," + planetsystem.getCenterStar().getEffectiveTemperature() + "," + planetsystem.getPictureUrl() + "," + p.getName() + "," + p.getMass()+"," +p.getRadius() + "," + p.getSemiMajorAxis() + "," + p.getEccentricity() + "," + p.getOrbitalPeriod() + "," + p.getPictureUrl());
                    bufretSkriver.newLine();

                }}

    } catch(
    FileNotFoundException fnfe)

    {
        System.out.println(fnfe.getMessage());
    } catch(
    IOException ioexc)

    {
        System.out.println(ioexc.getLocalizedMessage());
    }

}
    private static void skrivTilCSVFil(HashMap<String, PlanetSystem> planetsystems, String filnavn) {
        try (BufferedWriter bufretSkriver = new BufferedWriter(new FileWriter(filnavn))) {
            for (PlanetSystem planetsystem : planetsystems.values()) {
                ArrayList<Planet> planets = planetsystem.getPlanets();
                for(Planet p: planets){
                bufretSkriver.write(planetsystem.getName() + "," + planetsystem.getPictureUrl() + "," + planetsystem.getCenterStar().getName() + "," + planetsystem.getCenterStar().getMass() + "," + planetsystem.getCenterStar().getRadius() + "," + planetsystem.getCenterStar().getEffectiveTemperature() + "," + planetsystem.getPictureUrl() + "," + p.getName() + "," + p.getMass()+"," +p.getRadius() + "," + p.getSemiMajorAxis() + "," + p.getEccentricity() + "," + p.getOrbitalPeriod() + "," + p.getPictureUrl());
                    bufretSkriver.newLine();

                }}

        } catch(
                FileNotFoundException fnfe)

        {
            System.out.println(fnfe.getMessage());
        } catch(
                IOException ioexc)

        {
            System.out.println(ioexc.getLocalizedMessage());
        }

    }

        @Override
    public PlanetSystem getPlanetSystem(String planetSystemName) {
        HashMap<String, PlanetSystem> planetSystems = readCSV("planets_100.CSV");
        for (PlanetSystem planetSystem : planetSystems.values()) {
            if (planetSystem.getName().equals(planetSystemName)) {
                return planetSystem;
            }
        }

        return null;
    }

    @Override
    public HashMap<String, PlanetSystem> getPlanetSystems() {
        return readCSV("planets_100.CSV");
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
    public List<PlanetSystem> newPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl) {
        return null;
    }

    @Override
    public List<PlanetSystem> alterPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl) {
        return null;
    }

    @Override
    public List<PlanetSystem> deletePlanet(String plansys, String navn) {
        return null;
    }
}
/*
    @Override
    public void newPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP, String pictureUrl) {
       HashMap<String, PlanetSystem> planetsystems = readCSV("planets_100.CSV");
        PlanetSystem planetsystem = planetsystems.get(navn);
        Star star= planetsystem.getCenterStar();
        Planet planet = new Planet(navn, new Double(mass), new Double(radius), new Double(SMA), new Double(eccen), new Double(orbitalP), star, pictureUrl);
        planetsystems.get(planetsystem).addPlanet(planet);
        skrivTilCSVFil(planetsystems, "planets_100.CSV");
    }

    @Override
    public void newPlanet(String plansys, String navn, String mass, String radius, String SMA, String eccen, String orbitalP) {
        HashMap<String, PlanetSystem> planetsystems = readCSV("planets_100.CSV");
        PlanetSystem planetsystem = planetsystems.get(plansys);
        Star star= planetsystem.getCenterStar();
        Planet planet = new Planet(navn, new Double(mass), new Double(radius), new Double(SMA), new Double(eccen), new Double(orbitalP), star);
        planetsystems.get(planetsystem).addPlanet(planet);

        skrivTilCSVFil(planetsystems, "planets_100.CSV");
    }

    @Override
    public void alterPlanet(String plansys, String navn, String valueName, String newValue) {
        HashMap<String, PlanetSystem> planetsystems = readCSV("planets_100.CSV");
        PlanetSystem planetsystem = planetsystems.get(plansys);
        Star star= planetsystem.getCenterStar();
        Planet planet = planetsystem.getPlanet(navn);
        switch (valueName){
            case "navn":
                planet.setName(newValue);
                break;
            case "mass":
                planet.setMass(new Double(newValue));
                break;
            case "radius":
                planet.setRadius(new Double(newValue));
                break;
            case "SMA":
                planet.setSemiMajorAxis(new Double(newValue));
                break;
            case "eccen":
                planet.setEccentricity(new Double(newValue));
                break;
            case "orbitalP":
                planet.setOrbitalPeriod(new Double(newValue));
                break;
            case "pictureURL":
                planet.setPictureUrl(newValue);
                break;
        }
      skrivTilCSVFil(planetsystems,"planets_100.CSV");
    }

    public void alterPlanetStar(String plansys, String navn, String valueName, String newValue1, String newValue2, String newValue3, String newValue4, String newValue5) {
        HashMap<String, PlanetSystem> planetsystems = readCSV("planets_100.CSV");
        PlanetSystem planetsystem = planetsystems.get(plansys);
        Star star = planetsystem.getCenterStar();
        Planet planet = planetsystem.getPlanet(navn);
        planet.setCentralCelestialBody(new Star(valueName, new Double(newValue1), new Double(newValue2), new Double(newValue3),newValue4));
        skrivTilCSVFil(planetsystems, "planets_100.CSV");
    }
    @Override
    public void deletePlanet(String plansys, String navn){
            HashMap<String, PlanetSystem> planetsystems = readCSV("planets_100.CSV");
            planetsystems.remove(navn);

           skrivTilCSVFil(planetsystems,"planets_100.CSV");
        }

    }
*/


