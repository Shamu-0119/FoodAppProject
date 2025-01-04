<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Page</title>
<style>
	* {
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box;
	    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

		body {
		    background-color: #f5f5f5;
		    padding: 20px;  
		}
		
		header {
		    text-align: center;
		    margin-bottom: 0;
		    padding:20px;
		}
		.navbar {
            background-color: #4CAF50;
            padding: 15px 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            position: sticky;
            top: 0;
            z-index: 1000;
        }

        .navbar .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .navbar .logo {
            font-size: 28px;
            font-weight: bold;
            color: #fff;
            margin: 0;
            text-shadow: 1px 1px 2px rgba(0, 0, 0, 0.3);
        }
        
        h3{
        	text-transform:uppercase;
        }
        

        .navbar .nav-links {
            list-style: none;
            display: flex;
            margin: 0;
            padding: 0;
        }

        .navbar .nav-links li {
            margin: 0 10px;
        }

        .navbar .nav-links a {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            padding: 8px 12px;
            border-radius: 20px;
            transition: background-color 0.3s, box-shadow 0.3s;
        }

        .navbar .nav-links a:hover {
            background-color: rgba(255, 255, 255, 0.3);
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }
        
        .content {
        padding: 20px;
        max-width: 800px;
        margin: 50px auto;
      }
      
      h1 {
        color: #f04e30;
        text-align: center;
        margin-bottom: 20px;
      }
      
      p {
        margin-bottom: 15px;
        line-height:2;
        color: #333;
      }
</style>
</head>
<body>
	<header>
	<nav class="navbar">
            <div class="container">
                <h1 class="logo">FoodieApp</h1>
                
                
                <ul class="nav-links">
                    <li><a href="home.jsp">Home</a></li>
                    <li><a href="AboutUs.jsp">About</a></li>
                    <li><a href="ContactUs.jsp">Contact</a></li>
                    <li><a href="Cart.jsp">Cart</a></li>
                </ul>
                
                <h3 class="logo">Hello, <%out.println(session.getAttribute("name")); %></h3>
            </div>
        </nav>
        
    </header>
    
    <main class="content">
        <h1>Contact Us</h1>
        <p>We'd love to hear from you! Whether you have a question, feedback, or need support, our team is here to assist you.</p>
        <p><strong>Email:</strong> support@foodiedelivery.com</p>
        <p><strong>Phone:</strong> +1 234 567 8900</p>
        <p><strong>Address:</strong> 123 Foodie Lane, Gourmet City, FL 45678</p>
        <p>Feel free to reach out to us anytime!</p>
      </main>
</body>
</html>