package tanService;

import java.util.HashMap;
import java.util.Random;

public class TanServiceImpl implements TanService {
	private HashMap<String, Integer> tanList = new HashMap<String, Integer>();

	private int createTan(String sessionID) {
		Random r = new Random();
		Integer tan = r.nextInt(89999) + 10000;
		tanList.put(sessionID, tan);
			
		return tan;
	}
	
	public int getTan(String sessionID) {
		
		Integer tan = tanList.get(sessionID);
		if(tan == null) {
			tan = createTan(sessionID);
		}
		
		return tan;
	}
}
