package cn.nice123.order.server;

import org.springframework.beans.BeanUtils;

public class AppTest {

	public static void h(String[] args) {
		//A a = new A(1, "lzx");
		B b1 = new B(2, "lisa", null);
		B b = new B(2, "lisa", "guangzhou");
		System.out.println(b);
		//BeanUtils.copyProperties(a, b); System.out.println(b);

		b = converter(b1, b);
		
		System.out.println(b);
	}

	static <T> T converter(Object poObj, Class<T> voClass) {

		T voObj = null;
		try {
			voObj = voClass.newInstance();
			BeanUtils.copyProperties(poObj, voObj);
		} catch (InstantiationException | IllegalAccessException e) {

			e.printStackTrace();
		}
		return voObj;
	}
	static <T> T converter(Object poObj, T  t) {
		BeanUtils.copyProperties(poObj, t);
		return t;
	}
}

class A {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "A [id=" + id + ", name=" + name + "]";
	}

	public A(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

}

class B {
	private int id;
	private String name;
	private String address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "B [id=" + id + ", name=" + name + ", address=" + address + "]";
	}

	public B(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}

	public B() {
	}
	

}