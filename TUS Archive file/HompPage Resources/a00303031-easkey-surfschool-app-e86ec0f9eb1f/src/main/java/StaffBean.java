import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class StaffBean {
	private String name;
	
	public String getName()
	{
		return name;
	}
	
	public void getName(String n)
	{
		name = n;
	}
	
	private String numLessons;
	
	public String getNumLessons()
	{
		return name;
	}
	
	public void getNumLessons(String n)
	{
		numLessons = n;
	}
	
	public void inputGuestData()
	{
		GuestData g = new GuestData();
		g.name = getName();
		g.lessons = getNumLessons();
		GuestData.data.add(g);
	}
}
