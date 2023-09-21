package io.bootify.my_app.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.bootify.my_app.domain.User;
import io.bootify.my_app.repos.UserRepository;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class HomeController {
	
	@Autowired
	UserRepository userRepository;

    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }
    
   
    
    @GetMapping("/users")
    public ResponseEntity<Page<User>> getUsers(
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size,
      @RequestParam(required = false) String firstName,
      @RequestParam(required = false) String lastName,
      @RequestParam(required = false) String email) {
        
        Pageable paging = PageRequest.of(page, size);
        Specification<User> spec = Specification.where(null);
        
        if (firstName != null) {
          spec = spec.and(UserSpecifications.hasFirstNameOrLastName(firstName));
        }
        if (lastName != null) {
          spec = spec.and(UserSpecifications.hasLastName(lastName));
        }
        if (email != null) {
          spec = spec.and(UserSpecifications.hasEmail(email));
        }
        
        Page<User> pageResult = userRepository.findAll(spec, paging);
        
        return ResponseEntity.ok(pageResult);
    }


}
