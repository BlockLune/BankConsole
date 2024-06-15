package top.fishg;

import top.fishg.controller.LoginController;
import top.fishg.model.Accounts;
import top.fishg.view.LoginView;

public class BankConsole {
  public static void main(String[] args) {
    LoginView loginView = new LoginView();
    new LoginController(loginView, new Accounts());

    loginView.setVisible(true);
  }
}