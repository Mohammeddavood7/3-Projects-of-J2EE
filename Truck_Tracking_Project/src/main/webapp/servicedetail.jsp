<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
 import="java.util.*,truck.BeanOfTruck"
%>
<!DOCTYPE html>
<html>
<head>
  <title>Truck Tracking Company</title>
  <style>
    body {
      font-family: 'Roboto', sans-serif;
      background-color: #e0e7ff; /* Light blue background */
      color: #333; /* Darker text for better readability */
      margin: 0;
      padding: 0;
      text-align: center; /* Add this to center all content */
    }

  .container {
      width: 80%;
      margin: 40px auto;
      background-color: #ffffff; /* White background for the container */
      padding: 20px;
      box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
      border-radius: 8px;
    }

    header {
      background-color: #1e3a8a; /* Dark blue background for header */
      color: #ffffff; /* White text */
      padding: 10px 20px;
      border-radius: 8px 8px 0 0;
      text-align: center;
    }

    nav {
      background-color: #1e3a8a; /* Dark blue background for nav */
      padding: 10px 20px;
      border-radius: 0 0 8px 8px;
      text-align: center; /* Add this to center nav links */
    }

    nav ul {
      list-style: none;
      padding: 0;
      display: flex;
      justify-content: space-around;
      margin: 0 auto;
      width: 60%;
    }

    nav a {
      color: #ffffff;
      text-decoration: none;
    }

    nav a:hover {
      color: #cccccc;
    }

    h1 {
      text-align: center;
      margin-bottom: 20px;
    }

    form {
      margin-top: 20px;
    }

    label {
      display: block;
      margin-bottom: 5px;
    }

    input[type="text"], input[type="number"] {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    select {
      width: 100%;
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 4px;
      box-sizing: border-box;
    }

    button {
      background-color: #4CAF50;
      color: white;
      padding: 10px 20px;
      margin-top: 10px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #45a049;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    th, td {
      text-align: left;
      padding: 8px;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #f0f0f0;
    }

    footer {
      background-color: #333;
      color: #fff;
      padding: 10px 0;
      text-align: center;
    }

  .services {
      background-color:#e0e7ff;
      color:  #1e3a8a;
      padding: 10px 0;
      margin-top: 20px;
      text-align: center;
    }

  .services ul {
      list-style-type: none;
      padding: 0;
      margin: 0;
    }

  .services li {
      padding: 5px 0;
    }

  .image-grid {
      display: grid;
      grid-template-columns: repeat(3, 1fr);
      grid-gap: 10px;
      margin-top: 20px;
      justify-content: center; /* Add this to center image grid */
    }

  .image-grid img {
      width: 100%;
    }
  .services {
  height: 200px;
  overflow-y: auto;
}

.service-list {
  list-style: none;
  padding: 0;
  margin: 0;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.service-list li {
  width: 31%;
  margin: 10px 1%;
  text-align: center;
}

.service-list i {
  font-size: 24px;
  color: white;
  margin-bottom: 10px;
}

.service-list h4 {
  font-weight: bold;
  margin-bottom: 10px;
  font-size: 16px;
}

.service-list p {
  font-size: 14px;
  color:white;
}
  </style>
</head>
<body>
  <header>
    <h1>Most Convenient And Reliable Transport Services</h1>
  </header>
  <nav>
    <ul>
      <li><a href="#">Home</a></li>
      <li><a href="#">Recently Installed Trucks</a></li>
      <li><a href="#">Status</a></li>
      <li><a href="#">Towards Here</a></li>
      <li><a href="#">Services</a></li>
      <li><a href="#">Contact Us</a></li>
      <li><a href="#">Logout</a></li>
    </ul>
  </nav>
  <div class="container">
    <h2>Welcome to Our Truck Tracking Company</h2>
    <p>Click here for details</p>
    <%
         @SuppressWarnings("unchecked")
         ArrayList<BeanOfTruck> service = (ArrayList<BeanOfTruck>) request.getAttribute("bean");
    		
    %>
    <table>
      <thead>
        <tr>
          <th>Model</th>
          <th>Truck No.</th>
          <th>Owner</th>
          <th>Mobile</th>
          <th>Insurance</th>
        </tr>
      </thead>
      <tbody>
       <%for (int i = 0 ; i < service.size(); i++)
           {
        	BeanOfTruck bean = service.get(i);
        	%>   
        <tr>
          <td><%= bean.getTruckModel()%></td>
          <td><%= bean.getTruckNO()%></td>
          <td><%= bean.getOnwer()%></td>
          <td><%= bean.getMobile()%></td>
          <td><%= bean.getInsurance()%></td>
        </tr>
        <%} %>
        
      </tbody>
    </table>
    <pre>
    
    
    
    
    
    
    
 
    </pre>
  <footer>
    <p>&copy; 2023 Truck Tracking Company. All rights reserved.</p>
  </footer>
</body>
</html>