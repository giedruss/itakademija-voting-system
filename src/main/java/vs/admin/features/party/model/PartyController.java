package vs.admin.features.party.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vs.admin.features.admin.district.District;
import vs.admin.features.admin.district.DistrictRepository;

@RestController
public class PartyController {

	@Autowired
	private PartyRepository partyRepository;

	@RequestMapping(value = "/api/party", method = RequestMethod.GET)
	public List<Party> findAllParties() {
		return partyRepository.findAllParties();
	}

	@RequestMapping(value = "/api/party", method = RequestMethod.POST)
	public Party createOrUpdateParty(@RequestBody Party party) {
		return partyRepository.saveOrUpdate(party);

	}
}
