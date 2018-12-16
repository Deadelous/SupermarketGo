package facade;

import interfaces.*;
import Repository.*;


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
