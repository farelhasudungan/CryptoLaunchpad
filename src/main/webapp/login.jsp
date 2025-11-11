<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign In - Crypto Launchpad</title>
    <link href="css/output.css" rel="stylesheet">
</head>
<body class="bg-gray-50 min-h-screen flex items-center justify-center p-4">
    
    <div class="w-full max-w-md">
        <!-- Card Container -->
        <div class="crypto-card">
            
            <!-- Logo/Icon -->
            <div class="mb-8">
                <div class="w-12 h-12 bg-gradient-to-r from-blue-500 to-purple-600 rounded-full flex items-center justify-center mb-6">
                    <span class="text-2xl">🚀</span>
                </div>
                
                <!-- Welcome Text -->
                <h1 class="text-2xl font-bold text-gray-900 mb-2">Welcome back!</h1>
                <p class="text-gray-600">Sign in to your account to continue.</p>
            </div>
            
            <!-- Error Message -->
            <% if (request.getAttribute("error") != null) { %>
                <div class="mb-5 bg-red-50 border border-red-200 text-red-700 px-4 py-3 rounded-lg">
                    <p class="text-sm"><%= request.getAttribute("error") %></p>
                </div>
            <% } %>
            
            <!-- Login Form -->
            <form action="login" method="post" class="space-y-5">
                
                <!-- Email Field -->
                <div>
                    <label for="email" class="block text-sm font-semibold text-gray-900 mb-2">
                        Email
                    </label>
                    <input 
                        type="email" 
                        id="email" 
                        name="email" 
                        required
                        class="crypto-input"
                        placeholder="Enter your email"
                    >
                </div>
                
                <!-- Password Field -->
                <div>
                    <label for="password" class="block text-sm font-semibold text-gray-900 mb-2">
                        Password
                    </label>
                    <input 
                        type="password" 
                        id="password" 
                        name="password" 
                        required
                        class="crypto-input"
                        placeholder="Enter your password"
                    >
                </div>
                
                <!-- Remember Me & Forgot Password -->
                <div class="flex items-center justify-between">
                    <div class="flex items-center">
                        <input 
                            type="checkbox" 
                            id="remember" 
                            name="remember"
                            class="w-4 h-4 text-black border-gray-300 rounded focus:ring-black"
                        >
                        <label for="remember" class="ml-2 text-sm text-gray-700">
                            Remember me
                        </label>
                    </div>
                    <a href="forgot-password.jsp" class="text-sm text-gray-900 hover:underline">
                        Forgot password?
                    </a>
                </div>
                
                <!-- Sign In Button -->
                <button type="submit" class="crypto-btn">
                    Sign in
                </button>
                
            </form>
            
            <!-- Sign Up Link -->
            <div class="mt-8 text-center">
                <span class="text-sm text-gray-600">Not a member? </span>
                <a href="register.jsp" class="text-sm text-gray-900 font-semibold hover:underline">
                    Create an account
                </a>
            </div>
            
        </div>
    </div>
    
</body>
</html>
