package org.minglesi;

import jakarta.validation.Valid;
import jakarta.validation.groups.ConvertGroup;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.minglesi.db.dao.HeroDao;
import org.minglesi.db.dao.HeroDaoImpl;
import org.minglesi.db.dao.ProfessionDao;
import org.minglesi.db.dao.ProfessionDaoImpl;
import org.minglesi.db.model.Hero;
import org.minglesi.db.model.Profession;
import org.minglesi.validation.groups.CreateHero;
import org.minglesi.validation.groups.CreateProfession;
import org.minglesi.validation.groups.UpdateHero;

import java.util.List;

@Path("/")
public class Controller {
    private HeroDao heroDao;
    private ProfessionDao professionDao;

    public Controller() {
        heroDao = new HeroDaoImpl();
        professionDao = new ProfessionDaoImpl();
    }

    @POST
    @Path("/hero")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addHero(@Valid @ConvertGroup(to = CreateHero.class) Hero hero) {
        heroDao.insert(hero);
        return Response.ok().build();
    }

    @GET
    @Path("/hero/{hero_id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHero(@PathParam("hero_id") int heroId) {
        Hero hero = heroDao.read(heroId);
        if (hero == null){
            return Response.status(404).build();
        }
        return Response.ok(hero).build();
    }

    @POST
    @Path("/hero/{hero_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateHero(@Valid @ConvertGroup(to = UpdateHero.class) Hero hero, @PathParam("hero_id") Long heroId) {
        hero.setId(heroId);
        heroDao.update(hero);
        return Response.ok().build();
    }

    @GET
    @Path("/hero/{hero_id}/delete")
    public Response deleteHero(@PathParam("hero_id") int heroId) {
        heroDao.delete(heroId);
        return Response.ok().build();
    }

    @GET
    @Path("/heroes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHeroes() {
        List<Hero> heroes = heroDao.readAll();
        return Response.ok(heroes).build();
    }

    @GET
    @Path("/heroes/delete")
    public Response deleteAllHeroes() {
        heroDao.deleteAll();
        return Response.ok().build();
    }

    @POST
    @Path("/profession")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProfession(@Valid @ConvertGroup(to = CreateProfession.class) Profession profession) {
        professionDao.insert(profession);
        return Response.ok().entity(profession).build();
    }

    @GET
    @Path("/professions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProfessions() {
        List<Profession> professions = professionDao.readAll();
        return Response.ok(professions).build();
    }
}
