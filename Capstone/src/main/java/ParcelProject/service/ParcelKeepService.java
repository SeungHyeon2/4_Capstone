package ParcelProject.service;

import ParcelProject.vo.KeepRequest;

public interface ParcelKeepService{
	int insertParcel(KeepRequest keepRequest) throws Exception;
}