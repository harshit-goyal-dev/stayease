package com.harshit.stayease.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.harshit.stayease.dto.UserRequestDto;
import com.harshit.stayease.enums.Role;
import com.harshit.stayease.exception.InvalidRoleException;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @Email
    private String email;

    @NotEmpty
    @Length(min=8)
    private String password;

    @NotNull
    private Role role;

    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Booking> bookings;

    public User(@NotNull UserRequestDto dto){
        this.firstName = dto.getFirstName();
        this.lastName = dto.getLastName();
        this.email = dto.getEmail();
        this.password = dto.getPassword();
        this.role = findRole(dto.getRole());
    }

    public Role findRole(String role){
        if(role.equalsIgnoreCase("Admin"))return Role.ADMIN;
        else if(role.equalsIgnoreCase("Customer")) return Role.CUSTOMER;
        else if(role.equalsIgnoreCase("Hotel Manager")) return Role.HOTEL_MANAGER;
        else throw new InvalidRoleException("Role is invalid");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
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
