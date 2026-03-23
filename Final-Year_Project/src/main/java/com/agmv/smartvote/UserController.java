package com.agmv.smartvote;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserRepository repo;

    // signup
    @PostMapping("/signup")
    public User signup(@RequestBody User users) {
        users.setVoted(false );
        return repo.save(users);
    }

    // vote
    @PostMapping("/vote")
    public String vote(@RequestParam String email) {
        User user = repo.findByEmail(email);

        if (user == null) return "User not found";

        if (user.isVoted()) {
            return "You already voted ❌";
        }

        user.setVoted(true);
        repo.save(user);

        return "Vote successful ✅";
    }
}