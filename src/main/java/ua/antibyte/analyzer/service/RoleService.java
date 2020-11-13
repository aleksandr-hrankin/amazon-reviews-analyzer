package ua.antibyte.analyzer.service;

import ua.antibyte.analyzer.entity.Role;

public interface RoleService {
    Role save(Role role);

    Role findByName(String roleName);
}
