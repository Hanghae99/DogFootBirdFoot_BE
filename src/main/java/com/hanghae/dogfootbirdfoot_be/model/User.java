package com.hanghae.dogfootbirdfoot_be.model;


<<<<<<< HEAD
import com.hanghae.dogfootbirdfoot_be.dto.SignupRequestDto;
=======
>>>>>>> origin/write
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> origin/write

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
<<<<<<< HEAD
    @Column(name = "user_id")
=======
>>>>>>> origin/write
    private Long userId;

    @Column(nullable = false)
    private String username;

<<<<<<< HEAD
    @Column(nullable = true)
=======
    @Column(nullable = false)
>>>>>>> origin/write
    private String email;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

<<<<<<< HEAD
    @Column(nullable = true)
    private String userProfile;

    @OneToMany(mappedBy = "user")//변경
    private List<Post> postList;

    public String getUsername() {
        return username;
    }

    public User(SignupRequestDto signupRequestDto){
        this.username=signupRequestDto.getUsername();
        this.password = signupRequestDto.getPassword();
        this.email = signupRequestDto.getEmail();
        this.nickname = signupRequestDto.getNickname();

    }

    public User(String username, String passwordEncode, String email, String nickname) {
        this.username=username;
        this.password = passwordEncode;
        this.email = email;
        this.nickname = nickname;
    }
}

=======
    @Column(nullable = false)
    private String userProfile;


}
>>>>>>> origin/write
