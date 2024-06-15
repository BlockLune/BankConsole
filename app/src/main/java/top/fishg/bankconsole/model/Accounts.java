package top.fishg.bankconsole.model;

import java.util.ArrayList;

public class Accounts {
  private final ArrayList<Account> accounts;

  public Accounts() {
    accounts = new ArrayList<>();

    DatabaseHandler dbHandler = new DatabaseHandler();
    dbHandler.query("SELECT * FROM people", resultSet -> {
      while (resultSet.next()) {
        String usernameInTable = resultSet.getString("username");
        String passwordInTable = resultSet.getString("password");
        String roleInTable = resultSet.getString("role");
        int balanceInTable = resultSet.getInt("balance");
        accounts.add(new Account(usernameInTable, passwordInTable, roleInTable, balanceInTable));
      }
    });

  }

  public Account[] getAccounts() {
    return accounts.toArray(new Account[0]);
  }

  public ArrayList<Account> getAccountsList() {
    return new ArrayList<Account>(accounts); // defensive copy
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
