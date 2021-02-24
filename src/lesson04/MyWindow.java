package lesson04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {

    public MyWindow(){
        setTitle("Client chat");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,500,405);
        setResizable(false);

        // создаем лэйауты
        BorderLayout jbl = new BorderLayout();
        FlowLayout flowLayout = new FlowLayout();

        //создаем панели, где будем размещать элементы
        JPanel jp1 = new JPanel();
        JPanel jp2 = new JPanel();

        //работаем с первой панелью jp1
        jp1.setBackground(Color.WHITE);
        JTextArea ta = new JTextArea(20,43);
        ta.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(ta,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jp1.setLayout(flowLayout);
        jp1.add(scrollPane);

        //работаем со второй панелью jp2
        jp2.setBackground(Color.GRAY);
        JTextField tf = new JTextField(36);
        JButton jb1 = new JButton("Send");
        jp2.add(tf, flowLayout);
        jp2.add(jb1, flowLayout);

        //добавляем обработку событий
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText(tf.getText());
                System.out.println("Message sent via ENTER: " + ta.getText());
            }
        });

        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ta.setText(tf.getText());
                System.out.println("Message sent via button: " + ta.getText());
            }
        });

        //размещаем панели на фрейме
        add(jp1, jbl.CENTER);
        add(jp2, jbl.SOUTH);
        setVisible(true);

    }
}
