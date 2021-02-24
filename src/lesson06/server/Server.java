package lesson06.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8082)) {
            System.out.println("Server start");
            socket = serverSocket.accept();
            System.out.println("Client join");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            Thread t1 = new Thread(() ->{
                while (true) {
                    String message = null;
                    try {
                        message = dis.readUTF();
                        if (message.equalsIgnoreCase("/finish")) {
                            dos.writeUTF(message);
                            break;
                        }
                        dos.writeUTF("Client message: " + message);
                        System.out.println("Client message: " + message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            Thread t2 = new Thread(() ->{
                while (true) {
                    String serverMessage = null;
                    try {
                        Scanner scanner = new Scanner(System.in);
                        serverMessage = scanner.next();
                        if (serverMessage.equalsIgnoreCase("/finish")) {
                            dos.writeUTF(serverMessage);
                            break;
                        }
                        dos.writeUTF("Server: " + serverMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
t1.start();
t2.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}