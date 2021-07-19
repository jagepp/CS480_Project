package character.web.servlet;

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

import character.dao.CharacterDao;
import character.domain.PCharacter;
import character.service.CharacterException;
import character.service.CharacterService;
import user.dao.UserDao;
import user.domain.User;
import user.service.UserException;
import user.service.UserService;

/**
 * Servlet implementation class UserServlet
 */

public class CharacterServletDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharacterServletDelete() {
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
		CharacterDao chardao = new CharacterDao();
		PCharacter pchar = null;
		try {
			pchar = chardao.findByID(Integer.parseInt(request.getParameter("id")));
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		CharacterService characterservice = new CharacterService();	
		if(pchar !=null){
			try {
				characterservice.deleteCharacter(pchar);
				
				request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
			} catch (ClassNotFoundException | CharacterException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				request.setAttribute("msg", e.getMessage());
			} 
		}
		else{
			request.setAttribute("msg", "Could not find that character ID ");
			request.getRequestDispatcher("/jsps/main.jsp").forward(request, response);
		}
		
		
		
	}

}
