package exam_practice2;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Controller {
	
	ArrayList<Parking> parkingList = new ArrayList<>();
	
	public boolean carIn(String carNum) {
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		
		for(Parking tmp : parkingList) {
			if(tmp.getCarNum().equals(carNum)) {
				return false;
			}
		}
		Parking add = new Parking(carNum, nowDate, nowTime, null, 0);
		parkingList.add(add);
		return true;
	}
	
	public int carOut(String carNum) {
		LocalDate nowDate = LocalDate.now();
		LocalTime nowTime = LocalTime.now();
		int parkedTime=0;
		int dayTimeParked=0;
		int tmp2=0;
		int i=0;
		for(Parking tmp : parkingList) {
			if(tmp.getCarNum().equals(carNum) && tmp.getOuttime()==null) {	// ÁÖÂ÷µÈ
				tmp.setOuttime(nowTime);
				parkedTime = (int)ChronoUnit.MINUTES.between(tmp.getIntime(), nowTime);
				dayTimeParked = (int)ChronoUnit.DAYS.between(tmp.getDate(), nowDate);
				parkedTime-=30;
				if(parkedTime<=0) { 
					tmp.setPay(0);
					parkedTime = 0;
				}
				else {
					if(parkedTime%10==0) {
						parkedTime = (parkedTime/10)*1000;
						tmp.setPay(parkedTime);
					}
					else {
						parkedTime = (parkedTime/10+1)*1000;
						tmp.setPay(parkedTime);
					}
				}
				parkingList.set(i, tmp);
				i++;
				return parkedTime;
			}
		}
		
		return -1;
	}
	
}
