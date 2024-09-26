
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*,manager.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Transport Services</title>
    <link rel="stylesheet" href="homepage.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap" rel="stylesheet">
</head>
<body>
       <% 
        BeanOfManager bean = (BeanOfManager) session.getAttribute("bean"); 
        if (bean != null) { 
            session.setAttribute("bean", bean);
        } 
    %>
    <div class="container">
        <header>
            <nav>
                <ul>
                    <li><a href="homepage.html">Home</a></li>
                    <li><a href="recentlytrucks">Recently Installed Trucks</a></li>
                    <li><a href="status">Status</a></li>
                    <li><a href="towardshereservlet">Towards Here</a></li>
                    <li><a href="service.jsp">Services</a></li>
                    <li><a href="contact.html">Contact Us</a></li>
                </ul>
            </nav>
            <div class="banner">
                <h1>Most Convenient And Reliable Transport Services</h1>
                <a class="details-link" href="#">Click here for details</a>
            </div>
        </header>
        <main>
            <section class="welcome">
                <h2> <%= "Welcome, " + (bean != null ? bean.getUsername().toUpperCase() : "Guest") + "!" %> </h2>
                <p>
                    You can find all the information regarding our transport company's services, trucks, and can contact us to get your vehicle installed in our company. 
                    You can find how many vehicles are on the road through our company to your city or closest to it.
                </p>
            </section>
            <section class="featured-services">
                <h3>Featured Services</h3>
                <ul>
                    <li><a href="https://www.tutorialspoint.com/java/index.htm">Free Core Java Tutorial</a></li>
                    <li><a href="https://www.javatpoint.com/jsp-tutorial">JSP Tutorial</a></li>
                    <li><a href="https://developer.android.com/guide">Free Android Tutorial</a></li>
                    <li><a href="https://www.tutorialspoint.com/struts_2/index.htm">Struts and Hibernate Tutorial</a></li>
                    <li><a href="https://github.com/topics/java-projects">More Project</a></li>
                    <li><a href="https://www.tutorialspoint.com/cprogramming/index.htm">C, C++ Tutorial</a></li>
                    <li><a href="https://stackoverflow.com/">The Forum</a></li>
                    <li><a href="https://www.w3schools.com/">HTML, SQL Tutorial</a></li>
                </ul>
            </section>
            <section class="featured-events">
                <h3>Featured Events</h3>
                <ul>
                    <li><a href="https://github.com/topics/java-projects">More Project</a></li>
                    <li><a href="https://www.tutorialspoint.com/cprogramming/index.htm">C, C++ Tutorial</a></li>
                    <li><a href="https://stackoverflow.com/">The Forum</a></li>
                    <li><a href="https://www.w3schools.com/">HTML, SQL Tutorial</a></li>
                </ul>
            </section>
        </main>
        <footer>
            <a class="details-link" href="#">Click here for details</a>
        </footer>
    </div>
</body>
</html>
