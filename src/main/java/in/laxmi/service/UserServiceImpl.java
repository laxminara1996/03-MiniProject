package in.laxmi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.laxmi.binding.RegisterForm;
import in.laxmi.constants.AppConfigConstants;
import in.laxmi.entity.User;
import in.laxmi.repo.UserEntityRepository;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
    private UserEntityRepository userRepo;
	@Override
	public boolean saveUser(RegisterForm form) {
		// TODO Auto-generated method stub
		User entity = new User();
		BeanUtils.copyProperties(form, entity);
		entity.setFname(form.getFname());
		entity.setLname(form.getLname());
		entity.setEmail(form.getEmail());
		entity.setPwd(form.getPwd());
		userRepo.save(entity);
		return true;
	}
	@Override
	public boolean getUser(RegisterForm form) {
		// TODO Auto-generated method stub
		User entity = userRepo.findByEmailAndPwd(form.getEmail(), form.getPwd());
		if(entity==null) {
			return false;
		}else {
			return true;
		}
	}

}
