package lesson01;

import lesson01.person.Human;
import lesson01.tasks.Wall;
import lesson01.tasks.Treadmill;

public abstract class AppRun implements Runnable {

    public static void main(String[] args)  {
//       Human human1 = new Human("Joe",15,2);
//        Wall wall1 = new Wall(3);
//        Treadmill treadmill1 = new Treadmill(15);
//       human1.info();
//       wall1.info();
//
//       treadmill1.info();
//        System.out.println();

//        Human[] team = {
//          new Human("Frank", 11, 1),
//          new Human("Bob", 8, 0),
//          new Human("Nick", 15,2)
//        };
//        for (int i = 0; i < team.length; i++) {
//            team[i].info();
//        }

//AppService appService = new AppService();
//appService.competitionWithObstacles();

new Thread(new Runnable() {
    @Override
    public void run() {
        System.out.println(1);
    }
});
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(2);
            }
        }).start();

    }

}


