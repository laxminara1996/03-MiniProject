package in.laxmi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.laxmi.entity.User;

public interface UserEntityRepository extends JpaRepository<User, Integer>{
public User findByEmailAndPwd(String email,String pwd);
}
