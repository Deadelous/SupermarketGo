package Repository;

import interfaces.IAccountContext;
import Model.Account;

public class AccountRepository implements IAccountContext {
    IAccountContext context;

    public AccountRepository() {
    }

    public AccountRepository(IAccountContext context){
          this.context = context;
    }

    @Override
    public Account authenticate(Account account) {
        return context.authenticate(account);
    }

    @Override
    public boolean createAccount(Account account) {
        return context.createAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return context.updateAccount(account);
    }

}
