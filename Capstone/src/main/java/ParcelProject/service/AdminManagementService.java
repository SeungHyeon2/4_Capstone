package ParcelProject.service;

import java.util.List;

import ParcelProject.vo.KeepRequest;

public interface AdminManagementService {
	List<KeepRequest> selectParcel(KeepRequest keepRequest) throws Exception;
}
