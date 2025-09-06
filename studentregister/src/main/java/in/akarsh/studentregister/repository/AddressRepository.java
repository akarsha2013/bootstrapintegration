package in.akarsh.studentregister.repository;

import in.akarsh.studentregister.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
