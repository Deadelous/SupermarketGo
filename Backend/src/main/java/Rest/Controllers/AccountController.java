package Rest.Controllers;

import Model.Account;
import Repository.AccountRepository;
import WebService.Models.JsonLogic;
import WebService.Models.JsonResult;
import database.accountContext;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/Account")
public class AccountController {

    private HttpServletResponse servletResponse;

    private void allowCrossDomainAccess() {
        if (servletResponse != null){
            servletResponse.setHeader("Access-Control-Allow-Origin", "*");
        }
    }

    private AccountRepository accountRepository = new AccountRepository(new accountContext());

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/register")
    public Response register(String json) {
        allowCrossDomainAccess();
        Account account = (Account) JsonLogic.getObject(Account.class, json);
        JsonResult result = new JsonResult();
        if (account != null) {
            if (accountRepository.createAccount(account) != null) {
                result.setItem(account);
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/login")
    public Response login(String json) {
        Account account;
        JsonResult jsonResult = new JsonResult();

        account = (Account) JsonLogic.getObject(Account.class, json);
        Account loggedIn = null;

        if (account != null) {
            loggedIn = accountRepository.authenticate(account);
        }

            if ((loggedIn != null)) {
                jsonResult.setResult(true);
                jsonResult.setMessage("Successfully logged in");
                jsonResult.setItem(loggedIn);
                System.out.println("Account is successfully logged in for account:" + " " + account);

            } else {
                jsonResult.setResult(false);
                jsonResult.setMessage("Failed at logging in");
            }
        return JsonLogic.getResponse(200, jsonResult);

    }

    @GET
    @Path("/profile/info/{id}")
    @Produces({APPLICATION_JSON})
    public Response getAccount(@PathParam("id") String id) {
        Account profile;
        JsonResult result = new JsonResult();
        profile = new Account(id);
        Account detail = accountRepository.getAccount(profile);

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
