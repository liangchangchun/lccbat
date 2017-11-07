package netty.c;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -6287159832561165279L;
	private String name;
	private String age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}
