package armor.service;

import java.util.List;

import armor.dao.ArmorDao;
import armor.domain.Armor;


public class ArmorService {
	/*
	private UserDao userDao = new UserDao();
	
	public void regist(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		
		// check the user name
		User user = userDao.findByUsername(form.getUsername());
		if(user.getUsername()!=null && user.getUsername().equals(form.getUsername())) throw new UserException("This user name has been registered!");
		userDao.add(form);
	}
	
	public void login(User form) throws UserException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		User user = userDao.findByUsername(form.getUsername());
		if(user.getUsername()==null) throw new UserException("The user is not in the database");
		
		String password = user.getPassword();
		
		if(password!=null && !password.equals(form.getPassword()))
			throw new UserException(" The password is not right");
		
	}
	
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return userDao.findall();
		
	}
	*/
	
	private ArmorDao armorDao = new ArmorDao();
	
	public void addArmor(Armor form)throws ArmorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		armorDao.add(form);
	}
	
	public void updateArmor(Armor form)throws ArmorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		armorDao.update(form);
	}
	
	public void deleteArmor(Armor form)throws ArmorException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		armorDao.deleteCharacter(form.getId());
	}
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return armorDao.findall();
		
	}
}
