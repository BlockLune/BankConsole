package top.fishg;

import top.fishg.controller.LoginController;
import top.fishg.model.Accounts;
import top.fishg.view.LoginView;

public class BankConsole {
  public static void main(String[] args) {
    LoginView loginView = new LoginView();
    Accounts accounts = new Accounts();
    new LoginController(loginView, accounts);

    loginView.setVisible(true);
  }
}