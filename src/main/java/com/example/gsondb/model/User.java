package com.example.gsondb.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users2")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true, length = 25)
    private String email;

    @Column(nullable = false, length = 15)
    private String password;

    @Column(nullable = false,length = 15,name = "first_name")
    private String firstName;

    @Column(nullable = false, length = 15, name = "last_name")
    private String lastName;

    @OneToMany(mappedBy = "uid",cascade = CascadeType.ALL)
    private Set<Post> posts;

}
