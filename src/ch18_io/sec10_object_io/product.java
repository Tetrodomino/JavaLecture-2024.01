package ch18_io.sec10_object_io;

import java.io.Serializable;

public class product implements Serializable {

	/**
	 * Serializable I/F를 구현해야 직렬화가 가능해서, 파일에 읽고 쓰기가 가능해짐
	 */
	private static final long serialVersionUID = -6686111444844609321L;
	private String name;
	private int price;
	
	public product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "product [name=" + name + ", price=" + price + "]";
	}
}
