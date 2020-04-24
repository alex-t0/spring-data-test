package dbench.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import dbench.models.Tender;

public interface TenderRepository extends JpaRepository<Tender, Long> {

}
