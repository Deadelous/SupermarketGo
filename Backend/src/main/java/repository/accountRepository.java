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
    public profile getProfile(profile profile) {
        return context.getProfile(profile);
    }

    @Override
    public profile updateProfile(profile profile) {
        return context.updateProfile(profile);
    }
}
