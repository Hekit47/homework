package lesson01.tasks;

public class Treadmill {

    int distance;

    public Treadmill(int distance){
        this.distance = distance;
    }

    public int  Distance(){
        return distance;
    }

    public boolean isRunEnough(int run){
        return Distance() >= run;
    }

    public void info(){
        System.out.println("The Treadmill is " + distance + "m high");
    }
}

