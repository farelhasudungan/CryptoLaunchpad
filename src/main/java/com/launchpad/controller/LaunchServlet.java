package com.launchpad.controller;

import com.launchpad.dao.TokenDAO;
import com.launchpad.model.Token;
import com.launchpad.service.BlockchainService;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

@WebServlet("/launch")
@MultipartConfig(maxFileSize = 1024 * 1024)
public class LaunchServlet extends HttpServlet {
    private TokenDAO tokenDAO = new TokenDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            // Get form data
            String network = request.getParameter("network");
            String tokenName = request.getParameter("tokenName");
            String symbol = request.getParameter("symbol");
            Part imagePart = request.getPart("tokenImage");
            
            // Create token object
            Token token = new Token();
            token.setName(tokenName);
            token.setSymbol(symbol.toUpperCase());
            token.setNetwork(network);
            
            // Process image
            if (imagePart != null && imagePart.getSize() > 0) {
                try (InputStream inputStream = imagePart.getInputStream()) {
                    token.setImageData(inputStream.readAllBytes());
                    token.setImageType(imagePart.getContentType());
                }
            }
            
            // DEPLOY TO BLOCKCHAIN
            BlockchainService blockchainService = new BlockchainService(network);
            
            // Deploy token with 1 million initial supply
            BigInteger initialSupply = BigInteger.valueOf(1_000_000);
            String contractAddress = blockchainService.deployToken(
                tokenName, 
                symbol, 
                initialSupply
            );
            
            // Save contract address
            token.setContractAddress(contractAddress);
            token.setDeployerAddress(blockchainService.getDeployerAddress());
            token.setMarketCap("$0"); // Will be calculated later
            
            // Save to database
            boolean success = tokenDAO.saveToken(token);
            
            if (success) {
                response.sendRedirect(request.getContextPath() + 
                    "/launch?success=true&contract=" + contractAddress);
            } else {
                request.setAttribute("error", "Failed to save token");
                doGet(request, response);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Deployment failed: " + e.getMessage());
            doGet(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/launch.jsp").forward(request, response);
    }
}