package lesson06.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient extends JFrame {

    private final Integer SERVER_PORT = 8082;
    private final String SERVER_ADDRESS = "localhost";
    private Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    private JTextField msgInputField;
    private JTextArea chatArea;

    public EchoClient() {
        try {
            connection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        prepareGUI();
    }

    public void connection () throws IOException {
        socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        //открываем новый поток, чтобы не мешало работе окна
        new Thread(() -> {

            try {
                while (true) {
                    String message = dis.readUTF();
                    if (message.equalsIgnoreCase("/finish")) {
                        this.dispose();
                        break;
                    }
                    chatArea.append(message + "\n");
                }
            } catch (IOException ignored){
            }

        }).start();
    }

    public void send() {
        //проверка, чтобы не отправлялось пустое сообщение
        if (msgInputField.getText() != null && !msgInputField.getText().trim().isEmpty()) {
            try {
                dos.writeUTF(msgInputField.getText());
                //chatArea.append(msgInputField.getText() + "\n");
                msgInputField.setText("");
            } catch (IOException ignored) {
            }
        }
    }


    public void prepareGUI() {

        setBounds(600, 300, 500, 500);
        setTitle("Клиент");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setLineWrap(true);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);


        JPanel bottomPanel = new JPanel(new BorderLayout());
        JButton btnSendMsg = new JButton("Отправить");
        bottomPanel.add(btnSendMsg, BorderLayout.EAST);
        msgInputField = new JTextField();
        add(bottomPanel, BorderLayout.SOUTH);
        bottomPanel.add(msgInputField, BorderLayout.CENTER);

        btnSendMsg.addActionListener(e -> {
            send();
        });

        msgInputField.addActionListener(e -> {
            send();
        });

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);

            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EchoClient();
        });
    }
}