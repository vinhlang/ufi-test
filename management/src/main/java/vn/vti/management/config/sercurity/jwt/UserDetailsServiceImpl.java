package vn.vti.management.config.sercurity.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.vti.management.repository.AccessInfoRepository;
import vn.vti.management.entity.AccessInfo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private AccessInfoRepository accessInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccessInfo user = accessInfoRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        return new CustomUserDetails(user);
    }
}