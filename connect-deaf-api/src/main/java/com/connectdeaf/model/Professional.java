package com.connectdeaf.model;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Entity(name = "professional")
public class Professional {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private String name;

    @Email
    private String email;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,100}$", message = "A senha deve conter pelo menos uma letra maiúscula, uma letra minúscula, um número, um caractere especial e não pode conter espaços em branco.")
    private String password;

    @Pattern(regexp = "^(\\+55|55|0)?\\s?[1-9]{2}\\s?9?[0-9]{4}-?[0-9]{4}$", message = "O número de telefone deve ser um número válido.")
    private String phoneNumber;
    private String actuationArea;
    private String qualification;

    @OneToMany(mappedBy = "professional")
    private List<Address> addresses;

    @CreationTimestamp
    private LocalDateTime createdAt;
}