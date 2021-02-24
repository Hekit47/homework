package serverside.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    private boolean isAuthorized;
    private boolean isClientActive;
    private String name;
    private long time;



    public ClientHandler(MyServer myServer, Socket socket) {
        try {
            this.myServer = myServer;
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            this.name = "";

            new Thread(() -> {
                try {
                    authentication();
                    readMessage();
                } catch (IOException ignored){
                } finally {
                    closeConnection();
                }
            }).start();

            //добавим таймер по аутентификации. если пользователь не подключился через 2 минуты после открытия окна, то разрываем сессию
            new Thread(() -> {
                try {
                    Thread.sleep(120000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (!isAuthorized) {
                    closeConnection();
                }
            }
            ).start();

        } catch (IOException e){
            throw new RuntimeException("Problem with ClientHandler");
        }
    }


    public void authentication() throws IOException {
        while (true) {
            String str = dis.readUTF();
            if (str.startsWith("/auth")) { //  /auth login password
                String [] arr = str.split("\\s");
                String nick = myServer
                        .getAuthService()
                        .getNickByLoginAndPassword(arr[1], arr[2]);
                if (nick != null) {
                    if (!myServer.isNickBusy(nick)) {
                        isAuthorized = true;
                        sendMessage("/authok " + nick);
                        name = nick;
                        myServer.broadCastMessage("Hello " + name);
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMessage("Nick is busy");
                    }
                } else {
                    sendMessage("Wrong login and password");
                }
            } else {
                sendMessage("Your command will be need start with /auth");
            }
        }
    }

    public void readMessage() throws IOException {

        while (!isClientActive) {
            time = System.currentTimeMillis();
            String messageFromClient = dis.readUTF();
            if(System.currentTimeMillis()<= time + 10000){ //добавил проверку условия, что клиент пишет сообщения не реже, чем каждые 3 минуты
                System.out.println(name + " send message " + messageFromClient);//вместо систем.аут может быть какая-то другая логика
                if (messageFromClient.trim().startsWith("/")) {

                    if (messageFromClient.startsWith("/w")) {
                        //добавил try catch, т.к. при неверной комманде у пользователя закрывалась сессия
                        try {
                            String [] arr = messageFromClient.split(" ", 3);
                            myServer.sendMessageToCertainClient(this, arr[1], name + ": " + arr[2]);
                        }catch (ArrayIndexOutOfBoundsException ignored){
                            sendMessage("Wrong command. Repeat please!");
                        }
                    }

                    if (messageFromClient.trim().startsWith("/list")) {
                        myServer.getOnlineUsersList(this);
                    }

                    if (messageFromClient.trim().startsWith("/end")) {
                        return;
                    }
                } else {
                    myServer.broadCastMessage(name + ": " + messageFromClient);
                }} else {isClientActive = true;}

            }
        sendMessage("Вы отключены, т.к. были неактивны.Перезайдите в чат!");
        closeConnection();
        }



    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    public void closeConnection() {
        myServer.broadCastMessage(name + " Leave chat");
        myServer.unsubscribe(this);
        try {
            dis.close();
            dos.close();
            socket.close();
        }catch (IOException ignored){
        }

//        try {
//            dos.close();
//        }catch (IOException ignored){
//        }
//
//        try {
//            socket.close();
//        }catch (IOException ignored){
//        }
    }

    public String getName(){
        return name;
    }

}
