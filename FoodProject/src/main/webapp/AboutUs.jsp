<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
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
                    <li><a href="Contact.jsp">Contact</a></li>
                    <li><a href="Cart.jsp">Cart</a></li>
                </ul>
                
                <h3 class="logo">Hello, <%out.println(session.getAttribute("name")); %></h3>
            </div>
        </nav>
        
    </header>
    
	<main class="content">
        <h1>About Us</h1>
        <p>Welcome to <strong>Foodie Delivery</strong>, your go-to food delivery application! We aim to connect you with your favorite restaurants and deliver delicious meals right to your doorstep.</p>
        <p>Our mission is to bring convenience and flavor to your life. With a wide selection of restaurants, real-time tracking, and a seamless ordering experience, we ensure that satisfying your cravings has never been easier.</p>
        <p>Join us in revolutionizing the way you enjoy your meals. Happy eating!</p>
      </main>
</body>
</html>