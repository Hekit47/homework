package lesson01.person;

public class Robot {
    String name;
    int runAbility;
    int jumpAbility;

    public Robot (String name, int runAbility, int jumpAbility){
        this.name = name;
        this.runAbility = runAbility;
        this.jumpAbility = jumpAbility;
    }

    public int checkRun(){
        return runAbility;
    }

    public int checkJump(){
        return jumpAbility;
    }

    public String name(){
        return name;
    }

    public void info(){
        System.out.println(name + " can run " + runAbility + "m");
        System.out.println(name + " can jump " + jumpAbility + "m");
    }
}
