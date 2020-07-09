package pojoClass;

import java.util.List;

public class EmployeeData {

	private String status;
	private List<EmpDetails> data;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<EmpDetails> getData() {
		return data;
	}
	public void setData(List<EmpDetails> data) {
		this.data = data;
	}
	
}
