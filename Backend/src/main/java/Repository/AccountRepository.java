package Repository;

import interfaces.Context.IAccountContext;
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
    public Account createAccount(Account account) {
        return context.createAccount(account);
    }

    @Override
    public Account updateAccount(Account account) {
        return context.updateAccount(account);
    }

    @Override
    public Account getAccount(Account account) {
        return context.getAccount(account);
    }

}
