package exam_practice2;

import java.util.Calendar;

public class Parking {
	
	
	
	// 1. 필드
	private String carNum;
	private String inTime;
	private String outTime;
	private Calendar calendar = Calendar.getInstance();
	
	// 2. 생성자
	public Parking() {
		// TODO Auto-generated constructor stub
	}

	public Parking(String carNum, String inTime, String outTime) {
		this.carNum = carNum;
		this.inTime = inTime;
		this.outTime = outTime;
	}

	// 3. 메서드
	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}
	
	
	
	
	
	
}
