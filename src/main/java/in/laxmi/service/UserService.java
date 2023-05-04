package in.laxmi.service;

import in.laxmi.binding.RegisterForm;

public interface UserService {
public boolean saveUser(RegisterForm form);
public boolean getUser(RegisterForm form);
}
