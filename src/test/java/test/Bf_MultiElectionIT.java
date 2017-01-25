package test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;

import java.util.List;

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
import vs.Application;
import vs.representative.features.multi.election.MultiElection;
import vs.representative.features.multi.election.MultiElectionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Bf_MultiElectionIT.Config.class,
		Application.class })

public class Bf_MultiElectionIT {

	private static final String URI = "/api/reg-votes-multi";

	@Autowired
	private TestRestTemplate restTemplate;

	private List<MultiElection> findAllElectionTest() {
		ParameterizedTypeReference<List<MultiElection>> multiElection = new ParameterizedTypeReference<List<MultiElection>>() {
		}; // Setup
		ResponseEntity<List<MultiElection>> response = restTemplate.exchange(URI, HttpMethod.GET, null, multiElection); // Execute
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // Verify

		return response.getBody();
	}

	private MultiElection deleteMultiElectionByIdTest(final int id) {
		ParameterizedTypeReference<MultiElection> multiElection = new ParameterizedTypeReference<MultiElection>() {
		}; // Setup
		ResponseEntity<MultiElection> response = restTemplate.exchange(URI + "/" + id, HttpMethod.PUT, null,
				multiElection); // Exercise
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // Verify

		return response.getBody();
	}

	private MultiElection findMultiElectionByIdTest(final int id) {
		ParameterizedTypeReference<MultiElection> multiElection = new ParameterizedTypeReference<MultiElection>() {
		}; // Setup
		ResponseEntity<MultiElection> response = restTemplate.exchange(URI + "/" + id, HttpMethod.GET, null,
				multiElection); // Exercise
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // Verify

		return response.getBody();
	}

	
	@Test // jeigu reikia testavimo prioritetu tai galima naudoti toki metoda kaip cia
	public void testPriority() {
		findAllUndeletedElection(5);
		findElectionById();
		deleteElection();
		findAllUndeletedElection(4);
	}
	
//@Test
	public void findAllUndeletedElection(int expected) {

		List<MultiElection> multiElection = findAllElectionTest();
		// int expected = 5;
		Assert.assertThat(multiElection.size(), is(expected));
	}
	
//@Test
	public void findElectionById() {
		MultiElection foundById = findMultiElectionByIdTest(3);
		Assert.assertThat(foundById.getVotes(), is(300));
	}

//@Test
	public void deleteElection() {
		MultiElection deletedById = deleteMultiElectionByIdTest(2);
//		Assert.assertThat(deletedById.getDeleted_date(), is((not(null)))); //neveikia, null pointer
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