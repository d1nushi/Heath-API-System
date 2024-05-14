/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.MedicalRecordDAO;
import model.MedicalRecord;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/medical-records")
public class MedicalRecordResource {
    private final MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    private static final Logger logger = LoggerFactory.getLogger(MedicalRecordResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllMedicalRecords() {
        try {
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getAllMedicalRecords();
            logger.info("Retrieved all Medical Records");
            return Response.ok(medicalRecords).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all medical records", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordById(@PathParam("id") int id) {
        try {
            MedicalRecord medicalRecord = medicalRecordDAO.getMedicalRecordById(id);
            if (medicalRecord != null) {
                logger.info("Medical Record retrieved with ID: " + id);
                return Response.ok(medicalRecord).build();
            } else {
                logger.info("Medical Record with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching medical record with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMedicalRecord(MedicalRecord medicalRecord) {
        try {
            medicalRecordDAO.addMedicalRecord(medicalRecord);
            logger.info("Medical Record added successfully");
            return Response.status(Response.Status.CREATED).entity("Medical record added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding medical record", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMedicalRecord(@PathParam("id") int id, MedicalRecord updatedMedicalRecord) {
        try {
            MedicalRecord medicalRecordToUpdate = medicalRecordDAO.getMedicalRecordById(id);
            if (medicalRecordToUpdate != null) {
                updatedMedicalRecord.setId(id);
                medicalRecordDAO.updateMedicalRecord(updatedMedicalRecord);
                logger.info("Medical Record updated successfully");
                return Response.ok().entity("Medical record updated successfully").build();
            } else {
                logger.info("Medical Record with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while updating medical record with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteMedicalRecord(@PathParam("id") int id) {
        try {
            MedicalRecord medicalRecordToDelete = medicalRecordDAO.getMedicalRecordById(id);
            if (medicalRecordToDelete != null) {
                medicalRecordDAO.deleteMedicalRecord(id);
                logger.info("Medical Record deleted successfully");
                return Response.ok().entity("Medical record deleted successfully").build();
            } else {
                logger.info("Medical Record with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Medical record not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while deleting medical record with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}