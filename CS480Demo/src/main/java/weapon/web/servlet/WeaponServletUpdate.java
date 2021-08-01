package weapon.web.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import character.domain.PCharacter;
import character.service.CharacterException;
import character.service.CharacterService;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;
import weapon.domain.Weapon;
import weapon.service.WeaponException;
import weapon.service.WeaponService;

/**
 * Servlet implementation class UserServlet
 */

public class WeaponServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeaponServletUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Map<String, String> form = new HashMap<String,String>();
		WeaponService weaponservice = new WeaponService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Weapon form = new Weapon();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setWeaponName(info.get(1));
		form.setLightLevel(Integer.valueOf(info.get(2)));
		form.setWeaponType(info.get(3));
		form.setRarity(info.get(4));
		form.setSlot(info.get(5));
		form.setId(Integer.valueOf(info.get(6)));
		
		try {
			weaponservice.updateWeapon(form);

			request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
		} catch (ClassNotFoundException | WeaponException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
