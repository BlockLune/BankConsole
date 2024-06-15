package top.fishg.controller;

import javax.swing.JOptionPane;

import top.fishg.model.Account;
import top.fishg.view.LoginView;
import top.fishg.view.NavMenuView;
import top.fishg.view.PasswordChangerView;

public class NavMenuController {
  private NavMenuView navMenuView;
  private Account account;

  public NavMenuController(NavMenuView navMenuView, Account account, LoginView loginView) {
    this.navMenuView = navMenuView;
    this.account = account;

    this.navMenuView.getQueryButton().addActionListener(e -> {
      String message = "账号：" + this.account.getUsername() + "\n" + "账户余额：" + this.account.getMoney();
      JOptionPane.showMessageDialog(this.navMenuView, message, "查询结果 | ATM", JOptionPane.INFORMATION_MESSAGE);
    });

    this.navMenuView.getDepositButton().addActionListener(e -> {
      String input = JOptionPane.showInputDialog(this.navMenuView, "请输入存款金额：", "存款 | ATM",
          JOptionPane.QUESTION_MESSAGE);
      if (input != null) {
        try {
          double money = Double.parseDouble(input);
          this.account.deposit(money);
          JOptionPane.showMessageDialog(this.navMenuView, "存款成功！余额：" + this.account.getMoney(), "成功",
              JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this.navMenuView, "请输入正确的金额！存款已取消。", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(this.navMenuView, ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    this.navMenuView.getWithdrawButton().addActionListener(e -> {
      String input = JOptionPane.showInputDialog(this.navMenuView, "请输入取款金额：", "取款 | ATM",
          JOptionPane.QUESTION_MESSAGE);
      if (input != null) {
        try {
          double money = Double.parseDouble(input);
          this.account.withdraw(money);
          JOptionPane.showMessageDialog(this.navMenuView, "取款成功！余额：" + this.account.getMoney(), "成功",
              JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this.navMenuView, "请输入正确的金额！取款已取消。", "错误", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
          JOptionPane.showMessageDialog(this.navMenuView, ex.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
        }
      }
    });

    this.navMenuView.getChangePasswordButton().addActionListener(e -> {
      PasswordChangerView passwordChangerView = new PasswordChangerView();
      new PasswordChangerController(passwordChangerView, account);
      passwordChangerView.setVisible(true);
    });

    this.navMenuView.getLogoutButton().addActionListener(e -> {
      this.navMenuView.dispose();
      loginView.setVisible(true);
    });
  }
}
