package means.trials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TryHashmap {

	public static Object tryHash() {
		
		Map<String, List<String>> testMap = new ConcurrentHashMap<>();
		
		List<String> names = new ArrayList<String>();
		List<String> profs = new ArrayList<String>();
		names.add("sarat");
		names.add("chandra");
		profs.add("student");
		testMap.put("name", names);
		testMap.put("prof", profs);
		
		return(testMap);
		
	}
}
