package com.launchpad.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.launchpad.model.Project;

@WebServlet("/projects")
public class ProjectServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // Simulate fetching projects from database
        List<Project> projects = getAllProjects();
        
        // Set projects as request attribute
        request.setAttribute("projectList", projects);
        
        // Forward to JSP page
        request.getRequestDispatcher("/projects.jsp").forward(request, response);
    }
    
    private List<Project> getAllProjects() {
        List<Project> projects = new ArrayList<>();
        
        // Sample data (later replace with database queries)
        projects.add(new Project(1, "DeFi Protocol", "DFP", 
            "Decentralized finance protocol for lending", 
            0.005, 1000000, "live"));
            
        projects.add(new Project(2, "GameFi Token", "GFT", 
            "Play-to-earn gaming ecosystem", 
            0.003, 5000000, "upcoming"));
            
        projects.add(new Project(3, "NFT Marketplace", "NFTM", 
            "Decentralized NFT trading platform", 
            0.008, 750000, "live"));
        
        return projects;
    }
}
