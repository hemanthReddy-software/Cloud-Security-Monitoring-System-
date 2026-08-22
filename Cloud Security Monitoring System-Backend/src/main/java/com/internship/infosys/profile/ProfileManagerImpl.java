//package com.internship.infosys.profile;
//
//import java.time.LocalDateTime;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.internship.infosys.model.User;
//import com.internship.infosys.repositary.UserRepository;
//
//@Service
//@Transactional
//public class ProfileManagerImpl
//        implements ProfileManager {
//
//    private final ProfileRepository profileRepository;
//
//    private final UserRepository userRepository;
//
//    private final PasswordEncoder passwordEncoder;
//
//    public ProfileManagerImpl(
//            ProfileRepository profileRepository,
//            UserRepository userRepository,
//            PasswordEncoder passwordEncoder
//    ) {
//        this.profileRepository =
//                profileRepository;
//
//        this.userRepository =
//                userRepository;
//
//        this.passwordEncoder =
//                passwordEncoder;
//    }
//
//    // =====================================================
//    // FIND USER
//    // =====================================================
//
//    private User findUser(
//            String username
//    ) {
//
//        return userRepository
//                .findByUsername(username)
//                .orElseThrow(
//                        () ->
//                                new RuntimeException(
//                                        "User not found"
//                                )
//                );
//    }
//
//    // =====================================================
//    // GET OR CREATE PROFILE
//    // =====================================================
//
//    private ProfileEntity getOrCreateProfile(
//            User user
//    ) {
//
//        return profileRepository
//                .findByUserId(user.getId())
//                .orElseGet(() -> {
//
//                    ProfileEntity profile =
//                            new ProfileEntity();
//
//                    profile.setUser(user);
//
//                    profile.setEmployeeId(
//                            "EMP-" + user.getId()
//                    );
//
//                    profile.setName(
//                            user.getUsername()
//                    );
//
//                    profile.setJoinedDate(
//                            LocalDateTime.now()
//                    );
//
//                    profile.setStatus(
//                            "Active"
//                    );
//
//                    return profileRepository.save(
//                            profile
//                    );
//                });
//    }
//
//    // =====================================================
//    // GET PROFILE
//    // =====================================================
//
//    @Override
//    public ProfileResponseDto getProfile(
//            String username
//    ) {
//
//        User user =
//                findUser(username);
//
//        ProfileEntity profile =
//                getOrCreateProfile(user);
//
//        return convertToResponse(
//                user,
//                profile
//        );
//    }
//
//    // =====================================================
//    // UPDATE PROFILE
//    // =====================================================
//
//    @Override
//    public ProfileResponseDto updateProfile(
//            String username,
//            ProfileUpdateDto request
//    ) {
//
//        User user =
//                findUser(username);
//
//        String newEmail =
//                request.getEmail()
//                        .trim()
//                        .toLowerCase();
//
//        /*
//         * Email remains in the existing users table.
//         */
//
//        userRepository
//                .findByEmail(newEmail)
//                .ifPresent(existing -> {
//
//                    if (!existing.getId()
//                            .equals(user.getId())) {
//
//                        throw new IllegalArgumentException(
//                                "Email already exists"
//                        );
//                    }
//                });
//
//        user.setEmail(newEmail);
//
//        userRepository.save(user);
//
//        /*
//         * Profile fields are stored separately.
//         */
//
//        ProfileEntity profile =
//                getOrCreateProfile(user);
//
//        profile.setName(
//                request.getName().trim()
//        );
//
//        profile.setPhone(
//                emptyIfNull(
//                        request.getPhone()
//                )
//        );
//
//        profile.setDepartment(
//                emptyIfNull(
//                        request.getDepartment()
//                )
//        );
//
//        profile.setDesignation(
//                emptyIfNull(
//                        request.getDesignation()
//                )
//        );
//
//        profile.setAddress(
//                emptyIfNull(
//                        request.getAddress()
//                )
//        );
//
//        profile.setBio(
//                emptyIfNull(
//                        request.getBio()
//                )
//        );
//
//        profile.setAvatar(
//                emptyIfNull(
//                        request.getAvatar()
//                )
//        );
//
//        if (profile.getStatus() == null) {
//            profile.setStatus("Active");
//        }
//
//        ProfileEntity saved =
//                profileRepository.save(
//                        profile
//                );
//
//        return convertToResponse(
//                user,
//                saved
//        );
//    }
//
//    // =====================================================
//    // CHANGE PASSWORD
//    // =====================================================
//
//    @Override
//    public void changePassword(
//            String username,
//            PasswordChangeDto request
//    ) {
//
//        User user =
//                findUser(username);
//
//        if (!passwordEncoder.matches(
//                request.getCurrentPassword(),
//                user.getPassword()
//        )) {
//
//            throw new IllegalArgumentException(
//                    "Current password is incorrect"
//            );
//        }
//
//        if (!request.getNewPassword()
//                .equals(
//                        request.getConfirmPassword()
//                )) {
//
//            throw new IllegalArgumentException(
//                    "Passwords do not match"
//            );
//        }
//
//        user.setPassword(
//                passwordEncoder.encode(
//                        request.getNewPassword()
//                )
//        );
//
//        userRepository.save(user);
//    }
//
//    // =====================================================
//    // RESPONSE MAPPER
//    // =====================================================
//
//    private ProfileResponseDto convertToResponse(
//            User user,
//            ProfileEntity profile
//    ) {
//
//        ProfileResponseDto response =
//                new ProfileResponseDto();
//
//        response.setId(
//                profile.getId()
//        );
//
//        response.setUserId(
//                user.getId()
//        );
//
//        response.setEmployeeId(
//                profile.getEmployeeId()
//        );
//
//        response.setName(
//                profile.getName()
//        );
//
//        response.setUsername(
//                user.getUsername()
//        );
//
//        response.setEmail(
//                user.getEmail()
//        );
//
//        response.setPhone(
//                profile.getPhone()
//        );
//
//        response.setDepartment(
//                profile.getDepartment()
//        );
//
//        response.setDesignation(
//                profile.getDesignation()
//        );
//
//        response.setRole(
//                user.getRole().toString()
//        );
//
//        response.setJoinedDate(
//                profile.getJoinedDate()
//        );
//
//        response.setLastLogin(
//                profile.getLastLogin()
//        );
//
//        response.setAddress(
//                profile.getAddress()
//        );
//
//        response.setBio(
//                profile.getBio()
//        );
//
//        response.setAvatar(
//                profile.getAvatar()
//        );
//
//        response.setStatus(
//                profile.getStatus()
//        );
//
//        return response;
//    }
//
//    private String emptyIfNull(
//            String value
//    ) {
//
//        return value == null
//                ? ""
//                : value.trim();
//    }
//}