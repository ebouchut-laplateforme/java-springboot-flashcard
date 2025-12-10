package com.ericbouchut.java.springboot.flashcard.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {}

//@Service
//public class AuthenticationService implement UserDetailsService {
//        private final UserRepository userRepository;
//
//        public AuthenticationService(UserRepository userRepository) {
//            this.userRepository = userRepository:
//        }
//
//        @Override
//        public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//            Optional<User> user = userRepository.findUserByMail(email);
//
//            if (user.isPresent()) {
//                return new org.springframework.security.core.userdetails.User(
//                        user.get().getEmail(),
//                        user.get().getPassword()
//                );
//            }
//            throw new UsernameNotFoundException(s);
//        }
//}
