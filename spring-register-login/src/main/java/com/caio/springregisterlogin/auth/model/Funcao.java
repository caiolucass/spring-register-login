package com.caio.springregisterlogin.auth.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Funcao {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeCargo;

    @ManyToMany
    @ToString.Exclude
    private Set<Usuario> usuarios;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Funcao funcao = (Funcao) o;
        return id != null && Objects.equals(id, funcao.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
