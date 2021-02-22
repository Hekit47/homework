package serverside.service;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    private MyServer myServer;
    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;

    private String name;



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

        } catch (IOException e){
            throw new RuntimeException("Problem with ClientHandler");
        }
    }


    private void authentication() throws IOException {
        //сюда можно добавить счетчик неправильных попыток ввода пароля и логина
        int count = 0; // добавил счетчик
        while (count != 3) {
            String str = dis.readUTF();
            if (str.startsWith("/auth")) { // /auth
                String[] arr = str.split("\\s");
                String nick = myServer
                        .getAuthService()
                        .getNickByLoginAndPassword(arr[1], arr[2]);
                if(nick != null){
                    if(myServer.isNickBusy(nick)){
                        sendMessage("/authok " + nick);
                        name = nick;
                        myServer.broadCastMessage("Hello " + name);
                        myServer.subscribe(this);
                        return;
                    } else {
                        sendMessage("Nick is busy");
                    }
                }
            } else {
                sendMessage("Wrong login or password");
                count++;
            }
        }
    }



    public void readMessage() throws IOException {
        //ждем сообщение от клиента, пока не напишет. можно вставить таймер, чтобы отключить клиента, если он молчит
        while(true){
            String messageFromClient = dis.readUTF();
            System.out.println(name + " sent message " + messageFromClient); //вместо систем.аут может быть какая-то другая логика
            if(messageFromClient.equals("/end")){

                return;
            }
            myServer.broadCastMessage(name + ": " + messageFromClient);
        }
    }

    public void sendMessage(String message) {
        try {
            dos.writeUTF(message);
        } catch (IOException ignored) {
            ignored.printStackTrace();
        }
    }

    public void closeConnection() {
        myServer.unsubscribe(this);
        myServer.broadCastMessage(name + " Leave chat");
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

}
