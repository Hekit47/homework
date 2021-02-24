package serverside.service;


import lombok.Getter;
import serverside.interfaces.AuthService;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

//сервисная часть сервера
public class MyServer {
    private final int PORT = 8081;

    private List<ClientHandler> clients;
    @Getter
    private AuthService authService;

   public MyServer(){

       try (ServerSocket server = new ServerSocket(PORT)){

           authService = new BaseAuthService();
           authService.start();

           clients = new ArrayList<>();

           while (true){
               System.out.println("Ожидание подключения...");
               Socket socket = server.accept();
               System.out.println("Client joined");
               new ClientHandler(this, socket);
           }

       } catch (IOException e){
           System.out.println("Server just fucked up");
       } finally{
           if(authService != null){
               authService.stop();
           }
       }
   }
//рассылка сообщений
   public synchronized void broadCastMessage(String message){
       for (ClientHandler c: clients) {
           c.sendMessage(message);
       }
   }
//отправка личных сообщений
    public synchronized void sendMessageToCertainClient(ClientHandler from, String toName, String message) {
        for (ClientHandler c : clients) {
            if (c.getName().equals(toName)) {
                c.sendMessage(message);
                from.sendMessage(message);
            }
        }
    }
//список подключенных пользователей
    public synchronized void getOnlineUsersList(ClientHandler clientHandler) {
        StringBuilder sb = new StringBuilder("");
        for (ClientHandler c : clients) {
            if (!c.equals(clientHandler)) {
                sb.append(c.getName()).append(", ");
            }
        }
        int size = sb.length();
        sb.deleteCharAt(size - 1);
        sb.deleteCharAt(size - 2);
        clientHandler.sendMessage(sb.toString());
    }
//подписка на сообщения
   public synchronized void subscribe(ClientHandler client){
       clients.add(client);
   }

//отписка от сообщений
   public synchronized void unsubscribe(ClientHandler client){
       clients.remove(client);
   }


    public boolean isNickBusy(String nick) {
        for (ClientHandler c:clients) {
            if(c.getName().equals(nick)){
                return true;
            }
        }return false;
    }


}
