/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.PersonDAO;
import model.Person;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Path("/persons")
public class PersonResource {
    private final PersonDAO personDAO = new PersonDAO();
    private static final Logger logger = LoggerFactory.getLogger(PersonResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        try {
            List<Person> persons = personDAO.getAllPersons();
            logger.info("Retrieved all Persons");
            return Response.ok(persons).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all persons", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonById(@PathParam("id") int id) {
        try {
            Person person = personDAO.getPersonById(id);
            if (person != null) {
                return Response.ok(person).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("Person not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching person with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(Person person) {
        try {
            personDAO.addPerson(person);
            logger.info("Person added successfully");
            return Response.status(Response.Status.CREATED).entity("Person added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding person", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePerson(@PathParam("id") int id, Person updatedPerson) {
        try {
            updatedPerson.setId(id);
            personDAO.updatePerson(updatedPerson);
            logger.info("Person updated successfully");
            return Response.ok().entity("Person updated successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while updating person with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
    @DELETE
    @Path("/{id}")
    public Response deletePerson(@PathParam("id") int id) {
        try {
            personDAO.deletePerson(id);
            logger.info("Person deleted successfully");
            return Response.ok().entity("Person deleted successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while deleting person with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}