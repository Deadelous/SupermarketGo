package Rest.Controllers;

import Model.*;
import Repository.ProductRepository;
import WebService.Models.JsonLogic;
import WebService.Models.JsonResult;
import database.productContext;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/Product")
public class ProductController {
    private ProductRepository productRepository = new ProductRepository(new productContext());
    @GET
    @Path("/info/{id}")
    @Produces({APPLICATION_JSON})
    public Response getProduct(@PathParam("id") int id) {
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

    @GET
    @Path("all")
    @Produces({APPLICATION_JSON})
    public Response getAll() {
        List<Product> productList = productRepository.getAllProducts();

        JsonResult result = new JsonResult();
        result.setItem(productList);
        result.setMessage("Successfully retrieved all products");
        result.setResult(true);
        return JsonLogic.getResponse(200, result);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addProduct")
    public Response addProduct(String json) {
        Product product = (Product) JsonLogic.getObject(Product.class, json);
        JsonResult result = new JsonResult();
        if (product != null) {
            if (productRepository.addProduct(product)!= null ) {
                result.setItem(product);
                result.setResult(true);
                result.setMessage("Account created");
            } else {
                result.setResult(false);
                result.setMessage("Account is not created");
            }
        } else {
            result.setMessage("You have sent no valid json. We received: '" + json + "'");
            result.setResult(false);
        }
        return JsonLogic.getResponse(200, result);

    }
}
