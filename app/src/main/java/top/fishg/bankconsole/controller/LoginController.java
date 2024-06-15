package top.fishg.bankconsole.controller;

import javax.swing.JOptionPane;

import top.fishg.bankconsole.model.Account;
import top.fishg.bankconsole.model.Accounts;
import top.fishg.bankconsole.view.LoginView;
import top.fishg.bankconsole.view.NavMenuView;

public class LoginController {
  public LoginView loginView;
  public Accounts accounts;

  public LoginController(LoginView loginView, Accounts accounts) {
    this.loginView = loginView;
    this.accounts = accounts;

    this.loginView.getLoginButton().addActionListener(e -> {
      var username = this.loginView.getUsernameField().getText();
      var password = new String(
          this.loginView.getPasswordField().getPassword());
      var passwordExpected = accounts.getPasswordIfExists(username);

      if (passwordExpected == null || !passwordExpected.equals(password)) {
        JOptionPane.showMessageDialog(
            this.loginView, "卡号或密码不正确！");
        this.loginView.getUsernameField().setText("");
        this.loginView.getPasswordField().setText("");
        this.loginView.getUsernameField().requestFocus();
      } else {
        JOptionPane.showMessageDialog(this.loginView, "登录成功！");
        Account account = accounts.getIfExists(username);
        NavMenuView navMenuView = new NavMenuView(
            account.getRole().toString().equals(Account.UserRole.ADMINISTRATOR.toString()));
        new NavMenuController(navMenuView, account, this.loginView);
        navMenuView.setVisible(true);
        this.loginView.dispose();
      }
    });

    this.loginView.getExitButton().addActionListener(e -> {
      System.exit(0);
    });
  }
}
