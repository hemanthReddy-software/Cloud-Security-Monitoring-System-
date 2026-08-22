//package com.internship.infosys.profile;
//
//import java.util.Map;
//
//import jakarta.validation.Valid;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.web.bind.annotation.*;
//
//import com.internship.infosys.profile.PasswordChangeDto;
//import com.internship.infosys.profile.ProfileManager;
//import com.internship.infosys.profile.ProfileResponseDto;
//import com.internship.infosys.profile.ProfileUpdateDto;
//
//@RestController
//@RequestMapping("/api/profile-data")
//public class ProfileController {
//
//    private final ProfileManager profileManager;
//
//    public ProfileController(
//            ProfileManager profileManager
//    ) {
//        this.profileManager =
//                profileManager;
//    }
//
//    // =====================================================
//    // GET PROFILE
//    // =====================================================
//
//    @GetMapping
//    public ResponseEntity<ProfileResponseDto>
//    getProfile(
//            Authentication authentication
//    ) {
//
//        ProfileResponseDto response =
//                profileManager.getProfile(
//                        authentication.getName()
//                );
//
//        return ResponseEntity.ok(
//                response
//        );
//    }
//
//    // =====================================================
//    // UPDATE PROFILE
//    // =====================================================
//
//    @PutMapping
//    public ResponseEntity<ProfileResponseDto>
//    updateProfile(
//
//            Authentication authentication,
//
//            @Valid
//            @RequestBody
//            ProfileUpdateDto request
//
//    ) {
//
//        ProfileResponseDto response =
//                profileManager.updateProfile(
//                        authentication.getName(),
//                        request
//                );
//
//        return ResponseEntity.ok(
//                response
//        );
//    }
//
//    // =====================================================
//    // CHANGE PASSWORD
//    // =====================================================
//
//    @PutMapping("/password")
//    public ResponseEntity<Map<String, String>>
//    changePassword(
//
//            Authentication authentication,
//
//            @Valid
//            @RequestBody
//            PasswordChangeDto request
//
//    ) {
//
//        profileManager.changePassword(
//                authentication.getName(),
//                request
//        );
//
//        return ResponseEntity.ok(
//                Map.of(
//                        "message",
//                        "Password changed successfully"
//                )
//        );
//    }
//}