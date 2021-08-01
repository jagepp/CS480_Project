package armor.web.servlet;

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
import armor.domain.Armor;
import armor.service.ArmorException;
import armor.service.ArmorService;

/**
 * Servlet implementation class UserServlet
 */

public class ArmorServletRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArmorServletRegister() {
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
		ArmorService armorservice = new ArmorService();
		Map<String,String[]> paramMap = request.getParameterMap();
		Armor form = new Armor();
		List<String> info = new ArrayList<String>();
		
		for(String name : paramMap.keySet()) {
			
			String[] values = paramMap.get(name);
			info.add(values[0]);
			System.out.println(name + ": " + Arrays.toString(values));
		}
		form.setArmorName(info.get(1));
		form.setLightLevel(Integer.valueOf(info.get(2)));
		form.setArmorType(info.get(3));
		form.setRarity(info.get(4));
		form.setSlot(info.get(5));
		
		try {
			armorservice.addArmor(form);

			request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
		} catch (ClassNotFoundException | ArmorException e) {
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
