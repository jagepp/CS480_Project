package weapon.service;

import java.util.List;

import character.dao.CharacterDao;
import character.domain.PCharacter;
import weapon.dao.WeaponDao;
import weapon.domain.Weapon;


public class WeaponService {
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
	
	private WeaponDao weaponDao = new WeaponDao();
	
	public void addWeapon(Weapon form)throws WeaponException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		weaponDao.add(form);
	}
	
	public void updateWeapon(Weapon form)throws WeaponException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		weaponDao.update(form);
	}
	
	public void deleteWeapon(Weapon form)throws WeaponException, ClassNotFoundException, InstantiationException, IllegalAccessException{
		weaponDao.deleteCharacter(form.getId());
	}
	public List<Object> findall() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return weaponDao.findall();
		
	}
}
