package Rest;

import Model.Account;
import Model.Guest;
import Repository.AccountRepository;
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
}
