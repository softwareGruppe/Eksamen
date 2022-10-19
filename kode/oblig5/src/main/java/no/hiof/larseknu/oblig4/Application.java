package no.hiof.larseknu.oblig4;

import io.javalin.Javalin;
import io.javalin.plugin.rendering.vue.VueComponent;
import no.hiof.larseknu.oblig4.controller.PlanetController;
import no.hiof.larseknu.oblig4.controller.PlanetSystemController;
//import no.hiof.larseknu.oblig4.repository.UniverseCSVrepository;
import no.hiof.larseknu.oblig4.repository.universeJSONrepository;


import java.util.Set;

public class Application {

    public static void main(String[] args) {
        Javalin app = Javalin.create().start(7001);

        app.config.enableWebjars();

        app.before("/", ctx -> ctx.redirect("/planet-systems"));

        universeJSONrepository universeRepository = new universeJSONrepository();
        PlanetSystemController planetSystemController = new PlanetSystemController(universeRepository);
        PlanetController planetController = new PlanetController(universeRepository);

        app.get("/planet-systems", new VueComponent("planet-system-overview"));
        app.get("/planet-systems/:planet-system-id", new VueComponent("planet-system-detail"));
        app.get("/planet-systems/:planet-system-id/createplanet", new VueComponent("planet-create"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id", new VueComponent("planet-detail"));
        app.get("/planet-systems/:planet-system-id/planets/:planet-id/update", new VueComponent("planet-update"));


        app.get("api/planet-systems", planetSystemController::getAllPlanetSystems);
        app.get("api/planet-systems/:planet-system-id", planetSystemController::getPlanetSystem);
        app.post("api/planet-systems/:planet-system-id/createplanet", planetSystemController::newPlanet);
        app.get("/api/planet-systems/:planet-system-id/planets", planetController::getPlanets);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id", planetController::getPlanet);
        app.get("/api/planet-systems/:planet-system-id/planets/:planet-id/delete", planetSystemController::deletePlanet);
        app.post("/api/planet-systems/:planet-system-id/planets/:planet-id/update", planetSystemController::alterPlanet);
    }
}
