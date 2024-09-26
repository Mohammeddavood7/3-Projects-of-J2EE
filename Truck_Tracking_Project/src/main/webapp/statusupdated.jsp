<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Update Truck Status</title>
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

.result {
    margin-top: 20px;
    font-size: 1.2em;
    font-weight: 500;
    color: #1e3a8a;
}

.result.success {
    color: #2ecc71; /* Green text for success */
}

.result.error {
    color: #e74c3c; /* Red text for error */
}
</style>
</head>
<body>
<div class="container">
    <header>
        <h1>Truck Tracking Company - Update Truck Status</h1>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="status.jsp">Status</a></li>
                <li><a href="trucks.jsp">Trucks</a></li>
                <li><a href="drivers.jsp">Drivers</a></li>
                <li><a href="about.jsp">About</a></li>
            </ul>
        </nav>
    </header>
    <main>
        <section class="welcome">
            <h2>Update Truck Status</h2>
            <%
                String truckNumber = request.getParameter("truckNumber");
                String status = request.getParameter("status");

                // assume you have a method to update the truck status in the database
             //   boolean updateSuccess = updateTruckStatusInDatabase(truckNumber, status);

               // if (updateSuccess) {
            %>
            <div class="result success">Truck status updated successfully!</div>
            <%
               // } else {
            %>
            <div class="result error">Failed to update truck status. Please try again.</div>
            <%
               // }
            %>
        </section>
    </main>
    <footer>
        <p>&copy; 2022 Truck Tracking Company. All rights reserved.</p>
    </footer>
</div>
</body>
</html>