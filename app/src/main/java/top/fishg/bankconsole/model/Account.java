package top.fishg.bankconsole.model;

enum UserRole {
  ADMINISTRATOR,
  EMPLOYEE,
  CUSTOMER
}

public class Account {
  private String username;
  private String password;
  private UserRole role;
  private int balance;
  private final DatabaseHandler dbHandler;

  public Account(String username, String password, String role, int balance) throws Exception {
    dbHandler = new DatabaseHandler();

    if (username == null)
      throw new NullPointerException();
    if (password == null)
      throw new NullPointerException();
    this.username = username;
    this.password = password;
    this.role = UserRole.valueOf(role.toUpperCase());
    this.balance = balance;
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public String getRole() {
    return this.role.toString();
  }

  public int getBalance() {
    return this.balance;
  }

  public void updateThis() throws Exception {
    String sql = "SELECT * FROM people WHERE username = '" + this.username + "'";
    dbHandler.query(sql, rs -> {
      if (rs.getFetchSize() != 1) {
        throw new Exception("非法条目");
      }
      while (rs.next()) {
        this.password = rs.getString("password");
        this.role = UserRole.valueOf(rs.getString("role").toUpperCase());
        this.balance = rs.getInt("balance");
      }
    });
  }

  public void updateDatabase() throws Exception {
    String sql = "UPDATE people SET password = ?, balance = ? WHERE username = ?";
    dbHandler.update(sql, this.password, this.balance, this.username);
  }

  public void withdraw(int money) throws Exception {
    if (money > this.balance) {
      throw new Exception("余额不足");
    }
    if (money < 0) {
      throw new Exception("不能取出负数");
    }
    if (money % 100 != 0) {
      throw new Exception("取款金额必须是 100 的整数倍");
    }
    if (money > 5000) {
      throw new Exception("单次取款不能超过 5000 元");
    }
    this.balance -= money;
    updateDatabase();
  }

  public void deposit(int money) throws Exception {
    if (money < 0) {
      throw new Exception("不能存入负数");
    }
    this.balance += money;
    updateDatabase();
  }

  public void changePassword(String newPassword) throws Exception {
    if (newPassword.equals(this.password)) {
      throw new Exception("原密码和新密码不能一样");
    } else {
      if (newPassword.equals("")) {
        throw new Exception("密码不能为空");
      }
    }
    password = newPassword;
    updateDatabase();
  }
}
