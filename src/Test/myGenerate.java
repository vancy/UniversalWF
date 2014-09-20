package Test;
import java.io.*;

public class myGenerate extends Object{
	
	public static void main (String[] args) {
		// TODO Auto-generated method stub
		try {
			pj.PyjamaToJavaParser.parse(new File("src/Test/myTest.pj"));
			pj.PyjamaToJavaParser.parse(new File("src/Test/Atom.pj"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Finished tag");

	}

}
