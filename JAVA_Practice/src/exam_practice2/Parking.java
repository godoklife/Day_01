package exam_practice2;

import java.time.LocalDate;
import java.time.LocalTime;

public class Parking {
	
	
	
	// 1. 필드
	private String carNum;
	private LocalDate date;
	private LocalTime intime;
	private LocalTime outtime;
	private int pay;
	// 2. 생성자
	public Parking(String carNum, LocalDate date, LocalTime intime, LocalTime outtime, int pay) {
		super();
		this.carNum = carNum;
		this.date = date;
		this.intime = intime;
		this.outtime = outtime;
		this.pay = pay;
	}
	public Parking() {
		// TODO Auto-generated constructor stub
	}
	
	public String getCarNum() {
		return carNum;
	}
	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getIntime() {
		return intime;
	}
	public void setIntime(LocalTime intime) {
		this.intime = intime;
	}
	public LocalTime getOuttime() {
		return outtime;
	}
	public void setOuttime(LocalTime outtime) {
		this.outtime = outtime;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	
	
}
