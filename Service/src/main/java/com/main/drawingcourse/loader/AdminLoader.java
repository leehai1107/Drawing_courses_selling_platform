package com.main.drawingcourse.loader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.entity.User;
import com.main.drawingcourse.repository.RoleRepository;
import com.main.drawingcourse.service.IUserService;

@Component
@Order(2)
public class AdminLoader implements CommandLineRunner{
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private final IUserService service;

	public AdminLoader(IUserService service) {
		this.service= service;
	}
	@Override
	public void run(String... args) throws Exception {
		if(service.findUserByUserName("ADMIN") == null) {
			User admin = new User();
			admin.setDescription("Who control the system");
			admin.setRole(roleRepository.getReferenceById(1));
			admin.setFullname("Administrator");
			admin.setStatus(true);
			admin.setUserName("ADMIN");//admin user name
			admin.setPassword("ADMIN@@@");//this is admin password
			service.addUser(admin);
		}

	}
}
