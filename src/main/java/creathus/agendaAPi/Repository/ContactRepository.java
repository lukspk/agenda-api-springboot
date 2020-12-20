package creathus.agendaAPi.Repository;

import creathus.agendaAPi.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Integer> {
    Optional<Contact> findOptionalByEmail(String email);
}