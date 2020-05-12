import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.Mockito.*;

public class TestMockito {
	UserIface ui;
	UserDao ud;
	
	@Before
	public void setUp() throws Exception{
		ud = new UserDao();
		ui = mock(UserIface.class);
		ud.setUserIface(ui);
	}
	
	@Test
	public void testGetUserInfo(){
		User u = new User();
		u.id = 2;
		u.name = "ÕÅÈý";
		u.pwd = "abc";
		when(ui.getUserFromDB(anyInt())).thenReturn(u);
		
		User u1 = ud.getUserInfo(2);
		
		assertEquals(u1.id, 1);
		assertEquals(u1.name, "sxz");
		assertEquals(u1.pwd, "SF1916054");
	}
	
	@Test
	public void testFetchUserInfo(){
		when(ui.getUserFromDB(anyInt())).thenReturn(null);
		
		User u = ud.getUserInfo(1);
		
		assertEquals(u.id, 1);
		assertEquals(u.name, "sxz");
		assertEquals(u.pwd, "SF1916054");
	}
}
