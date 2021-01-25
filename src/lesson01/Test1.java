package lesson01;

import lesson01.person.Cat;
import lesson01.person.Human;
import lesson01.person.Robot;

public class Test1 {

    public static void main(String[] args) {
       Human human1 = new Human("Joe",15,1);
       human1.info();
       Robot robot1 = new Robot("Wader", 25,0);
       robot1.info();
       Cat cat1 = new Cat("Viskas", 10, 2);
       cat1.info();




    }

}
