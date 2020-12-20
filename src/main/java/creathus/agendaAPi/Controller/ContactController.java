package creathus.agendaAPi.Controller;


import creathus.agendaAPi.Dto.ContactDto;
import creathus.agendaAPi.Entity.Contact;
import creathus.agendaAPi.Service.ContactService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/api/v1/contacts")

public class ContactController {

    @Autowired
    ContactService contactService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ContactDto> get(@PathVariable int id){
        var obj = contactService.find(id).contactDto();
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ContactDto>> getAll(){
        var obj = contactService.findAll().stream().map(Contact::contactDto).collect(Collectors.toList());
        return ResponseEntity.ok(obj);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<?> post(@Validated @RequestBody ContactDto objDTO) {
        contactService.insert(objDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@Validated @RequestBody ContactDto objDTO, @PathVariable Integer id){
        var obj =contactService.update(id,objDTO);
        return ResponseEntity.ok(obj.contactDto());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Integer id){
        contactService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
