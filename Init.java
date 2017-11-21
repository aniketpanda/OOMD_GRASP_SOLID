import java.util.Scanner;

public class Init {
	public static void main(String[] args) {
		System.out.println("Hospital Management System: ");

		Init.dispMenu();
		int option, age, id, pid, did;
		String name, sp, pname, dname, roomno;
		Person p;
		int m = 9;
		
		Person[] patientlist = new Patient[500];
		Person[] doctorlist = new Doctor[500];
		int pcount = 0, dcount = 0;

		Scanner sc = new Scanner(System.in);
		

		do {
			option = sc.nextInt();
			switch(option) {
				
				case 1: 
					System.out.println("Enter name: ");
					name = sc.next();
					System.out.println("Enter age: ");
					age = sc.nextInt();
					p = PersonFactory.createPerson("patient", name, age);
					patientlist[ pcount++ ] = p;
					System.out.println(patientlist.length);
					System.out.println("Created new patient: " + p.id);
					Init.dispMenu();
					break;
				
				case 2:
					System.out.println("Enter patient id: ");
					id = sc.nextInt();
					patientlist = Patient.dischargePatient(patientlist, id);
					Init.dispMenu();
					break;

				case 3:
					System.out.println("Enter name: ");
					name = sc.next();
					System.out.println("Enter age: ");
					age = sc.nextInt();
					System.out.println("Enter speciality: ");
					sp = sc.next();
					p = PersonFactory.createPerson("doctor", name, age, sp);
					doctorlist[ dcount++ ] = p;
					System.out.println("DCOUNT + " + dcount);
					System.out.println("Created new doctor: " + p.id);
					Init.dispMenu();
					break;
				
				case 4:
					System.out.println("Enter id: ");
					id = sc.nextInt();
					doctorlist = Doctor.removeDoctor(doctorlist, id);
					Init.dispMenu();
					break;
				
				case 5:
					System.out.println("Enter doctor name: ");
					dname = sc.next();
					System.out.println("Enter patient name: ");
					pname = sc.next();
					addPatientsToDoctor.addPatientsToDoctor(pname,dname);
					Init.dispMenu();
					break;
				
				case 6:
					System.out.println("Enter Roomno ");
					roomno = sc.next();
					System.out.println("Enter patient name: ");
					pname = sc.next();
					BasicRoomToPatient.BasicRoomToPatient(roomno,pname);
					Init.dispMenu();
					break;

				case 7:
					for(int i = 0; i  < pcount; i++)
						System.out.println(patientlist[i].id + "  " + patientlist[i].name + "  " + patientlist[i].age + "  " + patientlist[i].status);
					Init.dispMenu();
					break;

				case 8:
					for(int i = 0; i  < dcount; i++)
						System.out.println(doctorlist[i].id + "  " + doctorlist[i].name + "  " + doctorlist[i].age + "  " + doctorlist[i].sp + "  " + doctorlist[i].status + "  " + doctorlist[i].getExperience());
					Init.dispMenu();
					break;	

				case 9:
					addPatientsToDoctor.doctor_patients();	
					break;

				case 10:
					BasicRoomToPatient.room_patients();	
					break;	
					
				case 11:
					break;
				
				default:
					System.out.println("Invalid entry");
					Init.dispMenu();
			}
		} while(option != 9);


	}

	private static void dispMenu() {
		System.out.println();
		System.out.println("#########################################");
		System.out.println("1. Admit a patient");
		System.out.println("2. Discharge a patient");
		System.out.println("3. Add a doctor");
		System.out.println("4. Remove a doctor");
		System.out.println("5. Allot a doctor to an active patient");
		System.out.println("6. Allot a patient to an room");
		System.out.println("7. View patients");
		System.out.println("8. View doctors");
		System.out.println("9. See allotment of doctors");
		System.out.println("10. See allotment of rooms");
		System.out.println("11. Exit");
		System.out.println("#########################################");
	}
}