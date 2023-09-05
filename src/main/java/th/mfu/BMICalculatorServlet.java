package th.mfu;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//TODO: add webservlet to "/calbmi"
@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String weight = request.getParameter("weight");
        String height = request.getParameter("height");
        Double w=Double.parseDouble(weight);  
        Double h=Double.parseDouble(height);  
        
    

        //TODO: calculate bmi
        double BMI= w / (h * h);
        int roundbmi = (int)Math.round(BMI);
       

        //TODO: determine the built from BMI
        String showbmi="";
        if(BMI < 18.5)
      showbmi="underweight";
      else if(BMI < 25)
      showbmi="normal";
      else if(BMI < 30)
      showbmi="overweight";
    else
    showbmi="extremely obese";
    
       //TODO: add bmi and built to the request's attribute
       request.setAttribute("bmi", roundbmi);
       request.setAttribute("built", showbmi);

       //TODO: forward to jsp
       request.getRequestDispatcher("bmi_result.jsp").forward(request, response);

  } 

       
           
    }
    

