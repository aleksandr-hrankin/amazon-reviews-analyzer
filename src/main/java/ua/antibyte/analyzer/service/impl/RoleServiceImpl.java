package ua.antibyte.analyzer.service.impl;

import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.Role;
import ua.antibyte.analyzer.repository.RoleRepository;
import ua.antibyte.analyzer.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role findByName(String roleName) {
        return roleRepository.findByRoleName(Role.of(roleName).getRoleName());
    }
}
