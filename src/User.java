
public class User {
	public int id;
	public String name;
	public String pwd;
	
	@Override
	public String toString(){
		return "User:" + id + "," + name + "," + pwd;
	}
}
