/*
 * Created by JFormDesigner on Mon Aug 17 15:53:46 CST 2020
 */

package com.lxl.qq.ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.*;

import com.alibaba.fastjson.JSONObject;
import com.lxl.qq.service.login.LoginService;
import com.lxl.qq.utils.NetUtils;
import com.lxl.qq.vo.Account;
import com.lxl.qq.vo.ProcessResult;
import net.miginfocom.swing.*;

/**
 * @author unknown
 */
public class LoginUI extends JFrame {
    public LoginUI() {
        initComponents();
    }

    public static void main(String[] args) {
        LoginUI loginUI = new LoginUI();
        loginUI.setVisible(true);
    }

    LoginService loginService = new LoginService();

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        contentPanel2 = new JPanel();
        label4 = new JLabel();
        label5 = new JLabel();
        username = new JTextField();
        password = new JTextField();

        //======== this ========
        setTitle("\u767b\u5f55");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setLayout(new BorderLayout());

            //======== buttonBar ========
            {
                buttonBar.setLayout(new MigLayout(
                    "insets dialog,alignx right",
                    // columns
                    "[button,fill]" +
                    "[button,fill]",
                    // rows
                    null));

                //---- okButton ----
                okButton.setText("\u767b\u5f55");
                buttonBar.add(okButton, "cell 0 0");

                //---- cancelButton ----
                cancelButton.setText("\u53d6\u6d88");
                buttonBar.add(cancelButton, "cell 1 0");
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== contentPanel2 ========
            {
                contentPanel2.setLayout(null);

                //---- label4 ----
                label4.setText("\u7528\u6237\u540d");
                contentPanel2.add(label4);
                label4.setBounds(70, 70, 75, 32);

                //---- label5 ----
                label5.setText("\u5bc6\u7801");
                contentPanel2.add(label5);
                label5.setBounds(70, 115, 75, 32);
                contentPanel2.add(username);
                username.setBounds(175, 70, 145, username.getPreferredSize().height);
                contentPanel2.add(password);
                password.setBounds(175, 115, 145, password.getPreferredSize().height);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel2.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel2.setMinimumSize(preferredSize);
                    contentPanel2.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel2, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loginService.loginOut(username.getText().trim());
            }
        });
        this.okButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ObjectOutputStream out = null;
                BufferedReader in = null;
                try {
                    String usernameText = username.getText().trim();
                    String passwordText = password.getText().trim();
                    Account account = new Account();
                    account.setUserName(usernameText);
                    account.setPassWord(passwordText);
                    String send = NetUtils.send("http://172.16.40.163:8082/chat/login", (JSONObject) JSONObject.toJSON(account), "UTF-8");
                    System.out.println("url 访问结果：" + send);
                    // 处理响应
                    ProcessResult processResult = JSONObject.parseObject(send, ProcessResult.class);
                    // 提示
                    JOptionPane.showMessageDialog(null, processResult.getFlag(), processResult.getMsg(),JOptionPane.INFORMATION_MESSAGE);

                } catch (Exception e1) {
                    System.out.println("发送 POST 请求出现异常！" + e1);
                    e1.printStackTrace();
                }
                //使用finally块来关闭输出流、输入流
                finally {
                    try {
                        if (out != null) {
                            out.close();
                        }
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel contentPanel2;
    private JLabel label4;
    private JLabel label5;
    private JTextField username;
    private JTextField password;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
