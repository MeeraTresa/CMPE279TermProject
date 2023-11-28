package cmpe279.project.security.resource;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/member")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MemberController {
    @GetMapping()
    @RolesAllowed("MEMBER")
    @PreAuthorize("hasAuthority('MEMBER')")
    public String user(Principal principal) {
        Authentication authentication = (Authentication) principal;
        List<GrantedAuthority> authorities = new ArrayList<>(authentication.getAuthorities());

        // Log the roles for debugging
        System.out.println("User roles: " + authorities);
        return "<h1>Welcome Dear Member</h1>";
    }
}
