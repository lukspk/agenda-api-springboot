package creathus.agendaAPi.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {
    private int id;
    private String name;
    private char sex;
    private String phone;
    private String email;
}