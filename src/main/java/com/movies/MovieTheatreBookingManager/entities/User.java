package com.movies.MovieTheatreBookingManager.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(
        name = "USERS",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "users_username_key",
                        columnNames = "EMAIL"
                )
        }
) // user reserved keyword in postgresql
public class User implements UserDetails {

    @Id
    @SequenceGenerator(
            name = "users_user_id_seq",
            sequenceName = "users_user_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "users_user_id_seq"
    )
    @Column(name = "USER_ID")
    private long id;
    @NotBlank(message = "Username is mandatory.")
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Email
    @Column(name = "EMAIL")
    private String email;
    @Size(min = 8, message = "Password should have at least 8 characters.")
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = Role.CUSTOMER;
    }
    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
