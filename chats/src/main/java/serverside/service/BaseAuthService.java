package serverside.service;

import lombok.AllArgsConstructor;
import serverside.interfaces.AuthService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BaseAuthService implements AuthService {
//создадим свой лист с клиентами
    private List<Entry> entryList;

    public BaseAuthService(){
        entryList = new ArrayList<>();
        entryList.add(new Entry("login1", "pass1", "nick1"));
        entryList.add(new Entry("login2", "pass2", "nick2"));
        entryList.add(new Entry("login3", "pass3", "nick3"));


    }


    @Override
    public void start() {
        System.out.println("Authservice start");
    }

    @Override
    public void stop() {
        System.out.println("Authservice stop");
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password){
        for (Entry e:entryList) {
            if(e.login.equals(login) && e.password.equals(password)){
                return e.nick;
            }
        }
        return null;

    }

    @AllArgsConstructor
    private class Entry{
        private String login;
        private String password;
        private String nick;


    }
}
