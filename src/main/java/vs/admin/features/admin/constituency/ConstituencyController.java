package vs.admin.features.admin.constituency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vs.admin.features.admin.district.District;

@RestController
public class ConstituencyController {

	@Autowired
	private ConstituencyRepository constituencyRepository;

	@Autowired
	private ConstituencyService constituencyService;

	@RequestMapping(value = "/api/constituency", method = RequestMethod.GET)
	public List<Constituency> findAllConstituencies() {
		return constituencyRepository.findAllConstituencies();
	}

	@RequestMapping(value = "/api/constituency", method = RequestMethod.POST)
	public Constituency createOrUpdateConstituency(@RequestBody Constituency con) {
		return constituencyRepository.saveOrUpdate(con);
	}

	@RequestMapping(value = "/api/constituency/{id}", method = RequestMethod.GET)
	public List<District> getRole(@PathVariable("id") Integer id) {
		return constituencyService.getDistrictListByConstituency(id);

	}
}
