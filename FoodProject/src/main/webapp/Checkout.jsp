<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CheckOut Page</title>
<style>
	
	* {
		    margin: 0;
		    padding: 0;
		    box-sizing: border-box;
		    font-family: Arial, sans-serif;
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

        .navbar .container1 {
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
	
	body {
    font-family: Arial, sans-serif;
    margin: 0;
    min-height: 100vh;
    
    
    background-color: #f5f5f5;
	}
	
	main{
		display: flex;
		justify-content:center;
	}
	
	.checkout-form {
		margin-top:50px;
	    background: white;
	    padding: 2rem;
	    border-radius: 8px;
	    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
	    width: 100%;
	    max-width: 400px;
	}
	
	.form-group {
	    margin-bottom: 1.5rem;
	}
	
	label {
	    display: block;
	    margin-bottom: 0.5rem;
	    color: #333;
	    font-weight: 500;
	}
	
	textarea,
	input,
	select {
	    width: 100%;
	    padding: 0.75rem;
	    border: 1px solid #ddd;
	    border-radius: 4px;
	    font-size: 1rem;
	}
	
	textarea {
	    resize: vertical;
	    min-height: 80px;
	}
	
	button {
	    width: 100%;
	    padding: 0.75rem;
	    background-color: #4CAF50;
	    color: white;
	    border: none;
	    border-radius: 4px;
	    font-size: 1rem;
	    cursor: pointer;
	    transition: background-color 0.2s;
	}
	
	button:hover {
	    background-color: #45a049;
	}
	
	/* Form validation styles */
	input:invalid,
	textarea:invalid,
	select:invalid {
	    border-color: #ff4444;
	}
	
	input:focus,
	textarea:focus,
	select:focus {
	    outline: none;
	    border-color: #4CAF50;
	    box-shadow: 0 0 0 2px rgba(76, 175, 80, 0.1);
	}
</style>
</head>
<body>
	<header>
	<nav class="navbar">
            <div class="container1">
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
<main>
	<form class="checkout-form">
        <div class="form-group">
            <label for="address">Delivery Address</label>
            <textarea 
                id="address" 
                name="address" 
                rows="3" 
                required 
                placeholder="Enter your complete address"
            ></textarea>
        </div>

        <div class="form-group">
            <label for="mobile">Mobile Number</label>
            <input 
                type="tel" 
                id="mobile" 
                name="mobile" 
                required 
                pattern="[0-9]{10}" 
                placeholder="Enter 10-digit mobile number"
            >
        </div>

        <div class="form-group">
            <label for="payment">Payment Mode</label>
            <select id="payment" name="payment" required>
                <option value="">Select payment mode</option>
                <option value="credit">Credit Card</option>
                <option value="debit">Debit Card</option>
                <option value="cash">Cash on Delivery</option>
                <option value="upi">UPI</option>
            </select>
        </div>
        
        <button formaction="CheckOutServlet" type="submit">Place Order</button>
    </form>
    
  </main>
</body>
</html>