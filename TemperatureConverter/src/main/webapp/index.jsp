<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Temperature Converter</title>
   
</head>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    .container {
        background-color: #fff;
        padding: 40px;
        border-radius: 10px;
        box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
        width: 350px;
        text-align: center;
    }

    h1 {
        font-size: 28px;
    }

    input, select, button {
        width: 100%;
        padding: 10px;
        margin: 10px 0;
    }

    button {
        background-color: #007bff;
        color: white;
        border: none;
        cursor: pointer;
    }

</style>
<body>
    <div class="container">
        <h1>Temperature Converter</h1>

        <!-- Form to submit temperature -->
        <form action="TemperatureConverterServlet" method="post">
            <div class="input-section">
                <label for="temperature">Enter Temperature:</label>
                <input type="number" id="temperature" name="temperature" placeholder="Enter value" required>

                <label for="unit">Select Unit:</label>
                <select id="unit" name="unit" required>
                    <option value="celsius">Celsius</option>
                    <option value="fahrenheit">Fahrenheit</option>
                    <option value="kelvin">Kelvin</option>
                </select>

                <button type="submit">Convert</button>
            </div>
        </form>

        <!-- Display conversion results -->
        <div class="result-section">
            <h2>Converted Temperatures:</h2>
            <%
                // Retrieve conversion results set by the servlet
                String celsiusResult = (String) request.getAttribute("celsiusResult");
                String fahrenheitResult = (String) request.getAttribute("fahrenheitResult");
                String kelvinResult = (String) request.getAttribute("kelvinResult");

                // Display the conversion results based on the input unit
                if (fahrenheitResult != null) {
            %>
                <p><strong>Fahrenheit: </strong><%= fahrenheitResult %></p>
            <%
                }
                if (kelvinResult != null) {
            %>
                <p><strong>Kelvin: </strong><%= kelvinResult %></p>
            <%
                }
                if (celsiusResult != null) {
            %>
                <p><strong>Celsius: </strong><%= celsiusResult %></p>
            <%
                }
                if (celsiusResult == null && fahrenheitResult == null && kelvinResult == null) {
            %>
                <p>Enter a temperature and select a unit to convert.</p>
            <%
                }
            %>
        </div>
    </div>
</body>
</html>