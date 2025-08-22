package com.jiwon.planet.user;

import com.jiwon.planet.error.CustomException;
import com.jiwon.planet.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public void save(RegisterRequest request) {
        if (userRepository.existsByAccountId(request.getAccountId())) {
            throw new CustomException(ErrorCode.DUPLICATE_ACCOUNT_ID);
        }

        if (!request.getPassword().equals(request.getPasswordConfirm())) {
            throw new CustomException(ErrorCode.NOT_CONFIRM_PASSWORD);
        }

        String encodedPassword = bCryptPasswordEncoder.encode(request.getPassword());
        User user = request.toEntity(encodedPassword);
        userRepository.save(user);
    }
}
