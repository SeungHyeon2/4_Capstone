package controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ParcelProject.exception.AdminManagementException;
import ParcelProject.service.AdminManagementService;
import ParcelProject.vo.KeepRequest;

@Controller
@RequestMapping(value = "/admin/adminManagement"/*, method = {RequestMethod.POST}*/)
public class AdminManagementController {
	
	@Resource(name="AdminManagementService")
	AdminManagementService adminManagementKeepService;
	
//	@GetMapping()
//	public String adminGet() {
//		return "admin/adminManagement";
//	}
	
	@PostMapping()
	public String adminPost(KeepRequest keepRequest, Model model, 
			@RequestParam(value="admin_id") String adminId, @RequestParam(value="admin_pw") String adminPw) {
		try {
			List<KeepRequest> keepList = adminManagementKeepService.selectParcel(keepRequest);
			model.addAttribute("keepList", keepList);
			
			//return "admin/adminManagement";
			if(adminId.equals("arcanum726@gmail.com") && adminPw.equals("tmdgus1220")) {
				return "admin/adminManagement";
			}else {
				return "admin/adminLogin";
			}
		} catch (AdminManagementException ex) {
			ex.printStackTrace();
			return "home/main";
		}catch (Exception ex) {
			ex.printStackTrace();
			return "home/main";
		}

	}
	
}
