<%@ page import="manager.BeanOfManager,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
  background-color: white;
  color: #16326a;
}

header {
  background-color: #16326a;
  color: #ffffff;
  padding: 20px;
  text-align: center;
}

h1 {
  margin: 0;
  padding: 0;
}

nav {
  background-color: #16326a;
  padding: 10px;
  text-align: center;
}

nav ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

nav ul li {
  display: inline;
  margin-right: 20px;
}

nav ul li a {
  color: #ffffff;
  text-decoration: none;
}

main {
  padding: 10px;
  text-align: center;
}

section {
  background-color: #dbeafe;
  padding: 10px;
  margin-bottom: 10px;
}

footer {
  background-color: #16326a;
  padding: 10px;
  text-align: center;
}

.container {
  display: flex;
  justify-content: center;
  align-items: center;
}

.card {
  background-color: #ffffff;
  padding: 20px;
  border-radius: 10px;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  width: 500px;
}

.card-header {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  text-align: center;
  background-color: #16326a;
  color: #ffffff;
  padding: 10px;
}

.card-body,
.card-body form {
  display: flex;
  flex-direction: column;
}

.card-body label,
.card-body form {
  margin-bottom: 5px;
}

.card-body input,
.card-body select,
.card-body form {
  padding: 10px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 5px;
}

.card-body button {
  padding: 10px;
  background-color: #1e3a8a;
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

.card-body button:hover {
  background-color: #16326a;
}

.card-footer {
  text-align: center;
  margin-top: 20px;
  background-color: #16326a;
  color: #ffffff;
  padding: 10px;
}

.card-footer a {
  color: white;
  text-decoration: none;
}

.card-footer a:hover {
  text-decoration: underline;
}

.manager-list {
  list-style-type: none;
  margin: 0;
  padding: 0;
}

.manager-list li {
  margin-bottom: 10px;
}

.manager-list li span {
  font-weight: bold;
}

.manager-list li button {
  background-color: rgb(47, 144, 47);
  color: #ffffff;
  border: none;
  border-radius: 5px;
  cursor: pointer;
  padding: 5px;
}

.manager-list li button:hover {
  background-color: rgb(36, 171, 36);
}

.table-container {
  display: flex;
  justify-content: center;
  margin-top: 20px;
}

table {
  width: 80%;
  border-collapse: collapse;
}

th, td {
  border: 1px solid #ddd;
  padding: 10px;
  text-align: left;
}

th {
  background-color: #16326a;
  color: #ffffff;
}
</style>
</head>
<body>

<header>
  <h1>TRANSPORT COMPANY</h1>
  <p>We care about your cargo</p>
</header>

<nav>
  <ul>
    <li><a href="homepage.jsp">HOME</a></li>
    <li><a href="#">RECENTLY INSTALLED TRUCKS</a></li>
    <li><a href="#">STATUS</a></li>
    <li><a href="#">TOWARDS HERE</a></li>
    <li><a href="#">SERVICES</a></li>
    <li><a href="#">CONTACT US</a></li>
    <li><a href="logout.jsp">Logout</a></li>
  </ul>
</nav>

<main>
  <section>
    <h2>MOST CONVENIENT AND RELIABLE TRANSPORT SERVICES</h2>
    <p>Click herefor details</p>
  </section>

  <section>
    <div class="container">
      <div class="card">
        <div class="card-header">
          <h3>Truck Tracking</h3>
        </div>
        <div class="card-body">
          <label for="branch">Branch:</label>
          <form action="findmanager" method="post">
            <select id="branch" name="branch">
              <option value="HYDERABAD">Hyderabad</option>
              <option value="KERALA">Kerala</option>
              <option value="CHENNAI">Chennai</option>
              <option value="BANGALORE">Bangalore</option>
            </select>
            <label for="find">Find Manager:</label>
            <input type="text" id="username" name="username" required>
            <button type="submit">Search</button>
          </form>
        </div>
        <div class="card-footer">
          <a href="createnewmanager.html">Create New Manager</a> | 
          <a href="installnewtrack.html">Install New Truck</a> | 
          <a href="findtruck.html">Search Truck</a>
        </div>
      </div>
    </div>

    <%
    @SuppressWarnings("unchecked")
    ArrayList<BeanOfManager> bean = (ArrayList<BeanOfManager>) request.getAttribute("bean"); 
    %>
    <div class="table-container">
      <table border='1'>
        <caption><a style='text-decoration:none;'href='managerfulldetails.jsp'><% session.setAttribute("bean", bean); %>VIEW ALL MANAGER INFO</a></caption>
        <tr>
          <th>USERNAME</th>
          <th>PASSWORD</th>
        </tr>
        <%for (int i = 0 ; i < bean.size(); i++) {%>
        <tr>
          <td><%= bean.get(i).getUsername()%></td>
          <td><%= bean.get(i).getPassword()%></td>
        </tr>
        <%} %>
      </table>
    </div>
  </section>
</main>

<footer>
  <p>&copy; 2023 Transport Company. All rights reserved.</p>
</footer>
</body>
</html>