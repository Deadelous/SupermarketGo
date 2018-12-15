package interfaces;

import model.account;
import model.profile;

public interface IAccountContext {
    account authenticate(account account);
    account createAccount(account account);
    account updateAccount(account account);

}
