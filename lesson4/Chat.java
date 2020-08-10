package java2.lesson4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Chat extends JFrame {
    private final String version = "Version 0.1";
    private final JTextField textField = new JTextField();

    JPanel jpn = new JPanel(new GridLayout());
    JPanel jps = new JPanel(new GridLayout());

    JTextArea jTextArea = new JTextArea();
    JScrollPane jScrollPane = new JScrollPane(jTextArea);

    JButton button = new JButton("Отправить");


    public Chat() {
        setTitle("Main Window");
        setBounds(500, 500, 500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        jTextArea.setLineWrap(true);
        jTextArea.setEditable(false);

        jpn.add(jScrollPane);
        jps.add(textField);
        jps.add(button);

        textField.addActionListener(this::reactToAction);
        textField.addKeyListener(new CustomKeyListener());

        button.addActionListener(this::reactToAction);

        add(jpn);
        add("South", jps);

        JMenuBar mainMenu = new JMenuBar();
        JMenu mFile = new JMenu("File");
        JMenu mEdit = new JMenu("Edit");
        JMenuItem miFileNew = new JMenuItem("New");
        JMenuItem miFileExit = new JMenuItem("Exit");
        JMenuItem miInfo = new JMenuItem("Info");
        setJMenuBar(mainMenu);
        mainMenu.add(mFile);
        mainMenu.add(mEdit);
        mFile.add(miFileNew);
        mFile.addSeparator();
        mFile.add(miFileExit);
        mEdit.add(miInfo);

        miInfo.addActionListener(e -> JOptionPane.showMessageDialog(null,version));

        miFileExit.addActionListener(e -> System.exit(0));

        setVisible(true);

    }

    private void reactToAction(ActionEvent event) {
        sendMessage();
    }

    private static class CustomKeyListener extends KeyAdapter {
        @Override
        public void keyTyped(KeyEvent e) {

        }
    }

    public void sendMessage() {
        String out = textField.getText();
        jTextArea.append(out + "\n");
        textField.setText("");
        textField.grabFocus();
    }




}
