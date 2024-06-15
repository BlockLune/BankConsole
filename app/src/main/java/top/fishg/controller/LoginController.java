package top.fishg.controller;

import javax.swing.JOptionPane;

import top.fishg.model.Account;
import top.fishg.model.Accounts;
import top.fishg.view.LoginView;
import top.fishg.view.NavMenuView;

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
        NavMenuView navMenuView = new NavMenuView();
        Account account = accounts.getIfExists(username);
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
