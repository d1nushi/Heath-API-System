 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.PatientDAO;
import model.Patient;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/patients")
public class PatientResource {
    private final PatientDAO patientDAO = new PatientDAO();
    private static final Logger logger = LoggerFactory.getLogger(PatientResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPatients() {
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            logger.info("Retrieved all patients");
            return Response.ok(patients).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all patients", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("id") int id) {
        try {
            Patient patient = patientDAO.getPatientById(id);
            if (patient != null) {
                logger.info("Patient retrieved with ID: " + id);
                return Response.ok(patient).build();
            } else {
                logger.info("Patient with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching patient with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
        try {
            patientDAO.addPatient(patient);
            logger.info("Patient added successfully");
            return Response.status(Response.Status.CREATED).entity("Patient added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding patient", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("id") int id, Patient updatedPatient) {
        try {
            Patient patientToUpdate = patientDAO.getPatientById(id);
            if (patientToUpdate != null) {
                updatedPatient.setId(id);
                patientDAO.updatePatient(updatedPatient);
                logger.info("Patient updated successfully");
                return Response.ok().entity("Patient updated successfully").build();
            } else {
                logger.info("Patient with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while updating patient with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePatient(@PathParam("id") int id) {
        try {
            Patient patientToDelete = patientDAO.getPatientById(id);
            if (patientToDelete != null) {
                patientDAO.deletePatient(id);
                logger.info("Patient deleted successfully");
                return Response.ok().entity("Patient deleted successfully").build();
            } else {
                logger.info("Patient with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Patient not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while deleting patient with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}