package cmpe279.project.security.resource;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    @GetMapping()
    @RolesAllowed("ADMIN")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String admin() {
        return "<h1>Welcome Admin</h1>";
    }
}
