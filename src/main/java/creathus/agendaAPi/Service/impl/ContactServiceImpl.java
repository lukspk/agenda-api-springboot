package creathus.agendaAPi.Service.impl;

import creathus.agendaAPi.Controller.Exceptions.type.DataIntegrationException;
import creathus.agendaAPi.Dto.ContactDto;
import creathus.agendaAPi.Entity.Contact;
import creathus.agendaAPi.Repository.ContactRepository;
import creathus.agendaAPi.Service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    public Contact find(int id){
        var cont = contactRepository.findById(id);

        if(!cont.isPresent()){
            throw new DataIntegrationException("Contato não existe");
        }

        return cont.get();
    }

    public List<Contact> findAll(){
        return contactRepository.findAll();
    }

    public Contact update(int idContact, ContactDto contact){
        var cont = this.find(idContact);

        cont.setName(contact.getName());
        cont.setSex(contact.getSex());
        cont.setPhone(contact.getPhone());
        cont.setEmail(contact.getEmail());

        return   contactRepository.save(cont);
    }

    public Contact insert(ContactDto contact) {
        var cont = contactRepository.findOptionalByEmail(contact.getEmail());

        if(cont.isPresent()){
            throw new DataIntegrationException("Email Ja Cadastrado");
        }

        return  contactRepository.save( Contact.builder()
                .name(contact.getName())
                .sex(contact.getSex())
                .phone(contact.getPhone())
                .email(contact.getEmail())
                .build());
    }

    public void delete(int idContact){
        var contact = this.find(idContact);
        contactRepository.delete(contact);
    }
}