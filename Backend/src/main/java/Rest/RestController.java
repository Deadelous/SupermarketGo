package Rest;


import WebService.Models.JsonLogic;
import WebService.Models.JsonResult;
import database.profileContext;
import Model.Profile;
import Repository.*;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;


import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
@Path("/Profile")
public class RestController {
    private ProfileRepository profileRepository = new ProfileRepository(new profileContext());
    @GET
    @Path("/info/{id}")
    @Produces({APPLICATION_JSON})
    public Response getProfile(@PathParam("id") String id) {
       Profile profile;
       JsonResult result = new JsonResult();
       profile = new Profile(id);
       Profile detail = profileRepository.getProfile(profile);

        if (detail != null) {
            result.setItem(detail);
            result.setMessage("Successfully retrieved Profile with id: " + id);
            result.setResult(true);
        } else {
            result.setResult(false);
            result.setMessage("Failed at retrieving Profile with id: " + id);
        }

        return JsonLogic.getResponse(200, result);
    }

}
