package top.fishg.bankconsole.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class NavMenuView extends JFrame {
  private JButton queryButton = new JButton("查询");
  private JButton depositButton = new JButton("存钱");
  private JButton withdrawButton = new JButton("取钱");
  private JButton changePasswordButton = new JButton("改密");
  private JButton logoutButton = new JButton("登出");

  public NavMenuView() {
    JPanel titlePanel = new JPanel();
    JLabel title = new JLabel("业务选择");
    titlePanel.add(title);

    JPanel buttonGroupPanel = new JPanel(new GridLayout(5, 1));
    buttonGroupPanel.add(this.queryButton);
    buttonGroupPanel.add(this.depositButton);
    buttonGroupPanel.add(this.withdrawButton);
    buttonGroupPanel.add(this.changePasswordButton);
    buttonGroupPanel.add(this.logoutButton);

    setTitle("登录 | ATM");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new GridLayout(2, 1));

    add(titlePanel);
    add(buttonGroupPanel);

    setSize(400, 300);
    setLocationRelativeTo(null);
    setResizable(false);
  }

  public JButton getQueryButton() {
    return this.queryButton;
  }

  public JButton getDepositButton() {
    return this.depositButton;
  }

  public JButton getWithdrawButton() {
    return this.withdrawButton;
  }

  public JButton getChangePasswordButton() {
    return this.changePasswordButton;
  }

  public JButton getLogoutButton() {
    return this.logoutButton;
  }
}
