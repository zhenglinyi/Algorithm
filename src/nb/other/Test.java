package nb.other;

public class Test {
}

class Singleton{
    private static Singleton singleton;
    private Singleton(){

    }
    public static Singleton getInstance(){
        if(singleton==null)
            singleton=new Singleton();
        return singleton;

    }
}

class Singleton2{
    private static Singleton2 singleton2=new Singleton2();
    private Singleton2(){

    }
    public static Singleton2 getInstace(){
        return singleton2;
    }
}

class Singleton3{
    private volatile static Singleton3 singleton3;
    private Singleton3(){

    }
    public static Singleton3 getInstance(){
        if(singleton3==null){
            synchronized (Singleton3.class){
                if(singleton3==null){
                    singleton3=new Singleton3();
                }
            }
        }
        return singleton3;
    }
}
