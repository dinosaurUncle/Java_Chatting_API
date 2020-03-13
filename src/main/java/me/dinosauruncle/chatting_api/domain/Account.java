package me.dinosauruncle.chatting_api.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Account {

    @Id @Size(max = 250)
    private String id;

    private String name;

    private String password;

    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    private String email;

    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void save(String... parameter){
        this.id = parameter[0];
        this.name = parameter[1];
        this.password = parameter[2];
        this.gender = parameter[3].equals("0") ? Gender.MALE : Gender.FEMALE ;
        this.email = parameter[4];
        this.phone = parameter[5];
    }
}
