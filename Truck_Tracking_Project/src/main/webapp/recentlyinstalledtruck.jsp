<%@ page import="java.util.*,truck.BeanOfTruck,java.util.ArrayList,java.time.*,java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Truck Tracking Company</title>
<style>
    body {
        font-family: 'Roboto', sans-serif;
        background-color: #e0e7ff; /* Light blue background */
        color: #333; /* Darker text for better readability */
        margin: 0;
        padding: 0;
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
    }

    nav ul {
        list-style: none;
        padding: 0;
        display: flex;
        justify-content: space-around;
        margin: 0 auto;
        width: 60%;
    }

    nav ul li {
        display: inline;
    }

    nav ul li a {
        color: #ffffff; /* White text */
        text-decoration: none;
        font-weight: 500;
        padding: 8px 16px;
        border-radius: 4px;
        transition: background-color 0.3s ease;
    }

    nav ul li a:hover {
        background-color: #16326a; /* Darker blue on hover */
    }

.result {
        margin-top: 20px;
        font-size: 1.2em;
        font-weight: 500;
        color: #1e3a8a;
        text-align: center;
    }

.result.success {
        color: #2ecc71; /* Green text for success */
    }

.result.error {
        color: #e74c3c; /* Red text for error */
    }

.table-container {
        display: flex;
        justify-content: center;
        margin-top: 20px;
    }

  table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
    }

  th, td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
    }

  th {
        background-color: #f0f0f0;
    }
</style>
</head>
<body>
    <div class="container">
        <header>
               <%
                  LocalDate date =LocalDate.now(); 
                
               %>
            <h1>WELCOME TO OUR TRUCK TRACKING COMPANY</h1>
            <h5><%= "Previous Month Date And Today Date( " +date+ " ) In Between Installed Trucks" %></h5>
        </header>
         <nav>
                <ul>
                    <li><a href="homepage.html">Home</a></li>
                    <li><a href="recentlytrucks">Recently Installed Trucks</a></li>
                    <li><a href="status.jsp">Status</a></li>
                    <li><a href="towardshere.jsp">Towards Here</a></li>
                    <li><a href="service.jsp">Services</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                </ul>
            </nav>
<!--         <p style='text-align:center;'>Delhi-Kanpur, Agra-Kanpur, Agra-Ghaziabad</p>
 -->        
           <%
               @SuppressWarnings("unchecked")
               ArrayList<BeanOfTruck> bean = (ArrayList<BeanOfTruck>)session.getAttribute("recentlyInstalledTrucks");
           %> 
 
          <div class="table-container">
            <table>
                <tr>
                    <th>Truck Model</th>
                    <th>Truck Number</th>
                    <th>Mobile Number</th>
                    <th>Truck Owner</th>
                    <th>From Route</th>
                    <th>To Route</th>
                    <th>Joining Date</th>
                </tr>
                <tr>
                    <% for(int i = 0 ; i < bean.size(); i++)
                    {
                      BeanOfTruck bot = bean.get(i);
                    %>
                    <td><%= bot.getTruckModel()%></td>
                    <td><%= bot.getTruckNO()%></td>
                    <td><%= bot.getMobile()%></td>
                    <td><%= bot.getOnwer()%></td>
                    <td><%= bot.getFromRoute()%></td>
                    <td><%= bot.getToRoute()%></td>
                    <td><%= bot.getTruckInstallDate()%></td>     
                </tr>
                  <%
                   } %> 
                
            </table>
        </div>
    </div>
</body>
</html>