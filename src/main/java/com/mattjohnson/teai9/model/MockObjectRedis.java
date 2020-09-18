package com.mattjohnson.teai9.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.io.Serializable;

@RedisHash("MockObjectRedis")
@JsonPropertyOrder({"id", "firstName", "lastName", "email", "gender", "ip_address"})
@Getter
@Setter
@NoArgsConstructor
@ToString
public class MockObjectRedis implements Serializable {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String ip_adress;

}
