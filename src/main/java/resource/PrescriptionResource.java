/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.PrescriptionDAO;
import model.Prescription;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/prescriptions")
public class PrescriptionResource {
    private final PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    private static final Logger logger = LoggerFactory.getLogger(PrescriptionResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            logger.info("Retrieved all Prescriptions");
            return Response.ok(prescriptions).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all prescriptions", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionById(@PathParam("id") int id) {
        try {
            Prescription prescription = prescriptionDAO.getPrescriptionById(id);
            if (prescription != null) {
                logger.info("Prescription retrieved with ID: " + id);
                return Response.ok(prescription).build();
            } else {
                logger.info("Prescription with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching prescription with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPrescription(Prescription prescription) {
        try {
            prescriptionDAO.addPrescription(prescription);
            logger.info("Prescription added successfully");
            return Response.status(Response.Status.CREATED).entity("Prescription added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding prescription", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("id") int id, Prescription updatedPrescription) {
        try {
            Prescription prescriptionToUpdate = prescriptionDAO.getPrescriptionById(id);
            if (prescriptionToUpdate != null) {
                updatedPrescription.setId(id);
                prescriptionDAO.updatePrescription(updatedPrescription);
                logger.info("Prescription updated successfully");
                return Response.ok().entity("Prescription updated successfully").build();
            } else {
                logger.info("Prescription with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while updating prescription with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletePrescription(@PathParam("id") int id) {
        try {
            Prescription prescriptionToDelete = prescriptionDAO.getPrescriptionById(id);
            if (prescriptionToDelete != null) {
                prescriptionDAO.deletePrescription(id);
                logger.info("Prescription deleted successfully");
                return Response.ok().entity("Prescription deleted successfully").build();
            } else {
                logger.info("Prescription with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Prescription not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while deleting prescription with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}
