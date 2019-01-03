package facade;

import Repository.*;
import interfaces.Context.IAccountContext;
import interfaces.Context.IProductContext;
import interfaces.Context.IProfileContext;


public class supermarkefacade {
    IAccountContext accountContext;
    IProfileContext profileContext;
    IProductContext productContext;

    public supermarkefacade() {
        this.accountContext = new AccountRepository();
        this.profileContext = new ProfileRepository();
        this.productContext = new ProductRepository();
    }
}
