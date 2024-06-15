package top.fishg.model;

public class Account {
  private String username;
  private String password;
  private int storedMoney;

  public Account(String username, String password, double money) {
    if (username == null)
      throw new NullPointerException();
    if (password == null)
      throw new NullPointerException();
    this.username = username;
    this.password = password;
    this.storedMoney = (int) (money * 100); // 100.00 is stored as 10000
  }

  public String getUsername() {
    return this.username;
  }

  public String getPassword() {
    return this.password;
  }

  public double getMoney() {
    return (double) (this.storedMoney / 100);
  }

  public void withdraw(double money) throws Exception {
    if (money > this.storedMoney) {
      throw new Exception("余额不足");
    }
    if (money < 0) {
      throw new Exception("不能取出负数");
    }
    if ((int) money % 100 != 0) {
      throw new Exception("取款金额必须是 100 的整数倍");
    }
    if (money > 5000 * 100) {
      throw new Exception("单次取款不能超过 5000 元");
    }
    this.storedMoney -= (int) (money * 100);
  }

  public void deposit(double money) throws Exception {
    if (money < 0) {
      throw new Exception("不能存入负数");
    }
    this.storedMoney += (int) (money * 100);
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
  }
}
