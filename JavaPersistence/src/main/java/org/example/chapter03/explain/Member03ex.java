
package org.example.chapter03.explain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//@Table(name = "MBR")
@Table
public class Member03ex {

    @Id
    private Long id;

    @Column(name = "name")
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob
    private String description;


    public Member03ex() {
    }

}
