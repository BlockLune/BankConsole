package top.fishg.bankconsole.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

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

    JPanel passwordGroupPanel = new JPanel(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);
    gbc.anchor = GridBagConstraints.WEST;

    addFormItem(passwordGroupPanel, gbc, oldPasswordLabel, oldPasswordField, 0);
    addFormItem(passwordGroupPanel, gbc, newPasswordLabel, newPasswordField, 1);
    addFormItem(passwordGroupPanel, gbc, newPasswordForConfirmLabel, newPasswordForConfirmField, 2);

    JPanel buttonGroupPanel = new JPanel();
    buttonGroupPanel.add(this.cancelButton);
    buttonGroupPanel.add(this.confirmButton);

    setTitle("改密 | ATM");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(passwordGroupPanel, BorderLayout.CENTER);
    add(buttonGroupPanel, BorderLayout.SOUTH);
    setSize(400, 300);
    setLocationRelativeTo(null);
    setResizable(false);
    pack();
  }

  private void addFormItem(JPanel panel, GridBagConstraints gbc, JLabel label, JPasswordField textField, int row) {
    gbc.gridx = 0;
    gbc.gridy = row;
    panel.add(label, gbc);

    gbc.gridx = 1;
    gbc.gridy = row;
    panel.add(textField, gbc);
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
