package com.taktazit.dataaccessobject;

import com.taktazit.domainobject.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
