package lesson01.tasks;

public class Wall {
    int height;

    public Wall(int height){

        this.height = height;
    }

    public int Height(){
        return height;
    }

    public boolean isJumpEnough(int jump){
        return jump >= height;
    }

    public void info(){
        System.out.println("The Wall is " + height + "m high");
    }







}
