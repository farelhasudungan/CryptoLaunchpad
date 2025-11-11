<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crypto Launchpad - Home</title>
    
    <!-- Built Tailwind CSS -->
    <link href="css/output.css" rel="stylesheet">
</head>
<body class="bg-gradient-to-br from-gray-900 via-purple-900 to-gray-900 text-white min-h-screen">
    
    <!-- Navigation -->
    <nav class="bg-black/50 backdrop-blur-lg border-b border-gray-800 sticky top-0 z-50">
        <div class="container mx-auto px-6 py-4">
            <div class="flex items-center justify-between">
                <div class="flex items-center space-x-2">
                    <span class="text-3xl">🚀</span>
                    <span class="text-xl font-bold bg-gradient-to-r from-blue-400 to-purple-500 bg-clip-text text-transparent">
                        Crypto Launchpad
                    </span>
                </div>
                <div class="hidden md:flex space-x-8">
                    <a href="index.jsp" class="hover:text-blue-400 transition-colors">Home</a>
                    <a href="projects" class="hover:text-blue-400 transition-colors">Projects</a>
                    <a href="dashboard.jsp" class="hover:text-blue-400 transition-colors">Dashboard</a>
                </div>
                <a href="login.jsp" class="crypto-btn-gradient px-6 py-2 rounded-lg">
                    Connect Wallet
                </a>
            </div>
        </div>
    </nav>
    
    <!-- Hero Section -->
    <div class="container mx-auto px-6 py-20">
        <div class="text-center max-w-4xl mx-auto">
            <h1 class="text-6xl font-bold mb-6 bg-gradient-to-r from-blue-400 via-purple-500 to-pink-500 bg-clip-text text-transparent">
                Welcome to the Future of Token Launches
            </h1>
            <p class="text-xl text-gray-300 mb-8">
                Discover and invest in the next generation of blockchain projects
            </p>
            <div class="flex justify-center space-x-4">
                <a href="projects" class="crypto-btn-gradient px-8 py-4 rounded-lg text-lg">
                    Explore Projects
                </a>
                <a href="login.jsp" class="border border-blue-500 px-8 py-4 rounded-lg font-semibold text-lg hover:bg-blue-500/10 transition-colors">
                    Get Started
                </a>
            </div>
        </div>
    </div>
    
    <!-- Stats Section -->
    <div class="container mx-auto px-6 py-12">
        <div class="grid grid-cols-1 md:grid-cols-3 gap-8">
            <div class="bg-black/30 backdrop-blur-lg border border-gray-800 rounded-2xl p-8 text-center hover:border-blue-500 transition-colors">
                <div class="text-5xl font-bold text-blue-400 mb-2">50+</div>
                <div class="text-gray-400">Projects Launched</div>
            </div>
            <div class="bg-black/30 backdrop-blur-lg border border-gray-800 rounded-2xl p-8 text-center hover:border-purple-500 transition-colors">
                <div class="text-5xl font-bold text-purple-400 mb-2">$10M+</div>
                <div class="text-gray-400">Total Raised</div>
            </div>
            <div class="bg-black/30 backdrop-blur-lg border border-gray-800 rounded-2xl p-8 text-center hover:border-pink-500 transition-colors">
                <div class="text-5xl font-bold text-pink-400 mb-2">25K+</div>
                <div class="text-gray-400">Active Users</div>
            </div>
        </div>
    </div>
    
</body>
</html>
