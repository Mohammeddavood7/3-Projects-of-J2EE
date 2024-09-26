package truck;

import java.io.Serializable;

public class BeanOfTruck implements Serializable
{
	private static final long serialVersionUID = -4354396978708285940L;
	private String truckModel;
	private String truckNO;
	private String insurance;
	private String insuranceCompany;
	private String onwer;
	private long mobile;
	private String fromRoute;
	private String toRoute;
	private String truckInstallDate;
	private String status;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTruckModel() {
		return truckModel;
	}
	public String getTruckInstallDate() {
		return truckInstallDate;
	}
	public void setTruckInstallDate(String truckInstallDate) {
		this.truckInstallDate = truckInstallDate;
	}
	public void setTruckModel(String truckMode) {
		this.truckModel = truckMode;
	}
	public String getTruckNO() {
		return truckNO;
	}
	public void setTruckNO(String truckNO) {
		this.truckNO = truckNO;
	}
	public String getInsurance() {
		return insurance;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	public String getOnwer() {
		return onwer;
	}
	public void setOnwer(String onwer) {
		this.onwer = onwer;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getFromRoute() {
		return fromRoute;
	}
	public void setFromRoute(String fromRoute) {
		this.fromRoute = fromRoute;
	}
	public String getToRoute() {
		return toRoute;
	}
	public void setToRoute(String toRoute) {
		this.toRoute = toRoute;
	}
	
	
	
}