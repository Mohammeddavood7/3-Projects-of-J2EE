<%@ page  import="truck.BeanOfTruck,java.text.*,java.util.*"%>
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
      padding: 20px;
      text-align: center;
    }

    section {
      background-color: #dbeafe;
      padding: 20px;
      margin-bottom: 20px;
    }

    footer {
      background-color: #16326a;
      padding: 10px;
      text-align: center;
      color: #ffffff;
    }

    .container {
      display: flex;
      justify-content: center;
      align-items: flex-start;
      min-height: 50vh;
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

    .card-body {
      display: flex;
      flex-direction: column;
    }

    .card-body label {
      margin-bottom: 5px;
    }

    .card-body input,
    .card-body button {
      padding: 10px;
      margin-bottom: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
    }

    .card-body button {
      background-color: #1e3a8a;
      color: #ffffff;
      border: none;
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

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    table, th, td {
      border: 1px solid #ddd;
    }

    th, td {
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
      <li><a href="#">HOME</a></li>
      <li><a href="#">RECENTLY INSTALLED TRUCKS</a></li>
      <li><a href="#">STATUS</a></li>
      <li><a href="#">TOWARDS HERE</a></li>
      <li><a href="#">SERVICES</a></li>
      <li><a href="#">CONTACT US</a></li>
      <li><a href="#">Logout</a></li>
    </ul>
  </nav>

  <main>
    <section>
      <h2>Truck Details</h2>
      <div class="container">
        <div class="card">
          <div class="card-header">
            <h3>Truck Information</h3>
          </div>
          <div class="card-body">
            <% 
            BeanOfTruck bean = (BeanOfTruck)request.getAttribute("bean");
              if (bean == null) {
                out.println("<p>" + bean + "</p>");
              } else {
                String truckModel = bean.getTruckModel();
                String truckNumber = bean.getTruckNO();
                String ownerName = bean.getOnwer();
                String insurance = bean.getInsurance();
                String insuranceCompany = bean.getInsuranceCompany();
                long mobile = bean.getMobile();
                String routeFrom = bean.getFromRoute();
                String routeTo = bean.getToRoute();
                String dateOfJoining = bean.getTruckInstallDate();
                String status = bean.getStatus();

                    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
                    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

                    Date date = inputFormat.parse(dateOfJoining);

                    String formattedDate = outputFormat.format(date);

                    System.out.println(formattedDate); 
                
            %>
                <table>
                  <tr><th>Truck Model</th><td><%= truckModel %></td></tr>
                  <tr><th>Truck Number</th><td><%= truckNumber %></td></tr>
                  <tr><th>Owner Name</th><td><%= ownerName %></td></tr>
                  <tr><th>Insurance</th><td><%= insurance %></td></tr>
                  <tr><th>Insurance Company</th><td><%= insuranceCompany %></td></tr>
                  <tr><th>mobile</th><td><%= mobile %></td></tr>
                  <tr><th>Route From</th><td><%= routeFrom %></td></tr>
                  <tr><th>Route To</th><td><%= routeTo %></td></tr>
                  <tr><th>Joining Date</th><td><%= formattedDate %></td></tr>
                  <tr><th>Truck Status</th><td><%= status %></td></tr>
                  
                </table>
            <% 
              }
            %>
          </div>
          <div class="card-footer">
            <a href="findtruck.html">Back to Search</a>
          </div>
        </div>
      </div>
    </section>

  </main>

  <footer>
    <p>&copy; 2023 Transport Company. All rights reserved.</p>
  </footer>

</body>
</html>
