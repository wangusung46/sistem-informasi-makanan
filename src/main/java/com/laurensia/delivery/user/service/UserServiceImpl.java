package com.laurensia.delivery.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.laurensia.delivery.baseresponse.BaseResponse;
import com.laurensia.delivery.user.model.User;
import com.laurensia.delivery.user.repository.UserRepository;
import com.laurensia.delivery.user.request.UserIdRequest;
import com.laurensia.delivery.user.request.UserSaveRequest;
import com.laurensia.delivery.user.response.UserDetailResponse;
import com.laurensia.delivery.user.response.UserSaveResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        Collection<SimpleGrantedAuthority> authoritys = new ArrayList<>();
        if (user == null) {
            throw new UsernameNotFoundException("username null");
        } else {
            if (user.getActive()) {
                authoritys.add(new SimpleGrantedAuthority(user.getRoles()));
            } else {
                throw new UsernameNotFoundException("username not Active");
            }

        }

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authoritys);
    }

    @Override
    public BaseResponse<List<UserDetailResponse>> getUsers() throws JsonProcessingException {
        BaseResponse<List<UserDetailResponse>> responses = new BaseResponse<>();
        List<UserDetailResponse> detailResponses = new ArrayList<>();
        List<User> users = userRepository.findAll();
        if (users != null) {
            for (User user : users) {
                if (user.getActive()) {
                    UserDetailResponse detailResponse = new UserDetailResponse();
                    
                    detailResponse.setActive(user.getActive());
                    detailResponse.setAddress(user.getAddress());
                    detailResponse.setEmail(user.getEmail());
                    detailResponse.setGender(user.getGender());
                    detailResponse.setIc(user.getIc());
                    detailResponse.setId(user.getId());
                    detailResponse.setName(user.getName());
                    detailResponse.setPhone(user.getPhone());
                    detailResponses.add(detailResponse);
                }
            }
            responses.setStatus(true);
            responses.setPayload(detailResponses);
        } else {
            responses.setStatus(false);
            responses.setPayload(detailResponses);
        }
        return responses;
    }

    @Override
    public BaseResponse<UserSaveResponse> saveUser(UserSaveRequest request) {
        BaseResponse<UserSaveResponse> response = new BaseResponse<>();
        UserSaveResponse detailResponse = new UserSaveResponse();
        User user = new User();
        user.setActive(Boolean.TRUE);
        user.setAddress(request.getAddress());
        user.setEmail(request.getEmail());
        user.setGender(request.getGender());
        user.setIc(request.getIc());
        user.setName(request.getName());
        user.setPassword(request.getPassword());
        user.setPhone(request.getPhone());
        user.setRoles(request.getRole());
        userRepository.save(user);

        detailResponse.setActive(Boolean.TRUE);
        detailResponse.setAddress(request.getAddress());
        detailResponse.setEmail(request.getEmail());
        detailResponse.setGender(request.getGender());
        detailResponse.setIc(request.getIc());
        detailResponse.setName(request.getName());
        detailResponse.setPhone(request.getPhone());
        
        response.setStatus(true);
        response.setPayload(detailResponse);
        return response;
    }

    @Override
    public BaseResponse<UserDetailResponse> deleteUser(UserIdRequest request) {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        UserDetailResponse detailResponse = new UserDetailResponse();
        Optional<User> optional = userRepository.findById(request.getId());
        if (optional != null) {
            if (optional.get().getActive()) {
                User user = new User();
                user.setActive(Boolean.FALSE);
                user.setAddress(optional.get().getAddress());
                user.setEmail(optional.get().getEmail());
                user.setGender(optional.get().getGender());
                user.setIc(optional.get().getIc());
                user.setId(optional.get().getId());
                user.setName(optional.get().getName());
                user.setPassword(optional.get().getPassword());
                user.setPhone(optional.get().getPhone());
                user.setRoles(optional.get().getRoles());
                userRepository.save(user);

                detailResponse.setActive(optional.get().getActive());
                detailResponse.setAddress(optional.get().getAddress());
                detailResponse.setEmail(optional.get().getEmail());
                detailResponse.setGender(optional.get().getGender());
                detailResponse.setIc(optional.get().getIc());
                detailResponse.setName(optional.get().getName());
                detailResponse.setPhone(optional.get().getPhone());

            }
            response.setStatus(true);
            response.setPayload(detailResponse);
        } else {
            response.setStatus(false);
        }
        return response;
    }

    @Override
    public BaseResponse<UserDetailResponse> getUser(Long request) {
        BaseResponse<UserDetailResponse> response = new BaseResponse<>();
        UserDetailResponse detailResponse = new UserDetailResponse();
        Optional<User> optional = userRepository.findById(request);
        if (optional != null) {
            if (optional.get().getActive()) {
                
                detailResponse.setActive(optional.get().getActive());
                detailResponse.setAddress(optional.get().getAddress());
                detailResponse.setEmail(optional.get().getEmail());
                detailResponse.setGender(optional.get().getGender());
                detailResponse.setIc(optional.get().getIc());
                detailResponse.setId(optional.get().getId());
                detailResponse.setName(optional.get().getName());
                detailResponse.setPhone(optional.get().getPhone());

            }
            response.setStatus(true);
            response.setPayload(detailResponse);
        } else {
            response.setStatus(false);
        }
        return response;
    }

    @Override
    public String getName(String email) {
        User user = new User();
        user = userRepository.findByEmail(email);
        return user.getName();
    }

}
