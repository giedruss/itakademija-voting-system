package vs.admin.features.admin.constituency;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vs.admin.features.admin.district.District;

@Service
public class ConstituencyService {

	@Autowired
	ConstituencyRepository constituencyRepository;

	public List<Constituency> getConstituencyWithoutDeletedDistricts() {

		List<District> districtList = null;
		List<Constituency> constituencies = constituencyRepository.findAllConstituencies();

		for (Constituency constituency : constituencies) {
			districtList = constituency.getDistricts();
			for (District district : districtList) {
				Iterator<District> iter = districtList.iterator();
				while (iter.hasNext()) {
					district = iter.next();
					if (district.getDeletedTime() != null)
						iter.remove();
				}
			}
		}
		return constituencies;

	}

}
