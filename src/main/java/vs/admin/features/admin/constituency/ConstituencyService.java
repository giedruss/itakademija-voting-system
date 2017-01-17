package vs.admin.features.admin.constituency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vs.admin.features.admin.district.District;

@Service
public class ConstituencyService {

	@Autowired
	ConstituencyRepository constituencyRepository;
	
	protected List<District> getDistrictListByConstituency(Integer id){
		Constituency constituency = constituencyRepository.findConstituencyById(id);
		return constituency.getDistricts();
	}
}

