package manager;

public class BeanOfManager
{
	@Override
	public String toString() {
		return "BeanOfManager [branch=" + branch + ", username=" + username + ", password=" + password
				+ ", dateOfJoining=" + dateOfJoining + ", dateOfBirth=" + dateOfBirth + ", salary=" + salary + "]";
	}
	private String branch;
	private String username;
	private long password;
	private String dateOfJoining;
	private String dateOfBirth;
	private float salary;
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	

}
