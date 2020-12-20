package creathus.agendaAPi.Service;

import creathus.agendaAPi.Dto.ContactDto;
import creathus.agendaAPi.Entity.Contact;

import java.util.List;

public interface ContactService {

    Contact find(int id);
    List<Contact> findAll();
    Contact update(int idContact, ContactDto contact);
    Contact insert(ContactDto contact);
    void delete(int idContact);
}