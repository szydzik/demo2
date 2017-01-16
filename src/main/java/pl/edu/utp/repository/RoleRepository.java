package pl.edu.utp.repository;

import org.springframework.data.repository.CrudRepository;
import pl.edu.utp.model.user.Role;

import java.util.List;

/**
 * Created by xxbar on 17.01.2017.
 */
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
    Role findByName(String name);
}
