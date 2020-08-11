package bean;

public class employee {
	private int id;	
	private String name;
	private String age;
	private String address;
	private String passwd;
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	
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

	public  String  getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "employee [id="+id+",name=" + name +",password="+passwd+ ",age=" + age + ",address=" + address + "]";
	}
	
	

}
