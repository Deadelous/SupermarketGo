package Rest.Controllers;

import Model.*;
import Repository.ProductRepository;
import WebService.Models.JsonLogic;
import WebService.Models.JsonResult;
import database.productContext;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/Product")
public class ProductController {
    private ProductRepository productRepository = new ProductRepository(new productContext());
    @GET
    @Path("/info/{id}")
    @Produces({APPLICATION_JSON})
    public Response getProduct(@PathParam("id") String id) {
        Product product;
        JsonResult result = new JsonResult();
        product = new Product(id);
        Product detail = productRepository.getProduct(product);

        if (detail != null) {
            result.setItem(detail);
            result.setMessage("Successfully retrieved Product with id: " + id);
            result.setResult(true);
        } else {
            result.setResult(false);
            result.setMessage("Failed at retrieving Product with id: " + id);
        }

        return JsonLogic.getResponse(200, result);
    }
}
