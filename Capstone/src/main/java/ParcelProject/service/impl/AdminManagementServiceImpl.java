package ParcelProject.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ParcelProject.dao.ParcelDAO;
import ParcelProject.exception.AdminManagementException;
import ParcelProject.service.AdminManagementService;
import ParcelProject.vo.KeepRequest;


@Service("AdminManagementService")
@Transactional
public class AdminManagementServiceImpl implements AdminManagementService {
	
	@Autowired
	private ParcelDAO parcelDAO;

	@Override
	public List<KeepRequest> selectParcel(KeepRequest keepRequest) throws Exception {
		
		List<KeepRequest> result = parcelDAO.selectParcel(keepRequest);
		if(result!=null) {
			return result;
		}
		else {
			throw new AdminManagementException("fail");
		}
		//int result = parcelDAO.insertParcel(keepRequest);
		//if (result == 1) {
		//	return result;
		//} else {
		//	throw new ParcelKeepException("fail keep");
		//}
	}
	
	

}
