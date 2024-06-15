package top.fishg.bankconsole.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridLayout;

public class PasswordChangerView extends JFrame {
  private JPasswordField oldPasswordField = new JPasswordField(20);
  private JPasswordField newPasswordField = new JPasswordField(20);
  private JPasswordField newPasswordForConfirmField = new JPasswordField(20);
  private JButton confirmButton = new JButton("确认");
  private JButton cancelButton = new JButton("取消");

  public PasswordChangerView() {
    JLabel oldPasswordLabel = new JLabel("旧密码：");
    JLabel newPasswordLabel = new JLabel("新密码：");
    JLabel newPasswordForConfirmLabel = new JLabel("确认新密码：");

    JPanel passwordGroupPanel = new JPanel(new GridLayout(3, 2));
    passwordGroupPanel.add(oldPasswordLabel);
    passwordGroupPanel.add(oldPasswordField);
    passwordGroupPanel.add(newPasswordLabel);
    passwordGroupPanel.add(newPasswordField);
    passwordGroupPanel.add(newPasswordForConfirmLabel);
    passwordGroupPanel.add(newPasswordForConfirmField);

    JPanel buttonGroupPanel = new JPanel();
    buttonGroupPanel.add(this.cancelButton);
    buttonGroupPanel.add(this.confirmButton);

    setTitle("改密 | ATM");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(2, 1));
    add(passwordGroupPanel);
    add(buttonGroupPanel);
    setSize(400, 300);
    setLocationRelativeTo(null);
    setResizable(false);
    pack();
  }

  public JPasswordField getOldPasswordField() {
    return this.oldPasswordField;
  }

  public JPasswordField getNewPasswordField() {
    return this.newPasswordField;
  }

  public JPasswordField getNewPasswordForConfirmField() {
    return this.newPasswordForConfirmField;
  }

  public JButton getConfirmButton() {
    return this.confirmButton;
  }

  public JButton getCancelButton() {
    return this.cancelButton;
  }
}
