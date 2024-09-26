<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="truck.*,java.sql.*,java.util.*,towards.*,truck.BeanOfTruck" %>
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
}

.container {
    width: 90%;
    margin: 0 auto;
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
}

nav ul {
    list-style: none;
    padding: 0;
    display: flex;
    justify-content: space-around;
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

.banner {
    text-align: center;
    margin-top: 10px;
}

.banner h1 {
    font-size: 1.8em;
}

.banner .details-link {
    color: #ffffff; /* White text */
    text-decoration: underline;
    display: inline-block;
    margin-top: 10px;
}

main {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
}

section {
    background-color: #dbeafe; /* Lighter blue background for sections */
    padding: 20px;
    flex: 1 1 45%;
    box-shadow: 0 0 10px rgba(0,0,0,0.1);
    border-radius: 8px;
}

.welcome {
    flex: 1 1 100%;
}

h2, h3 {
    color: #1e3a8a; /* Dark blue text */
    margin-bottom: 10px;
}

ul {
    list-style: none;
    padding: 0;
}

ul li {
    margin: 5px 0;
}

ul li a {
    color: #1e3a8a; /* Dark blue text */
    text-decoration: none;
    transition: color 0.3s;
}

ul li a:hover {
    color: white; /* Darker blue on hover */
}

table {
    width: 100%;
    border-collapse: collapse;
}

th, td {
    text-align: left;
    padding: 8px;
    border: 1px solid #ddd;
}

th {
    background-color: #1e3a8a; /* Dark blue background for table headers */
    color: #fff;
}

footer {
    text-align: center;
    margin-top: 20px;
}

footer .details-link {
    color: #1e3a8a; /* Dark blue text */
    text-decoration: underline;
    font-weight: 500;
    display: inline-block;
    margin-top: 10px;
}

img {
    width: 100%;
    height: auto;
    border-radius: 8px;
}
</style>
</head>
<body>
<div class="container">
    <header>
        <nav>
            <ul>
                <li><a href="#">HOME</a></li>
                <li><a href="#">RECENTLY INSTALLED TRUCKS</a></li>
                <li><a href="#">STATUS</a></li>
                <li><a href="#">TOWARDS HERE</a></li>
                <li><a href="#">SERVICES</a></li>
                <li><a href="#">CONTACT US</a></li>
                <li><a href="#">Logout</a></li>
            </ul>
        </nav>
    </header>

    <div class="banner">
        <h1>MOST CONVINIENT AND RELIABLE TRANSPORT SERVICES</h1>
        <a href="#" class="details-link">Click here for details</a>
    </div>
    <%
                @SuppressWarnings("unchecked")
                ArrayList<BeanOfTruck> bean = (ArrayList<BeanOfTruck>)session.getAttribute("truck");    
    %>

    <main>
        <section class="welcome">
            <h2>WELCOME TO OUR TRUCK TRACKING COMPANY</h2>
            <table>
                <thead>
                    <tr>
                        <th>Model</th>
                        <th>Truck No</th>
                        <th>Mobile No</th>
                        <th>Owner</th>
                        <th>From</th>
                    </tr>
                </thead>
                <tbody>
                <%  for(int i = 0 ; i < bean.size() ; i++)	  
                  { 
                     BeanOfTruck truck  =  bean.get(i);
                %>
                    <tr>
                        <td><%= truck.getTruckModel()%></td>
                        <td><%= truck.getTruckNO() %></td>
                        <td><%= truck.getMobile() %></td>
                        <td><%= truck.getOnwer() %></td>
                        <td><%= truck.getFromRoute() %></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </section>

        <section>
            <h2>FEATURED SERVICES</h2>
            <ul>
                <li>Free Core java tutorial</li>
                <li>Jsp tutorial</li>
                <li>Free Android Tutorial</li>
                <li>Struts and Hibernet Tutorial</li>
            </ul>
        </section>

        <section>
            <h2>More Project</h2>
            <ul>
                <li>C.C++ Tutorial</li>
                <li>The forum</li>
                <li>Html.Sql Tutorial</li>
            </ul>
        </section>

        <section>
            <img src="images/clocks.jpg" alt="Clocks">
            <img src="images/fragile.jpg" alt="Fragile Box">
            <img src="images/truck.jpg" alt="Truck">
            <img src="images/man.jpg" alt="Man">
        </section>
    </main>

    <footer>
        <a href="#" class="details-link">Click here for details</a>
    </footer>
</div>
</body>
</html>