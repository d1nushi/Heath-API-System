/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.DoctorDAO;
import model.Doctor;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/doctors")
public class DoctorResource {
    private final DoctorDAO doctorDAO = new DoctorDAO();
    private static final Logger logger = LoggerFactory.getLogger(DoctorResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            logger.info("Retrieved all doctors");
            return Response.ok(doctors).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all doctors", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("id") int id) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(id);
            if (doctor != null) {
                logger.info("Doctor retrieved with ID: " + id);
                return Response.ok(doctor).build();
            } else {
                logger.info("Doctor with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching doctor with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDoctor(Doctor doctor) {
        try {
            doctorDAO.addDoctor(doctor);
            logger.info("Doctor added successfully");
            return Response.status(Response.Status.CREATED).entity("Doctor added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding doctor", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("id") int id, Doctor updatedDoctor) {
        try {
            Doctor doctorToUpdate = doctorDAO.getDoctorById(id);
            if (doctorToUpdate != null) {
                updatedDoctor.setId(id);
                doctorDAO.updateDoctor(updatedDoctor);
                logger.info("Doctor updated successfully");
                return Response.ok().entity("Doctor updated successfully").build();
            } else {
                logger.info("Doctor with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while updating doctor with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteDoctor(@PathParam("id") int id) {
        try {
            Doctor doctorToDelete = doctorDAO.getDoctorById(id);
            if (doctorToDelete != null) {
                doctorDAO.deleteDoctor(id);
                logger.info("Doctor deleted successfully");
                return Response.ok().entity("Doctor deleted successfully").build();
            } else {
                logger.info("Doctor with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Doctor not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while deleting doctor with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}