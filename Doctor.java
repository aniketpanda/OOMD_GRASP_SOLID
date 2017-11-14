import java.util.Random;

public class Doctor extends Person {
	
	public Doctor(String name, int age, String sp) {
		this.persontype = "doctor";
		this.name = name;
		this.age = age;
		this.sp = sp;
		this.id += new Random().nextInt(9999) + new Random().nextInt(9999);
		this.status = "active";
		this.minExperience = 5;
	}

	public static Person[] removeDoctor(Person[] doctorlist, int id) {
		for(int i = 0; i < doctorlist.length; i++) {
			if(doctorlist[i].id == id) {
				doctorlist[i].status = "removed";
				break;
			}
		}
		return doctorlist;
	}

	public int getExperience() {
		return this.minExperience;
	}

	public boolean checkAgeValidity() {
		if((this.age - this.minExperience)<24){
			return false;
		}
		else {
			return true;
		}
	}

	public boolean checkStatus() {
		if(this.status.equals("active") == true) {
			return true;
		}
		else {
			return false;
		}
	}


}