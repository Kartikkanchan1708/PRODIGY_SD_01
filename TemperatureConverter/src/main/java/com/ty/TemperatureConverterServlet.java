	package com.ty;
	
	import java.io.IOException;
	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	
	@WebServlet("/TemperatureConverterServlet")
	public class TemperatureConverterServlet extends HttpServlet {
	    private static final long serialVersionUID = 1L;
	
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        // Get temperature and unit from the request
	        double temperature = Double.parseDouble(request.getParameter("temperature"));
	        String unit = request.getParameter("unit");
	
	        String celsiusResult = null;
	        String fahrenheitResult = null;
	        String kelvinResult = null;
	
	        // Perform conversion logic based on input unit
	        if ("celsius".equals(unit)) {
	        
	            fahrenheitResult = String.format("%.2f°C = %.2f°F", temperature, celsiusToFahrenheit(temperature));
	            kelvinResult = String.format("%.2f°C = %.2fK", temperature, celsiusToKelvin(temperature));
	        } else if ("fahrenheit".equals(unit)) {
	        
	            celsiusResult = String.format("%.2f°F = %.2f°C", temperature, fahrenheitToCelsius(temperature));
	            kelvinResult = String.format("%.2f°F = %.2fK", temperature, fahrenheitToKelvin(temperature));
	        } else if ("kelvin".equals(unit)) {
	         
	            celsiusResult = String.format("%.2fK = %.2f°C", temperature, kelvinToCelsius(temperature));
	            fahrenheitResult = String.format("%.2fK = %.2f°F", temperature, kelvinToFahrenheit(temperature));
	        }
	
	        // Set the converted results as request attributes
	        request.setAttribute("celsiusResult", celsiusResult);
	        request.setAttribute("fahrenheitResult", fahrenheitResult);
	        request.setAttribute("kelvinResult", kelvinResult);
	
	        // Forward the request back to the JSP page
	        request.getRequestDispatcher("index.jsp").forward(request, response);
	    }
	
	    // Conversion methods
	    private double celsiusToFahrenheit(double celsius) {
	        return (celsius * 9 / 5) + 32;
	    }
	
	    private double celsiusToKelvin(double celsius) {
	        return celsius + 273.15;
	    }
	
	    private double fahrenheitToCelsius(double fahrenheit) {
	        return (fahrenheit - 32) * 5 / 9;
	    }
	
	    private double fahrenheitToKelvin(double fahrenheit) {
	        return (fahrenheit - 32) * 5 / 9 + 273.15;
	    }
	
	    private double kelvinToCelsius(double kelvin) {
	        return kelvin - 273.15;
	    }
	
	    private double kelvinToFahrenheit(double kelvin) {
	        return (kelvin - 273.15) * 9 / 5 + 32;
	    }
	}
