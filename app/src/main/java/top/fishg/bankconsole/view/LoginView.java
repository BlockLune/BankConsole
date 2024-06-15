package top.fishg.bankconsole.view;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;

public class LoginView extends JFrame {
  private JButton loginButton = new JButton("登录");
  private JButton exitButton = new JButton("退出");
  private JTextField usernameField = new JTextField(20);
  private JPasswordField passwordField = new JPasswordField(20);

  private JPanel getWelcomePanel() {
    JPanel panel = new JPanel();
    JLabel label = new JLabel("欢迎使用 ATM 柜员机系统！");
    panel.add(label);
    return panel;
  }

  private JPanel getUsernameInputPanel() {
    JPanel panel = new JPanel();

    JLabel label = new JLabel("卡号：");
    JTextField textField = this.usernameField;

    panel.add(label);
    panel.add(textField);

    return panel;
  }

  private JPanel getPasswordInputPanel() {
    JPanel panel = new JPanel();

    JLabel label = new JLabel("密码：");
    JPasswordField passwordField = this.passwordField;

    panel.add(label);
    panel.add(passwordField);

    return panel;
  }

  private JPanel getButtonGroupPanel() {
    JPanel panel = new JPanel();

    JButton loginButton = this.loginButton;
    JButton exitButton = this.exitButton;

    panel.add(loginButton);
    panel.add(exitButton);

    return panel;
  }

  public LoginView() {
    setTitle("登录 | ATM");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridLayout(4, 1));
    add(getWelcomePanel());
    add(getUsernameInputPanel());
    add(getPasswordInputPanel());
    add(getButtonGroupPanel());

    setSize(400, 300);
    setLocationRelativeTo(null);
    setResizable(false);

    pack();
  }

  public JTextField getUsernameField() {
    return this.usernameField;
  }

  public JPasswordField getPasswordField() {
    return this.passwordField;
  }

  public JButton getLoginButton() {
    return this.loginButton;
  }

  public JButton getExitButton() {
    return this.exitButton;
  }
}
