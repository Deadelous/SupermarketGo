package repository;

import interfaces.IAccountContext;
import model.account;
import model.profile;

public class accountRepository implements IAccountContext {
    IAccountContext context;

    public  accountRepository(IAccountContext context){
          this.context = context;
    }

    @Override
    public account authenticate(account account) {
        return context.authenticate(account);
    }

    @Override
    public account createAccount(account account) {
        return context.createAccount(account);
    }

    @Override
    public account updateAccount(account account) {
        return context.updateAccount(account);
    }

}
