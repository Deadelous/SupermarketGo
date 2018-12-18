package Rest.Controllers;

import Model.Account;
import Model.Guest;
import Repository.AccountRepository;
import Rest.RestHelper;
import WebService.Models.JsonLogic;
import WebService.Models.JsonResult;
import database.accountContext;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/Account")
public class AccountController {
    private AccountRepository accountRepository = new AccountRepository(new accountContext());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response register(Account account) {
        if(account == null)
        {
            return Response.status(400).entity(RestHelper.getErrorResponseString()).build();
        }

        boolean success = accountRepository.createAccount(account);

        return  Response.status(200).entity(RestHelper.getSuccessResponse(success)).build();
    }



    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(String json) {
        Account account;
        JsonResult jsonResult = new JsonResult();

        account = (Account) JsonLogic.getObject(Account.class, json);
        if (account != null) {
            Account loggedIn = accountRepository.authenticate(account);

            if ((loggedIn != null)) {
                jsonResult.setResult(true);
                jsonResult.setMessage("Successfully logged in");
                jsonResult.setItem(loggedIn);

            } else {
                jsonResult.setResult(false);
                jsonResult.setMessage("Failed at logging in");
            }
        } else {
            jsonResult.setMessage("You have sent no valid json. We received: '" + json + "'");
            jsonResult.setResult(false);
        }
        return JsonLogic.getResponse(200, jsonResult);
    }
}
