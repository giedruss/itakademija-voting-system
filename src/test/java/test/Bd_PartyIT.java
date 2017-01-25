package test;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;
import org.junit.Assert;
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
import vs.admin.features.party.model.Party;
import vs.admin.features.party.model.PartyRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Bd_PartyIT.Config.class,
		Application.class })
public class Bd_PartyIT {

	private static final String URI = "/api/party";

	@Autowired
	private TestRestTemplate restTemplate;

	private List<Party> findAllPartiesTest() {
		ParameterizedTypeReference<List<Party>> parties = new ParameterizedTypeReference<List<Party>>() {
		}; // Setup
		ResponseEntity<List<Party>> response = restTemplate.exchange(URI, HttpMethod.GET, null, parties); // Execute
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // Verify

		return response.getBody();
	}

	private Party deletePartyByIdTest(final int id) {
		ParameterizedTypeReference<Party> party = new ParameterizedTypeReference<Party>() {
		}; // Setup
		ResponseEntity<Party> response = restTemplate.exchange(URI + "/" + id, HttpMethod.DELETE, null, party); // Exercise
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // Verify

		return response.getBody();
	}

	private Party findPartyByIdTest(final int id) {
		ParameterizedTypeReference<Party> party = new ParameterizedTypeReference<Party>() {
		}; // Setup
		ResponseEntity<Party> response = restTemplate.exchange(URI + "/" + id, HttpMethod.GET, null, party); // Exercise
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // Verify

		return response.getBody();
	}

	@Test
	public void findAllUndeletedParties() {
		List<Party> parties = findAllPartiesTest();
		int a = 10;
		Assert.assertThat(a, is(parties.size()));
	}

	@Ignore
	@Test
	public void deleteParty() {

		deletePartyByIdTest(1);
		Party foundById = findPartyByIdTest(1);
		Assert.assertThat(foundById.getId(), is(1));
		//
	}

	@Test
	public void findParty() {

		Party foundById = findPartyByIdTest(1);

		Assert.assertThat(foundById.getId(), is(1)); // jeigu ieskos ID 1 tai ir ras ID 1 :D :D :D

		Assert.assertThat(foundById.getParty_abbreviation(), is("LSP"));

	}

	@TestConfiguration
	static class Config {
		@Bean
		@Primary
		public PartyRepository constRepo() {
			return new PartyRepository();
		}
	}
}
