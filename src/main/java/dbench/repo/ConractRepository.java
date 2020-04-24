package dbench.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbench.models.Contract;

@Repository
public interface ConractRepository extends JpaRepository<Contract, Long> {

}
