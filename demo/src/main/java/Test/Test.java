package Test;

public class Test {
    public static void main(String[] args) {
        Object obj = new Object();
        ClassLoader classLoader = obj.getClass().getClassLoader();
        Class<?>[] interfaces = obj.getClass().getInterfaces();
    }
    
    
}
