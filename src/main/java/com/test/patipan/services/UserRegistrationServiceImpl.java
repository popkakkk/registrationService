package com.test.patipan.services;

import com.test.patipan.Exception.CantAssignMemberException;
import com.test.patipan.entity.Member;
import com.test.patipan.entity.User;
import com.test.patipan.model.Information;
import com.test.patipan.repository.MemberRepository;
import com.test.patipan.repository.UserRepository;
import com.test.patipan.util.MemberType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public void saveUser(User user) throws CantAssignMemberException {
        int memberType = getMemberTypeBySalary(user.getSalary());
        if (memberType == 0) {
            throw new CantAssignMemberException("Can not assign member type , salary < 15000");
        }
        user.setUserTypeCode(memberType);

        Date createDate = new Date();
        user.setCreateDate(createDate);

        user.setPassword(encoder.encode(user.getPassword()));
        user.setReferenceCode(generateReferenceCode(createDate, user.getPhoneNumber()));

        userRepository.save(user);
    }

    @Override
    public int getMemberTypeBySalary(int salary) {
        int memberType = 0;
        if (salary > 50000) {
            memberType = MemberType.PLATINUM.getId();
        } else if (salary >= 30000) {
            memberType = MemberType.GOLD.getId();
        } else if (salary >= 15000) {
            memberType = MemberType.SILVER.getId();
        }
        return memberType;
    }

    @Override
    public String generateReferenceCode(Date createDate, String phoneNumber) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        return dateFormat.format(createDate) + phoneNumber.substring(phoneNumber.length() - 4);
    }

    @Override
    public Information getInformation()  {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userDetails.getUsername();
        User user = userRepository.findByUsername(username);
        Information information = new Information();
        information.setUsername(user.getUsername());
        information.setFirstName(user.getFirstName());
        information.setLastName(user.getLastName());
        information.setPhoneNumber(user.getPhoneNumber());
        information.setCreateDate(user.getCreateDate());
        information.setSalary(user.getSalary());
        information.setReferenceCode(user.getReferenceCode());
        Member member = memberRepository.findById(user.getUserTypeCode()).orElseThrow(EntityNotFoundException::new);
        information.setUserType(member.getMemberName());

        return information;
    }


}
