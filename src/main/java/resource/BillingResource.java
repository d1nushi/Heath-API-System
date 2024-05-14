/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package resource;

/**
 *
 * @author Dinushi
 */
import dao.BillingDAO;
import model.Billing;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Path("/billings")
public class BillingResource {
    private final BillingDAO billingDAO = new BillingDAO();
    private static final Logger logger = LoggerFactory.getLogger(BillingResource.class);

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBillings() {
        try {
            List<Billing> billings = billingDAO.getAllBillings();
            logger.info("Retrieved all Billings");
            return Response.ok(billings).build();
        } catch (Exception ex) {
            logger.error("Error occurred while fetching all billings", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillingById(@PathParam("id") int id) {
        try {
            Billing billing = billingDAO.getBillingById(id);
            if (billing != null) {
                logger.info("Billing retrieved with ID: " + id);
                return Response.ok(billing).build();
            } else {
                logger.info("Billing with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Billing not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while fetching billing with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addBilling(Billing billing) {
        try {
            billingDAO.addBilling(billing);
            logger.info("Billing added successfully");
            return Response.status(Response.Status.CREATED).entity("Billing added successfully").build();
        } catch (Exception ex) {
            logger.error("Error occurred while adding billing", ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("id") int id, Billing updatedBilling) {
        try {
            Billing billingToUpdate = billingDAO.getBillingById(id);
            if (billingToUpdate != null) {
                updatedBilling.setId(id);
                billingDAO.updateBilling(updatedBilling);
                logger.info("Billing updated successfully");
                return Response.ok().entity("Billing updated successfully").build();
            } else {
                logger.info("Billing with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Billing not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while updating billing with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }

    @DELETE
    @Path("/{id}")
   public Response deleteBilling(@PathParam("id") int id) {
        try {
            Billing billingToDelete = billingDAO.getBillingById(id);
            if (billingToDelete != null) {
                billingDAO.deleteBilling(id);
                logger.info("Billing deleted successfully");
                return Response.ok().entity("Billing deleted successfully").build();
            } else {
                logger.info("Billing with ID not found: " + id);
                return Response.status(Response.Status.NOT_FOUND).entity("Billing not found").build();
            }
        } catch (Exception ex) {
            logger.error("Error occurred while deleting billing with ID: " + id, ex);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                           .entity("Internal server error occurred").build();
        }
    }
}