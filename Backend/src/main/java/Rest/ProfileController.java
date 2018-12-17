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
public class ProfileController {
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


    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/Create")
    public Response createProfile(String json) {
        Profile profile = (Profile) JsonLogic.getObject(Profile.class, json);
        JsonResult result = new JsonResult();
        if (profile != null) {
            if (profileRepository.createProfile(profile) != null) {
                result.setItem(profile);
                result.setResult(true);
                result.setMessage("Profile created");
            } else {
                result.setResult(false);
                result.setMessage("Profile is not created");
            }
        } else {
            result.setMessage("You have sent no valid json. We received: '" + json + "'");
            result.setResult(false);
        }
        return JsonLogic.getResponse(200, result);
    }
}
