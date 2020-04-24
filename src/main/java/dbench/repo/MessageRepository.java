package dbench.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbench.models.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
