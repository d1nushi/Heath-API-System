/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.AppointmentDAO;
import model.Appointment;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/appointments")
public class AppointmentResource {
    private final AppointmentDAO appointmentDAO = new AppointmentDAO();
    private static final Logger logger = LoggerFactory.getLogger(AppointmentResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllAppointments() {
        try {
            List<Appointment> appointments = appointmentDAO.getAllAppointments();
            logger.info("Retrieved all Appointments");
            return Response.ok(appointments).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all appointments", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentById(@PathParam("id") int id) {
        try {
            Appointment appointment = appointmentDAO.getAppointmentById(id);
            if (appointment != null) {
                logger.info("Appointment retrieved with ID: " + id);
                return Response.ok(appointment).build();
            } else {
                logger.info("Appointment with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching appointment with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAppointment(Appointment appointment) {
        try {
            appointmentDAO.addAppointment(appointment);
            logger.info("Appointment added successfully");
            return Response.status(Response.Status.CREATED).entity("Appointment added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding appointment", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateAppointment(@PathParam("id") int id, Appointment updatedAppointment) {
        try {
            Appointment appointmentToUpdate = appointmentDAO.getAppointmentById(id);
            if (appointmentToUpdate != null) {
                updatedAppointment.setId(id);
                appointmentDAO.updateAppointment(updatedAppointment);
                logger.info("Appointment updated successfully");
                return Response.ok().entity("Appointment updated successfully").build();
            } else {
                logger.info("Appointment with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while updating appointment with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAppointment(@PathParam("id") int id) {
        try {
            Appointment appointmentToDelete = appointmentDAO.getAppointmentById(id);
            if (appointmentToDelete != null) {
                appointmentDAO.deleteAppointment(id);
                logger.info("Appointment deleted successfully");
                return Response.ok().entity("Appointment deleted successfully").build();
            } else {
                logger.info("Appointment with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Appointment not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while deleting appointment with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}