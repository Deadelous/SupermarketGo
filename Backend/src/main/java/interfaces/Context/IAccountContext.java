package interfaces.Context;

import Model.Account;

public interface IAccountContext {
    Account authenticate(Account account);
    Account createAccount(Account account);
    Account updateAccount(Account account);
    Account getAccount(Account account);

}
