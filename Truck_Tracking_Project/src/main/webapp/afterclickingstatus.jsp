<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Input Truck Status</title>
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

form {
    margin-top: 20px;
}

label {
    display: block;
    margin-bottom: 10px;
}

input[type="text"], input[type="submit"] {
    width: 100%;
    padding: 8px;
    border: 1px solid #ddd;
    border-radius: 4px;
    box-sizing: border-box;
    margin-bottom: 10px;
}

input[type="submit"] {
    background-color: #1e3a8a;
    color: #ffffff;
    cursor: pointer;
}

input[type="submit"]:hover {
    background-color: #16326a;
}
</style>
</head>
<body>
<div class="container">
    <header>
        <h1>Truck Tracking Company - Input Truck Status</h1>
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
            <h2>Input Truck Status</h2>
            <form action="update-truck-status.jsp" method="post">
                <label for="truckNumber">Truck Number:</label>
                <input type="text" id="truckNumber" name="truckNumber" required>
                <label for="status">Status:</label>
                <input type="text" id="status" name="status" required>
                <input type="submit" value="Update Status">
            </form>
        </section>
    </main>
    <footer>
        <p>&copy; 2022 Truck Tracking Company. All rights reserved.</p>
    </footer>
</div>
</body>
</html>