package com.june.blog.test;

import com.june.blog.model.RoleType;
import com.june.blog.model.User;
import com.june.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    // http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/user")
    public List<User> list() {
        return userRepository.findAll();
    }

    // http://localhost:8000/blog/dummy/user?page=0
    @GetMapping("/dummy/user/page")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        List<User> users = userRepository.findAll(pageable).getContent();
        return users;
    }

    // {id} 주소로 파라미터를 전달받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable int id) {
        User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
            @Override
            public IllegalArgumentException get() {
                return new IllegalArgumentException(id + "번 유저가 존재하지 않습니다.");
            }
        });
        return user;
    }

//    @GetMapping("/dummy/user/{id}")
//    public User detail(@PathVariable int id) {
//        User user = userRepository.findById(id).orElseThrow(() -> {
//           return new IllegalArgumentException("해당 사용자는 없습니다.");
//        });
//        return user;
//    }

    // http://localhost:8000/blog/dummy/join
//    @PostMapping("/dummy/join")
//    public String join(String username, String password, String email) {
//        System.out.println("username = " + username);
//        System.out.println("password = " + password);
//        System.out.println("email = " + email);
//        return "회원가입이 완료되었습니다.";
//    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("id = " + user.getId());
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());
        System.out.println("role = " + user.getRole());
        System.out.println("createDate = " + user.getCreateDate());

        user.setRole(RoleType.USER);
        userRepository.save(user);

        return "회원가입이 완료되었습니다.";
    }
}
