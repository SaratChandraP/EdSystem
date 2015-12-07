package means.solution;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TryHashmap {

	public static void tryHash() {
		
		Map<String, List<String>> testMap = new ConcurrentHashMap<>();
		Map<AtomicInteger, Questions> test2 = new ConcurrentHashMap<>();
		AtomicInteger count = new AtomicInteger();
				
		List<String> names = new ArrayList<String>();
		List<String> profs = new ArrayList<String>();
		names.add("sarat");
		names.add("chandra");
		profs.add("student");
		testMap.put("name", names);
		testMap.put("prof", profs);
		
		Questions q1 = new Questions();
		
		q1.setId(1);
		q1.setQuestion("What");
		q1.addAnswer("hey");
		q1.addAnswer("hello");
		System.out.println(count);
		
		test2.put(count, q1);
		count.incrementAndGet();
		
		q1.setId(2);
		q1.setQuestion("Where");
		q1.addAnswer("here");
		q1.addAnswer("there");
		
		test2.put(count, q1);
		
		System.out.println(testMap.toString());
		System.out.println(test2.toString());
		
	}
}
