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
    <section class="relative bg-sky-50 overflow-hidden">
        <div class="py-20 md:py-28 min-h-screen flex items-center">
            <div class="container px-4 mx-auto">
            <div class="max-w-md mx-auto">
                <div class="bg-white rounded-lg shadow-lg p-9 md:p-10">
                <div class="mb-11 text-left">
                    <span class="text-lg font-medium text-black">Welcome!</span>
                    <p class="text-sm text-coolGray-500 font-medium">Enter your credentials to access your account</p>
                </div>
                <form action="#" method="post">
                    <div class="mb-6">
                    <label class="block mb-2 text-coolGray-800 font-medium" for="email">Email Address</label>
                    <input class="w-full py-3 px-4 text-coolGray-500 leading-tight placeholder-coolGray-500 focus:outline-none focus:ring-2 focus:ring-white focus:ring-opacity-50 border border-coolGray-200 rounded-lg shadow-xs" type="email" name="email" placeholder="you@example.com" required=""/>
                    </div>
                    <div class="mb-6">
                    <label class="block mb-2 text-coolGray-800 font-medium" for="password">Password</label>
                    <input class="w-full py-3 px-4 text-coolGray-500 leading-tight placeholder-coolGray-500 focus:outline-none focus:ring-2 focus:ring-white focus:ring-opacity-50 border border-coolGray-200 rounded-lg shadow-xs" type="password" name="password" placeholder="Enter your password" required=""/>
                    </div>
                    <div class="mb-6 flex items-center justify-between">
                    <label>
                        <input type="checkbox" name="remember" value="1"/>
                        <span class="ml-1 text-coolGray-800">Remember me</span>
                    </label>
                    <a class="text-black hover:text-gray-800 font-medium" href="#">Forgot Password?</a>
                    </div>
                    <button class="inline-block py-3 px-7 w-full text-lg leading-7 text-white bg-black hover:bg-gray-900 font-medium text-center focus:ring-2 focus:ring-white focus:ring-opacity-50 border border-transparent rounded-9xl" type="submit">Sign In</button>
                </form>
                <div class="mt-6 text-center">
                    <p class="text-coolGray-500">Don't have an account? <a class="text-black hover:text-gray-800 font-medium" href="#">Sign up</a></p>
                </div>
                </div>
            </div>
            </div>
        </div>
    </section>
</body>
</html>
