package ch18_io.sec10_object_io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception{

		String filename = "C:/Workspace/Java/lesson/src/ch18_io/sec10_object_io/product.ser";
		
		// 파일에 클래스 자료 넣기
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
		product p1 = new product("노트북", 1500000);
		product p2 = new product("모니터", 200000);
		product p3 = new product("마우스", 100000);
		
		oos.writeObject(p1);
		oos.writeObject(p2);
		oos.writeObject(p3);
		
		oos.flush();
		oos.close();
		
		// 파일에 있는 클래스 자료 불러오기
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
		product p = (product) ois.readObject();
		System.out.println(p);
		p = (product) ois.readObject();
		System.out.println(p);
		p = (product) ois.readObject();
		System.out.println(p);
		
		
		// 리스트로 읽기
		ObjectOutputStream ols = new ObjectOutputStream(new FileOutputStream(filename));
		List<product> list = new ArrayList<product>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		ols.flush();
		ols.close();
		
		List<product> inlist = (List<product>) ois.readObject();
		inlist.forEach(x -> System.out.println(x));
		ois.close();
	}

}
