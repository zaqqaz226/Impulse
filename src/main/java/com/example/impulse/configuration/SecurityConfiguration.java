package com.example.impulse.configuration;

import com.example.impulse.entities.users.User;
import com.example.impulse.repository.RoleRepository;
import com.example.impulse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;
import java.util.stream.Collectors;


@EnableWebSecurity
@Configuration
public class SecurityConfiguration {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public SecurityConfiguration(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                (rq) -> rq.requestMatchers("/", "/home").permitAll()
                        .anyRequest().authenticated())
                .formLogin((from) -> from.loginPage("/login")
                .permitAll())
                .authorizeHttpRequests(
                        (rq)-> rq.requestMatchers("/auth-page")
                                .hasRole("ADMIN"))
                .formLogin((from)-> from.loginPage("/login"))
               // .logout((logout) -> logout.permitAll()
                .logout().logoutSuccessUrl("/");

        return http.build();
    }

    @Bean
    public JdbcUserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public UserDetailsService userDetailsService(@Value("user") String userName) {

        UserDetails userDetails = loadUserByUserName(userName);

        return new InMemoryUserDetailsManager(userDetails);
    }

    public UserDetails loadUserByUserName(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(userName).orElseThrow(
                () -> new UsernameNotFoundException("User with name %s not found".formatted(userName))
        );

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                user.getRoles().stream()
                        .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList())
        );
    }

}
