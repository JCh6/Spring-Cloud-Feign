package com.juanchaparro.springcloudfeign.client;

import com.juanchaparro.springcloudfeign.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableFeignClients
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserClient userClient;

    @GetMapping("/findAllUsers")
    public ResponseEntity<List<UserResponse>> getAllUser() {
        if (userClient == null) {
            log.error("Client is null");
            return ResponseEntity.internalServerError().body(null);
        }
        return ResponseEntity.ok().body(userClient.getUsers());
    }
}
