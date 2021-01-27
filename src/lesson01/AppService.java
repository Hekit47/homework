package lesson01;

import lesson01.person.Cat;
import lesson01.person.Human;
import lesson01.person.Robot;
import lesson01.tasks.Treadmill;
import lesson01.tasks.Wall;

public class AppService {

        private Robot robot;
        private Human human;
        private Cat cat;
        private Wall wall;
        private Treadmill treadmill;

    Object[] team ={
            new Human("Bob",10,1),
            new Robot("Vader",7,3),
            new Cat("Viskas", 10,2),
    };

    Object[] obstacles = {
            new Treadmill(10),
            new Wall(2),
            new Treadmill(15),
    };

    public void competitionWithObstacles (){
        for (int i = 0; i < team.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if(team[i] instanceof Cat){
                    cat = (Cat)team[i];
                    if(obstacles[j] instanceof Wall) {
                        wall = ((Wall) obstacles[j]);
                        if (cat.checkJump() >= wall.Height()) {
                            System.out.println("Cat " + ((Cat) team[i]).name() + " jumped" + wall.Height() + "m");
                        } else {
                            System.out.println("Cat " + ((Cat) team[i]).name() + " dropped, when tried to jump over the wall" + wall.Height() + "m");
                            break;
                        }
                    }
                        else if(obstacles[j] instanceof Treadmill){
                            treadmill = (Treadmill)obstacles[j];
                            if(cat.checkRun() >= treadmill.Distance()){
                                System.out.println("Cat " +  ((Cat) team[i]).name() + " ran " + treadmill.Distance() + "m");
                            } else {
                                System.out.println("Cat " +  ((Cat) team[i]).name() + " dropped, when tried to run the treadmill " + treadmill.Distance() + "m");
                                break;
                            }
                        }
                } else if(team[i] instanceof Human){
                    human = (Human)team[i];
                    if(obstacles[j] instanceof Wall) {
                        wall = ((Wall) obstacles[j]);
                        if (human.checkJump() >= wall.Height()) {
                            System.out.println("Human " + ((Human) team[i]).Name() + " jumped " + wall.Height() + "m");
                        } else {
                            System.out.println("Human " + ((Human) team[i]).Name() + " dropped, when tried to jump over the wall " + wall.Height() + "m");
                            break;
                        }
                    }
                    else if(obstacles[j] instanceof Treadmill){
                        treadmill = (Treadmill)obstacles[j];
                        if(human.checkRun() >= treadmill.Distance()){
                            System.out.println("Human " + ((Human) team[i]).Name() + " ran " + treadmill.Distance() + "m");
                        } else {
                            System.out.println("Human " + ((Human) team[i]).Name() + " dropped, when tried to run the treadmill " + treadmill.Distance() + "m");
                            break;
                        }
                    }
                }else if(team[i] instanceof Robot){
                    robot = (Robot)team[i];
                    if(obstacles[j] instanceof Wall) {
                        wall = ((Wall) obstacles[j]);
                        if (robot.checkJump() >= wall.Height()) {
                            System.out.println("Robot " + robot.name() + " jumped " + wall.Height() + "m");
                        } else {
                            System.out.println("Robot " + robot.name() + " dropped, when tried to jump over the wall " + wall.Height() + "m");
                            break;
                        }
                    }
                    else if(obstacles[j] instanceof Treadmill){
                        treadmill = (Treadmill)obstacles[j];
                        if(robot.checkRun() >= treadmill.Distance()){
                            System.out.println("Robot " + robot.name() + " ran " + treadmill.Distance() + "m");
                        } else {
                            System.out.println("Robot " + robot.name() + " dropped, when tried to run the treadmill " + treadmill.Distance() + "m");
                            break;
                        }
                    }
                }
            }
        }
        
    }



}
