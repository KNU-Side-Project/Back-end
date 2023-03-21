package com.woopaca.knoo.entity;

import com.woopaca.knoo.controller.auth.dto.SignUpRequestDto;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(unique = true, nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String joinDate;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private EmailVerify emailVerify;
    @Column(nullable = false)
    private String verificationCode;
    private String campus;
    private String major;

    @OneToMany(mappedBy = "writer")
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "writer")
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<CommentLike> commentLikes = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "Role", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role_name")
    private List<String> roles = new ArrayList<>();

    @Builder
    public User(String username, String password, String name, String email,
                String joinDate, EmailVerify emailVerify, String verificationCode, String campus, String major) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.joinDate = joinDate;
        this.emailVerify = emailVerify;
        this.verificationCode = verificationCode;
        this.campus = campus;
        this.major = major;
    }

    public void verify() {
        emailVerify = EmailVerify.ENABLE;
    }

    public static User join(final SignUpRequestDto signUpRequestDto) {
        User user = User.builder()
                .username(signUpRequestDto.getUsername())
                .password((signUpRequestDto.getPassword()))
                .name(signUpRequestDto.getName())
                .email(signUpRequestDto.getEmail())
                .joinDate(LocalDateTime.now().toString())
                .emailVerify(EmailVerify.DISABLE)
                .verificationCode(UUID.randomUUID().toString())
                .build();
        user.roles = Collections.singletonList("ROLE_USER");
        return user;
    }

    public void encodePassword(final PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
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
