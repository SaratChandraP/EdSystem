package means.trials;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TryHashmap {

	public static Object tryHash() {
		
		Map<String, String> testMap = new ConcurrentHashMap<>();
		
		testMap.put("name", "sarat");
		
		return(testMap);
		
	}
}
