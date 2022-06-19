package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final DtoRequestMapper<UserRequestDto, User> userRequestMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(DtoRequestMapper<UserRequestDto, User> userRequestMapper,
                                    AuthenticationService authenticationService) {
        this.userRequestMapper = userRequestMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }
}
