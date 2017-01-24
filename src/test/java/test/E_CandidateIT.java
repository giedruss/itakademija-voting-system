package test;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.hamcrest.CoreMatchers;
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

import net.minidev.json.JSONObject; //string to JSON
import net.minidev.json.parser.JSONParser; //string to JSON
import net.minidev.json.parser.ParseException; //string to JSON
import vs.Application;
import vs.admin.features.candidate.model.Candidate;
import vs.admin.features.candidate.model.CandidateRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = { E_CandidateIT.Config.class,
		Application.class })
public class E_CandidateIT {

	private static final String URI = "/api/candidate";
	JSONParser parser = new JSONParser(0);

	@Autowired
	private TestRestTemplate restTemplate;

	
	
	
	private void createOrUpdateCandidateTest(final JSONObject createCandidate) {
		// Exercise
		ResponseEntity<Void> response = restTemplate.postForEntity(URI, createCandidate, Void.class);
		// Verify
		Assert.assertThat(response.getStatusCode(), CoreMatchers.is(HttpStatus.CREATED));
	}



	private List<Candidate> findAllCandidatesTest() {
		// Setup
		ParameterizedTypeReference<List<Candidate>> candidates = new ParameterizedTypeReference<List<Candidate>>() {
		};
		// Execute
		ResponseEntity<List<Candidate>> response = restTemplate.exchange(URI, HttpMethod.GET, null, candidates);

		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));

		return response.getBody();
	}

	private Candidate deleteCandidateByIdTest(final int id) {
		// Setup
		ParameterizedTypeReference<Candidate> candidate = new ParameterizedTypeReference<Candidate>() {
		};
		// Exercise
		ResponseEntity<Candidate> response = restTemplate.exchange(URI + "/" + id, HttpMethod.DELETE, null, candidate);
		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.NO_CONTENT));

		return response.getBody();
	}

	private Candidate findCandidateByIdTest(final int id) {
		// Setup
		ParameterizedTypeReference<Candidate> candidate = new ParameterizedTypeReference<Candidate>() {
		};
		// Exercise
		ResponseEntity<Candidate> response = restTemplate.exchange(URI + "/" + id, HttpMethod.GET, null, candidate);
		// Verify
		Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));

		return response.getBody();
	}

	// @Before
	// public void setUp() throws Exception {
	// createConstituencies();
	// }

	// keisti
	@Test
	public void createCandidates() {

		// PartyPeople
		
		/*
		{
"candidateDateOfBirth": "string",
					"candidateID": null,
					"candidateName": "string",
					"candidateSurname": "string",
					"candidatePersonalID": "string",
					"candidateDescription": "string",
					"candidateNumberInParty": 23,
"candidateDeletedDate": null,
	 	  
		
"candidateConstituency": {"id": 1},
"candidateParty": {"id": 3}
}






		*/
		final String candidate_01 = "{"
													+ "\"candidateID\": null, " 
													+ "\"candidateName\": \"TOMAS\", "
													+ "\"candidateSurname\": \"AMBRAZAS\", " 
													+ "\"candidateDateOfBirth\": \"1970-06-01\", "
													+ "\"candidatePersonalID\": \"37006010000\", "
													+ "\"candidateDescription\": \"Nuuu kaaa, ir vel valdzioj busiu?\", " 
													
													+ "\"candidateParty\": {\"id\": 1}, "
													+ "\"candidateConstituency\": null, "
													
													+ "\"candidateNumberInParty\": 1"
													+ "}";
		
		final String candidate_02 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"ALGIRDAS\", "
													+ "\"candidateSurname\": \"PALECKIS\", " 
													+ "\"candidateDateOfBirth\": \"1901-08-19\", "
													+ "\"candidatePersonalID\": \"30108190000\", " 
													+ "\"candidateDescription\": \"Tai man dar reikia….\", "
													
													+ "\"candidateParty\": {\"id\": 1}, "
													+ "\"candidateConstituency\": null, "
													
													+ "\"candidateNumberInParty\": 2}";
		
		final String candidate_03 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"JURIJUS\", "
													+ "\"candidateSurname\": \"SUBOTINAS\", " 
													+ "\"candidateDateOfBirth\": \"1989-07-16\", "
													+ "\"candidatePersonalID\": \"38907160000\", " 
													+ "\"candidateDescription\": \"Szto cybie nada\", "
													
													+ "\"candidateParty\": {\"id\": 2}, "
													+ "\"candidateConstituency\": null, "
													
													+ "\"candidateNumberInParty\": 1}";

		// PartyPeopleWithConstituency
		// PartyInput
		final String candidate_04 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"ARTŪRAS\", "
													+ "\"candidateSurname\": \"MELIANAS\", " 
													+ "\"candidateDateOfBirth\": \"1965-04-05\", "
													+ "\"candidatePersonalID\": \"36504050000\", "
													+ "\"candidateDescription\": \"Mane isrinko tauta ir palaiko dievas\", " 
													
													+ "\"candidateParty\": {\"id\": 3}, "
													+ "\"candidateConstituency\": null, "
													
													+ "\"candidateNumberInParty\": 1}";
		
		// ConstituencyInput
		final String candidate_05 = "{\"candidateID\": 4, " 
												+ "\"candidateName\": \"ARTŪRAS\", "
												+ "\"candidateSurname\": \"MELIANAS\", " 
												+ "\"candidateDateOfBirth\": \"1965-04-05\", "
												+ "\"candidatePersonalID\": \"36504050000\", "
												+ "\"candidateDescription\": \"Mane isrinko tauta ir palaiko dievas\", "
												
												+ "\"candidateParty\": null, "	//perraso ankstesnius duomenis i null
												+ "\"candidateNumberInParty\": null, " //perraso ankstesnius duomenis i null
												
												+ "\"candidateConstituency\": {\"id\": 1}}";

		// ConstituencyHeroes
		final String candidate_06 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"ARIMANTAS\", "
													+ "\"candidateSurname\": \"DUMČIUS\", " 
													+ "\"candidateDateOfBirth\": \"1991-11-29\", "
													+ "\"candidatePersonalID\": \"39111290000\", "
													+ "\"candidateDescription\": \"Vape nation, pusiu uz visus\", "
													
													+ "\"candidateParty\": null, "
													+ "\"candidateNumberInParty\": null, "
													
													+ "\"candidateConstituency\": {\"id\": 2}}";
		
		final String candidate_07 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"VIDA MARIJA\", "
													+ "\"candidateSurname\": \"ČIGRIEJIENĖ\", " 
													+ "\"candidateDateOfBirth\": \"1927-09-23\", "
													+ "\"candidatePersonalID\": \"42709230000\", "
													+ "\"candidateDescription\": \"Ka pazadejau ta padarysiu, a jus netikit manim?\", "

													+ "\"candidateParty\": null, "
													+ "\"candidateNumberInParty\": null, "
													
													+ "\"candidateConstituency\": {\"id\": 3}}";
		
		final String candidate_08 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"VIAČESLAV\", "
													+ "\"candidateSurname\": \"TITOV\", " 
													+ "\"candidateDateOfBirth\": \"1953-03-03\", "
													+ "\"candidatePersonalID\": \"45303030000\", " 
													+ "\"candidateDescription\": \"Boze moj\", "
													
													+ "\"candidateParty\": null, "
													+ "\"candidateNumberInParty\": null, "
													
													+ "\"candidateConstituency\": {\"id\": 4}}";
		
		final String candidate_09 = "{\"candidateID\": null, " 
													+ "\"candidateName\": \"BRONISLOVAS\", "
													+ "\"candidateSurname\": \"MATELIS\", " 
													+ "\"candidateDateOfBirth\": \"1944-05-12\", "
													+ "\"candidatePersonalID\": \"34405120000\", "
													+ "\"candidateDescription\": \"Sake galima gerai uzdirbti\", " 
													
													+ "\"candidateParty\": null, "
													+ "\"candidateNumberInParty\": null, "
													
													+ "\"candidateConstituency\": {\"id\": 5}}";

		// PartyPeople
		createOrUpdateCandidateTest(stringToJson(candidate_01));
		createOrUpdateCandidateTest(stringToJson(candidate_02));
		createOrUpdateCandidateTest(stringToJson(candidate_03));
		
		// PartyPeopleWithConstituency
		createOrUpdateCandidateTest(stringToJson(candidate_04));
		// same person different inputs
		createOrUpdateCandidateTest(stringToJson(candidate_05));
		// same person different inputs
//
//		// ConstituencyHeroes
		createOrUpdateCandidateTest(stringToJson(candidate_06));
		createOrUpdateCandidateTest(stringToJson(candidate_07));
		createOrUpdateCandidateTest(stringToJson(candidate_08));
		createOrUpdateCandidateTest(stringToJson(candidate_09));

	}

	// keisti
	@Ignore
	@Test
	public void findAllUndeletedCandidates() {

		List<Candidate> candidates = findAllCandidatesTest();

		Assert.assertThat(candidates.size(), is(8));
	}

	// keisti
	@Ignore
	@Test
	public void deleteCandidate() {

		//
	}

	// keisti
	@Ignore
	@Test
	public void findCandidate() {

		Candidate foundById = findCandidateByIdTest(1);

		// Assert.assertThat(foundById.getId(), is(null));

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
		public CandidateRepository constRepo() {
			return new CandidateRepository();
		}
	}
}
