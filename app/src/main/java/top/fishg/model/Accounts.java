package top.fishg.model;

public class Accounts {
  private final Account[] accounts = {
      new Account("888888", "123456", 50000.00)
  };

  public Accounts() {
  }

  public Account[] getAccounts() {
    return accounts;
  }

  public Account getIfExists(String username) {
    for (Account account : accounts) {
      if (account.getUsername().equals(username)) {
        return account;
      }
    }
    return null;
  }

  public String getPasswordIfExists(String username) {
    Account account = getIfExists(username);
    if (account != null) {
      return account.getPassword();
    }
    return null;
  }
}
