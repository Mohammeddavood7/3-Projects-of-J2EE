<%@ page import="banking.BeanOfBanking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apana - Bank</title>
<style>
    body {
        background-color: black;
        color: white;
        font-family: Arial, sans-serif;
    }
    .container {
        width: 80%;
        margin: auto;
        overflow: hidden;
    }
    header {
        background: #000;
        color: #fff;
        padding-top: 30px;
        min-height: 70px;
        border-bottom: #e8491d 3px solid;
    }
    header a {
        color: #fff;
        text-decoration: none;
        text-transform: uppercase;
        font-size: 16px;
    }
    header ul {
        padding: 0;
        list-style: none;
    }
    header li {
        display: inline;
        padding: 0 20px 0 20px;
    }
    .branding {
        float: left;
    }
    .branding img {
        height: 70px;
    }
    nav {
        float: right;
        margin-top: 10px;
    }
    .content {
        padding: 20px;
        background: #333;
        color: #fff;
    }
    .content h2 {
        text-align: center;
    }
    .content table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
    }
    .content table, th, td {
        border: 1px solid #ddd;
    }
    .content th, td {
        padding: 10px;
        text-align: left;
    }
    .content a {
        color: #e8491d;
        text-decoration: none;
    }
</style>
</head>
<body>

       <header>
        <div class="container">
            <div class="branding">
                <h1>APANA - BANK</h1>
                <h2>ExtraOrdinary Service</h2>
            </div>
            <nav>
                <ul>
                    <li><a href="newaccount.html"><button>NEW ACCOUNT</button></a></li>
                    <li><a href="balance.html"><button>BALANCE</button></a></li>
                    <li><a href="deposit.html"><button>DEPOSIT</button></a></li>
                    <li><a href="withdraw.html"><button>WITHDRAW</button></a></li>
                    <li><a href="transfer.html"><button>TRANSFER</button></a></li>
                    <li><a href="closeac.html"><button>CLOSE A/C</button></a></li>
                    <li><a href="aboutus.html"><button>ABOUT US</button></a></li>
                </ul>
            </nav>
        </div>
    </header>

    <section class="content">
        <div class="container">
            <h2>Services</h2>
            <ul>
                <li><a href="https://www.javatpoint.com">www.javatpoint.com</a></li>
                <li><a href="https://www.javacspoint.com">www.javacspoint.com</a></li>
                <li><a href="https://www.javatpoint.com/forum.jsp">www.javatpoint.com/forum.jsp</a></li>
            </ul>
            <table>
                <thead>
                    <tr>
                        <th>ACCOUNT NO</th>
                        <th>USERNAME</th>
                        <th>REMAINING AMOUNT</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            BeanOfBanking bob = (BeanOfBanking) request.getAttribute("bean");
                        %>
                        <td><%= bob.getAccountno() %></td>
                        <td><%= bob.getUsername() %></td>
                        <td><%= bob.getAmount() %></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>
</body>
</html>
