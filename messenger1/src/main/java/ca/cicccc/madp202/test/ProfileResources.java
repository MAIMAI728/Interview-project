package ca.cicccc.madp202.test;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("profiles")
public class ProfileResources {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getProfiles() {
        List<Profile> list = new ArrayList();
        list.add(new Profile("mai", "http://findicons.com/files/icons/909/archigraphs_collection/128/coffee.png"));
        list.add(new Profile("sayaka", "http://icons.iconarchive.com/icons/archigraphs/oldies/128/Coffee-Cup-icon.png"));
        list.add(new Profile("kento", "http://findicons.com/files/icons/799/festive/128/mug.png"));
        list.add(new Profile("yuumi", "http://findicons.com/files/icons/2118/nuvola/128/kteatime.png"));
        list.add(new Profile("bomin", "http://findicons.com/files/icons/909/archigraphs_collection/128/coffee.png"));
        list.add(new Profile("j1", "http://icons.iconarchive.com/icons/archigraphs/oldies/128/Coffee-Cup-icon.png"));
        list.add(new Profile("diego", "http://findicons.com/files/icons/799/festive/128/mug.png"));
        list.add(new Profile("bruno", "http://findicons.com/files/icons/2118/nuvola/128/kteatime.png"));
        list.add(new Profile("gami", "http://findicons.com/files/icons/339/coffee_break/128/sliced_bread.png"));
        return list;
    }
}