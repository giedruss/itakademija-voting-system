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
import vs.admin.features.admin.representative.Representative;
import vs.admin.features.admin.representative.RepresentativeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { Bc_RepresentativeIT.Config.class,
		Application.class })
public class Bc_RepresentativeIT {

	private static final String URI = "/api/representative";

	@Autowired
	private TestRestTemplate restTemplate;

	private List<Representative> findAllRepresentativesTest() { // keisti
		// Setup
		ParameterizedTypeReference<List<Representative>> representatives = new ParameterizedTypeReference<List<Representative>>() { // keisti
		};
		// Execute
		ResponseEntity<List<Representative>> response = restTemplate.exchange(URI, HttpMethod.GET, null,
				representatives); // keisti

		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // keisti

		return response.getBody();
	}

	private Representative deleteRepresentativeByIdTest(final int id) { // keisti
		// Setup
		ParameterizedTypeReference<Representative> representative = new ParameterizedTypeReference<Representative>() { // keisti
		};
		// Exercise
		ResponseEntity<Representative> response = restTemplate.exchange(URI + "/" + id, HttpMethod.DELETE, null, // keisti
				representative);
		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.NO_CONTENT)); // keisti

		return response.getBody(); // keisti
	}

	private Representative findRepresentativeByIdTest(final int id) { // keisti
		// Setup
		ParameterizedTypeReference<Representative> representative = new ParameterizedTypeReference<Representative>() { // keisti
		};
		// Exercise
		ResponseEntity<Representative> response = restTemplate.exchange(URI + "/" + id, HttpMethod.GET, null, // keisti
				representative);
		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK)); // keisti

		return response.getBody(); // keisti
	}

	@Ignore
	@Test
	public void findAllUndeletedRepresentatives() {

		List<Representative> representatives = findAllRepresentativesTest();

		Assert.assertThat(representatives.size(), is(2));
	}

	@Ignore
	@Test
	public void deleteRepresentative() {

		Representative deleted = deleteRepresentativeByIdTest(1);
	}

	@Test
	public void findRepresentative() {

		Representative foundById = findRepresentativeByIdTest(1);

		Assert.assertThat(foundById.getName(), is("Zenonas"));

	}

	@TestConfiguration
	static class Config {
		@Bean
		@Primary
		public RepresentativeRepository constRepo() {
			return new RepresentativeRepository();
		}
	}
}
