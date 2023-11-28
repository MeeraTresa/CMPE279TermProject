package cmpe279.project.security.resource;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.context.annotation.Role;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manage")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManagerController {
    @GetMapping()
    @RolesAllowed("MANAGER")
    @PreAuthorize("hasAuthority('MANAGER')")
    public String manager() {
        return "<h1>Welcome Manager</h1>";
    }
}
