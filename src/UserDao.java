
public class UserDao {
	
	private UserIface ui;
	
	public User getUserInfo(int id){
		
		User u = null;
		if(ui != null){
			
			u = ui.getUserFromDB(id);
		}
		if(u == null){
			u = fetchUserInfo(id);
		}
		return u;
	}

	private User fetchUserInfo(int id) {
		// TODO Auto-generated method stub
		User u = new User();
		u.id = 1;
		u.name = "sxz";
		u.pwd = "SF1916054";
		return u;
	}
	
	public void setUserIface(UserIface ui){
		ui = this.ui;
	}
}
