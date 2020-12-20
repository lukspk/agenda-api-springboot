package creathus.agendaAPi.Entity;

import creathus.agendaAPi.Dto.ContactDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Data
@Entity
@Table(name = "contatos")
@NoArgsConstructor
@AllArgsConstructor
public class Contact implements Serializable {

    private static final long serialVersionUID = -1559864615786877060L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private char sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email")
    private String email;

    @Transient
    public ContactDto contactDto(){
        return new ContactDto(id, name, sex, phone, email);
    }

}