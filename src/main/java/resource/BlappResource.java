package resource;

import entity.PersistenceEntity;
import service.DBManager;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("entity")
@Stateless
public class BlappResource {

    @EJB
    private DBManager dbm;

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Response getEntity() {
        List<PersistenceEntity> entities = dbm.getEntities();
        return getEntityResponse(entities);
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @POST
    public Response createService(JsonObject service){
        createEntity(service);
        return Response.status(Response.Status.OK).build();
    }

    @Produces(MediaType.APPLICATION_JSON)
    @DELETE
    public Response deleteEntities() {
        dbm.deleteEntities();
        return Response.status(Response.Status.OK).build();
    }

    public void createEntity(JsonObject payload) {
        PersistenceEntity entity = new PersistenceEntity();
        entity.setPublicKey(payload.getString("publicKey"));
        if (payload.getString("googleMail") == null || payload.getString("googleMail").isEmpty()){
            entity.setGoogleMail("");
        } else {
            entity.setGoogleMail(payload.getString("googleMail"));
        }
        if (payload.getString("facebookMail") == null || payload.getString("facebookMail").isEmpty()){
            entity.setFacebookMail("");
        } else {
            entity.setFacebookMail(payload.getString("facebookMail"));
        }
        if (payload.getString("blAccMail") == null || payload.getString("blAccMail").isEmpty()){
            entity.setBlAccMail("");
        } else {
            entity.setBlAccMail(payload.getString("blAccMail"));
        }
        dbm.persistService(entity);
    }

    public Response getEntityResponse(List<PersistenceEntity> pe){
        if(!pe.isEmpty()){
            return Response.status(Response.Status.OK).entity(pe).build();
        }else {
            return Response.status(Response.Status.OK).entity("No entity found").build();
        }
    }
}