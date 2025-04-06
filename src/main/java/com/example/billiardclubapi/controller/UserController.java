//package com.example.billiardclubapi.controller;
//import com.example.billiardclubapi.dto.request.user.UserChangePasswordRequest;
//import com.example.billiardclubapi.dto.request.user.UserEditRequest;
//import com.example.billiardclubapi.dto.request.user.UserRestrictRequest;
//import com.example.billiardclubapi.dto.response.user.UserListResponse;
//import com.example.billiardclubapi.dto.response.user.UserResponse;
//import com.example.billiardclubapi.entity.User;
//import com.example.billiardclubapi.mapper.UserMapper;
//import com.example.billiardclubapi.service.UserService;
//import io.swagger.v3.oas.annotations.security.SecurityRequirement;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.security.Principal;
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/v1/carambol/users")
//@SecurityRequirement(name = "BearerAuth")
//public class UserController {
//    private final UserService userService;
//    private final UserMapper userMapper;
//
//    @GetMapping
//    public ResponseEntity<UserListResponse> findAll() {
//        List<User> userList = userService.getAll();
//        return new ResponseEntity<>(userMapper.toListResponse(userList), HttpStatus.OK);
//    }
//
//    @GetMapping("/profile")
//    public ResponseEntity<UserResponse> findById(Principal principal) {
//        User user = userService.getById(getCurrentUser(principal).getId());
//        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.OK);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<UserResponse> update(@RequestBody UserEditRequest request, Principal principal){
//        User user = userService.update(userMapper.toEntity(getCurrentUser(principal).getId(), request));
//        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.OK);
//    }
//
//    @PutMapping("/change-password")
//    public ResponseEntity<UserResponse> changePassword(@RequestBody UserChangePasswordRequest request, Principal principal) {
//        User user = userService.changePassword(getCurrentUser(principal).getId(), request);
//        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.OK);
//    }
//
//    @PutMapping("/change-status")
//    public ResponseEntity<UserResponse> changeRestrictStatus(@RequestBody UserRestrictRequest request) {
//        User user = userService.changeRestrictionsStatus(request);
//        return new ResponseEntity<>(userMapper.toResponse(user), HttpStatus.OK);
//    }
//
//    private User getCurrentUser(Principal principal) {
//        return (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
//    }
//}
