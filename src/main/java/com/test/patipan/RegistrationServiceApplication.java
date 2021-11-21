package com.test.patipan;

import com.test.patipan.entity.Member;
import com.test.patipan.repository.MemberRepository;
import com.test.patipan.util.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RegistrationServiceApplication implements CommandLineRunner {
    @Autowired
    private MemberRepository memberRepository;

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Member memberPlatinum = new Member(1, MemberType.PLATINUM.name());
        Member memberGold = new Member(2, MemberType.GOLD.name());
        Member memberSilver = new Member(3, MemberType.SILVER.name());
        memberRepository.saveAll(Arrays.asList(memberPlatinum, memberGold, memberSilver));
    }
}


