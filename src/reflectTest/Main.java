package reflectTest;

import java.util.Random;

public class Main {

public static void main(String[] args) throws Exception
{
    doRegular();
    doReflection();
}

public static void doRegular() throws Exception
{
    long start = System.currentTimeMillis();
    for (int i=0; i<1000000; i++)
    {
    	Random a = new Random();
        a.hashCode();
    }
    System.out.println(System.currentTimeMillis() - start);
}

public static void doReflection() throws Exception
{
    long start = System.currentTimeMillis();
    for (int i=0; i<1000000; i++)
    {
    	Random a = (Random) Class.forName("java.util.Random").newInstance();
        a.hashCode();
    }
    System.out.println(System.currentTimeMillis() - start);
}
}