package com.precisionbio.restfulwebservices.user;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 * [description]
 *
 * @author miniyus
 * @date 2023/08/27
 */
@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public void deleteById(int id) {
        userRepository.deleteById(id);
    }

    public List<Post> findPostForUser(int id) {
        User user = userRepository.findById(id).get();
        if (user == null) {
            throw new UserNotFoundException("id: " + id);
        }

        return user.getPosts();
    }
}
