package vn.vti.management.config.sercurity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;
import vn.vti.management.config.sercurity.jwt.JwtTokenProvider;
import vn.vti.management.entity.AccessInfo;
import vn.vti.management.service.AccessInfoService;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AccessInfoService accessInfoService;

    @Override
    public void doFilterInternal(HttpServletRequest  request,
                                 HttpServletResponse response, FilterChain filterChain)
        throws ServletException, IOException {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String jwt = getJwtFromRequest(httpRequest);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                //get userId
                Long userId = tokenProvider.getUserIdFromJWT(jwt);

                AccessInfo accessInfo = accessInfoService.loadUserById(userId);

                if(accessInfo != null) {

                    UsernamePasswordAuthenticationToken
                        authentication = new UsernamePasswordAuthenticationToken(accessInfo, null, getAuthorities());
                    authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpRequest));

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }
        } catch (Exception ex) {
            log.error("failed on set user authentication", ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {

        String bearerToken = request.getHeader("Authorization");

        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        // default 1 role user, custom after
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

}
