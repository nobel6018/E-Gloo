package com.project.egloo.member.domain;

import com.project.egloo.common.ColumnDescription;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Collection;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString(of = {"id", "userId", "email"})
@DynamicInsert
public class Member {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "varchar(255)")
    @Type(type = "uuid-char")
    @ColumnDescription("PK")
    private UUID id;

    @Column(unique = true)
    @ColumnDescription("유저 아이디")
    private String userId;

    @ColumnDescription("유저 이름")
    private String name;

    @Column(columnDefinition = "varchar(255)")
    @ColumnDescription("비밀번호")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(255) default 'LOCAL'")
    @ColumnDescription("유저 회원가입 경로")
    private Social social;

    @ColumnDescription("유저 휴대폰 번호")
    private String phoneNo;

    @Enumerated(EnumType.STRING)
    @ColumnDescription("성별")
    private Gender gender;

    @ColumnDescription("이메일")
    private String email;

    @ColumnDescription("주소")
    private String address;

    @Enumerated(EnumType.STRING)
    @ColumnDescription("유저 Role")
    private MemberRole role;

    public Member(String subject, String s, Collection<? extends GrantedAuthority> authorities) {
    }

    @Builder
    public Member(String userId, String name, String password, Social social, String phoneNo, Gender gender, String email, String address, MemberRole role) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.social = social;
        this.phoneNo = phoneNo;
        this.gender = gender;
        this.email = email;
        this.address = address;
        this.role = role;
    }

    public String getRoleName() {
        return role.name();
    }
}
