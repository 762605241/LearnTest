/*
 * Created by JFormDesigner on Tue Aug 18 14:42:25 CST 2020
 */

package com.lxl.qq.ui;

import com.alibaba.fastjson.JSONObject;
import com.lxl.qq.utils.NetUtils;
import com.lxl.qq.vo.Account;
import com.lxl.qq.vo.MessageVO;
import com.lxl.qq.vo.ProcessResult;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author 762605241
 */
public class ChatUI extends JFrame {
    public ChatUI() {
        initComponents();
    }

    private Account account;

    public ChatUI(Account account) {
        this.account = account;
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        buttonBar = new JPanel();
        okButton = new JButton();
        destAccountText = new JTextField();
        scrollPane1 = new JScrollPane();
        msgAreaText = new JTextArea();
        msgArea = new JTextArea();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(null);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < contentPanel.getComponentCount(); i++) {
                        Rectangle bounds = contentPanel.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = contentPanel.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    contentPanel.setMinimumSize(preferredSize);
                    contentPanel.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(null);

                //---- okButton ----
                okButton.setText("OK");
                buttonBar.add(okButton);
                okButton.setBounds(649, 12, 80, okButton.getPreferredSize().height);
                buttonBar.add(destAccountText);
                destAccountText.setBounds(0, 5, 185, 45);

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(msgAreaText);
                }
                buttonBar.add(scrollPane1);
                scrollPane1.setBounds(185, 5, 460, 40);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < buttonBar.getComponentCount(); i++) {
                        Rectangle bounds = buttonBar.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = buttonBar.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    buttonBar.setMinimumSize(preferredSize);
                    buttonBar.setPreferredSize(preferredSize);
                }
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.SOUTH);
        contentPane.add(msgArea, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String destAccount = destAccountText.getText().trim();
                        String msg = msgArea.getText().trim();
                        MessageVO messageVO = new MessageVO(destAccount, msg);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(msgArea.getText()).append("\n").append(account.getUserName()).append(":").append(msg);
                        msgArea.setText(stringBuilder.toString());
                        String send = null;
                        try {
                            send = NetUtils.send("http://172.16.40.163:8082/chat/chat", (JSONObject) JSONObject.toJSON(messageVO), "UTF-8");
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                        System.out.println("url 访问结果：" + send);
                        // 处理响应
                        ProcessResult processResult = JSONObject.parseObject(send, ProcessResult.class);
                        System.out.println(processResult);
                    }
                }).start();
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel buttonBar;
    private JButton okButton;
    private JTextField destAccountText;
    private JScrollPane scrollPane1;
    private JTextArea msgAreaText;
    private JTextArea msgArea;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
