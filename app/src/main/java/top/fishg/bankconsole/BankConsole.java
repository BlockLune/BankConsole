package top.fishg.bankconsole;

import top.fishg.bankconsole.controller.LoginController;
import top.fishg.bankconsole.model.Accounts;
import top.fishg.bankconsole.view.LoginView;

public class BankConsole {
  public static void main(String[] args) {
    LoginView loginView = new LoginView();
    Accounts accounts = new Accounts();
    new LoginController(loginView, accounts);

    loginView.setVisible(true);
  }
}