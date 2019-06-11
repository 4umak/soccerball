package com.naukma.soccer.enteties;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "authority")
    private String name;

    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(mappedBy = "roleList")
    private List<Client> clientRolesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClientRolesList() {
        return clientRolesList;
    }

    public void setClientRolesList(List<Client> clientRolesList) {
        this.clientRolesList = clientRolesList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
