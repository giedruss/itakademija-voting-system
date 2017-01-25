package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;
import vs.Application;
import vs.admin.features.admin.district.District;
import vs.admin.features.party.model.Party;
import vs.representative.features.multi.election.MultiElection;
import vs.representative.features.multi.election.MultiElectionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { F_MultiElectionIT.Config.class,
		Application.class })

public class F_MultiElectionIT {

	private static final String URI = "/api/reg-votes-multi"; // keisti
	JSONParser parser = new JSONParser(0);

	@Autowired
	private TestRestTemplate restTemplate;

	
	private void createOrUpdateMultiElectionTest(final JSONObject createMultiElection) { // keisti
		// Exercise
		ResponseEntity<Void> response = restTemplate.postForEntity(URI, createMultiElection, Void.class); // keisti
		// Verify
		Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.OK)); // keisti
	}

	
	private List<MultiElection> findAllElectionTest() { // keisti
		// Setup
		ParameterizedTypeReference<List<MultiElection>> multiElection = new ParameterizedTypeReference<List<MultiElection>>() { // keisti
		};
		// Execute
		ResponseEntity<List<MultiElection>> response = restTemplate.exchange(URI, HttpMethod.GET, null, multiElection); // keisti

		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // keisti

		return response.getBody();
	}

	
	private MultiElection deleteMultiElectionByIdTest(final int id) { // keisti
		// Setup
		ParameterizedTypeReference<MultiElection> multiElection = new ParameterizedTypeReference<MultiElection>() { // keisti
		};
		// Exercise
		ResponseEntity<MultiElection> response = restTemplate.exchange(URI + "/" + id, HttpMethod.PUT, null, // keisti
				multiElection);
		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // keisti

		return response.getBody(); // keisti
	}

	
	private MultiElection findMultiElectionByIdTest(final int id) { // keisti
		// Setup
		ParameterizedTypeReference<MultiElection> multiElection = new ParameterizedTypeReference<MultiElection>() { // keisti
		};
		// Exercise
		ResponseEntity<MultiElection> response = restTemplate.exchange(URI + "/" + id, HttpMethod.GET, null, // keisti
				multiElection);
		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // keisti

		return response.getBody(); // keisti
	}
	
	
	@Before
	@Test
	public void createElection() {

		final String election_01 = 
				"{\"id\": null," + " \"deleted_date\": null," + " \"entered_date\": null," + 
						" \"published_date\": null,"  +" \"party_id\": 1," + " \"district_id\": 1," + " \"votes\": \"500\"}";

		createOrUpdateMultiElectionTest(stringToJson(election_01));


	}
	
	
	@Test
	public void findAllUndeletedElection() {

		List<MultiElection> multiElection = findAllElectionTest();
		int a = 7;
		Assert.assertThat(a, is(multiElection.size()));
	}
	
	@Test
	public void findElectionById() {

		MultiElection foundById = findMultiElectionByIdTest(1);

		 Assert.assertThat(foundById.getId(), is(1));

	}
	
	@Ignore
	@Test
	public void deleteElection(){
	MultiElection deletedById = deleteMultiElectionByIdTest(1);
	Assert.assertThat(deletedById.getDeleted_date(), is((not(null))));
	}
	
	
	private JSONObject stringToJson(final String jstring) {
		JSONObject json = null;
		try {
			json = (JSONObject) parser.parse(jstring);
		} catch (ParseException e) {
			System.out.println("---------------------------------------------");
			e.printStackTrace();
		}
		return json;
	}
	
	
	@TestConfiguration
	static class Config {
		@Bean
		@Primary
		public MultiElectionRepository multiRepo() {
			return new MultiElectionRepository();
		}
	}
}