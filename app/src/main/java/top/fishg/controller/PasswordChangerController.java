package top.fishg.controller;

import top.fishg.model.Account;
import top.fishg.view.PasswordChangerView;

import javax.swing.JOptionPane;

public class PasswordChangerController {
  public PasswordChangerView passwordChangerView;
  public Account account;

  public PasswordChangerController(
      PasswordChangerView passwordChangerView, Account account) {
    this.passwordChangerView = passwordChangerView;
    this.account = account;

    this.passwordChangerView.getConfirmButton().addActionListener(e -> {
      var oldPassword = new String(
          this.passwordChangerView
              .getOldPasswordField()
              .getPassword());
      var oldPasswordExpected = account.getPassword();
      if (!oldPassword.equals(oldPasswordExpected)) {
        JOptionPane.showMessageDialog(
            this.passwordChangerView, "旧密码错误！操作已取消。", "错误", JOptionPane.ERROR_MESSAGE);
      } else {
        var newPassword = new String(
            this.passwordChangerView
                .getNewPasswordField()
                .getPassword());
        var newPasswordForConfirm = new String(
            this.passwordChangerView
                .getNewPasswordForConfirmField()
                .getPassword());
        if (!newPassword.equals(newPasswordForConfirm)) {
          JOptionPane.showMessageDialog(
              this.passwordChangerView, "两次输入的新密码不一致！操作已取消。", "错误", JOptionPane.ERROR_MESSAGE);
        } else {
          try {
            account.changePassword(newPassword);
            JOptionPane.showMessageDialog(
                this.passwordChangerView, "密码修改成功！", "成功", JOptionPane.INFORMATION_MESSAGE);
            this.passwordChangerView.dispose();
          } catch (Exception exception) {
            JOptionPane.showMessageDialog(
                this.passwordChangerView, exception.getMessage(), "错误", JOptionPane.ERROR_MESSAGE);
          }
        }
      }
      this.passwordChangerView.dispose();
    });

    this.passwordChangerView.getCancelButton().addActionListener(e -> {
      this.passwordChangerView.dispose();
    });
  }
}
