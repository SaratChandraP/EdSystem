package means.resources.test;

import java.io.IOException;

import org.junit.Rule;
import org.junit.Test;

import io.dropwizard.testing.junit.ResourceTestRule;
import means.core.Questions;

public class QuestionResourceTest{
	
	@Rule
	public final ResourceTestRule resources = ResourceTestRule.builder()
	.addResource(new Questions()).build();
	
	@Test
	public void testQuestions() throws IOException{
//		String resp = resources.client().target("/api/questions")
//				.request();
	}

}
