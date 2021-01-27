package lesson01.person;

public class Human {
    String name;
    int runAbility;
    int jumpAbility;

   public Human (String name, int runAbility, int jumpAbility){
        this.name = name;
        this.runAbility = runAbility;
        this.jumpAbility = jumpAbility;

    }

    public int checkRun(){
       return runAbility;
    }

    public String Name(){
       return name;
    }

    public int checkJump(){
       return jumpAbility;
    }

    public void info() {
        System.out.print(name + " can run " + runAbility + "m");
        System.out.println(" and can jump " + jumpAbility + "m");
    }
    }
