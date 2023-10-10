package com.main.drawingcourse.loader;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.main.drawingcourse.entity.Role;
import com.main.drawingcourse.repository.RoleRepository;

@Component
public class DefaultRoleLoader implements CommandLineRunner {
	private final RoleRepository roleRepository;

	public DefaultRoleLoader(RoleRepository roleRepository) {
		this.roleRepository = roleRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		 if (roleRepository.count() == 0) {
	            Role adminRole = new Role();
	            adminRole.setRoleName("ADMIN");
	            roleRepository.save(adminRole);

	            Role staffRole = new Role();
	            staffRole.setRoleName("STAFF");
	            roleRepository.save(staffRole);

	            Role userRole = new Role();
	            userRole.setRoleName("CUSTOMER");
	            roleRepository.save(userRole);

	            Role instructorRole = new Role();
	            instructorRole.setRoleName("INSTRUCTOR");
	            roleRepository.save(instructorRole);
	        }

	}

}
