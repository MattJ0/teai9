package com.mattjohnson.teai9.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Document
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({"id", "firstName", "lastName", "email", "gender", "ip_address"})
public class MockObjectMongo {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ip_adress;


}
