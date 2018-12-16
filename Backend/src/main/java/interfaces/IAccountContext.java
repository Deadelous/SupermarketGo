package interfaces;

import Model.Account;

public interface IAccountContext {
    Account authenticate(Account account);
    boolean createAccount(Account account);
    Account updateAccount(Account account);

}
