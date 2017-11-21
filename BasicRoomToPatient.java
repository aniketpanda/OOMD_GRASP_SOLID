import java.util.*;


public class BasicRoomToPatient{
	
	static Map<String,List<String>> maproom = new HashMap<String,List<String>>();//(doctor key,values are patients)

	static List<String> people = new ArrayList<String>();	

	public static void BasicRoomToPatient(String roomno,String pname){
		
		if(maproom.get(roomno) ==  null){
			List<String> people1 = new ArrayList<String>();	
			people1.add(pname);
		    maproom.put(roomno,people1);
		    System.out.println("BasicRoom " + roomno + " is assigned to "+ pname);		
		}
		else
		{
			people = maproom.get(roomno);
			people.add(pname);
		    maproom.put(roomno,people);
		    System.out.println("Doctor " + roomno + " is assigned to "+ pname);
		}
	}

	public static void room_patients(){
		List<String> keys = new ArrayList<String>(maproom.keySet());
		for (String key: keys)
		{	
	  			System.out.println("patients allocate to Roomno "+ key + " are : " + maproom.get(key));
	  		
		}
	}


	public static void seeAllotment(){
	 	 System.out.println(Arrays.asList(maproom));

	 }

}
