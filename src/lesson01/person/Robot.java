package lesson01.person;

public class Robot {
    private String name;
     int runAbility;
     int jumpAbility;

    public Robot (String name, int runAbility, int jumpAbility){
        this.name = name;
        this.runAbility = runAbility;
        this.jumpAbility = jumpAbility;
    }

    public void info(){
        System.out.println(name + " can run " + runAbility + "m");
        System.out.println(name + " can jump " + jumpAbility + "m");
    }
}
