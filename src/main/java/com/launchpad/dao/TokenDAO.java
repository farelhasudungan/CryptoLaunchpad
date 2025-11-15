package com.launchpad.dao;

import com.launchpad.model.Token;
import com.launchpad.util.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TokenDAO {
    
    // Save new token
    public boolean saveToken(Token token) {
        String query = "INSERT INTO tokens (name, symbol, network, market_cap, market_cap_value, image_data, image_type) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setString(1, token.getName());
            stmt.setString(2, token.getSymbol());
            stmt.setString(3, token.getNetwork());
            stmt.setString(4, token.getMarketCap());
            
            // Parse market cap value (remove $ and K/M)
            BigDecimal marketCapValue = parseMarketCap(token.getMarketCap());
            stmt.setBigDecimal(5, marketCapValue);
            
            stmt.setBytes(6, token.getImageData());
            stmt.setString(7, token.getImageType());
            
            return stmt.executeUpdate() > 0;
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Helper method to parse market cap
    private BigDecimal parseMarketCap(String marketCap) {
        if (marketCap == null || marketCap.isEmpty()) {
            return BigDecimal.ZERO;
        }
        
        // Remove $ and spaces
        String cleaned = marketCap.replace("$", "").replace(" ", "").toUpperCase();
        
        try {
            if (cleaned.endsWith("M")) {
                return new BigDecimal(cleaned.replace("M", "")).multiply(new BigDecimal("1000000"));
            } else if (cleaned.endsWith("K")) {
                return new BigDecimal(cleaned.replace("K", "")).multiply(new BigDecimal("1000"));
            } else {
                return new BigDecimal(cleaned);
            }
        } catch (NumberFormatException e) {
            return BigDecimal.ZERO;
        }
    }
    
    // Get trending tokens
    public List<Token> getTrendingTokens() {
        List<Token> tokens = new ArrayList<>();
        String query = "SELECT * FROM tokens ORDER BY market_cap_value DESC LIMIT 4";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                Token token = new Token();
                token.setId(rs.getInt("id"));
                token.setName(rs.getString("name"));
                token.setSymbol(rs.getString("symbol"));
                token.setNetwork(rs.getString("network"));
                token.setMarketCap(rs.getString("market_cap"));
                token.setImageData(rs.getBytes("image_data"));
                token.setImageType(rs.getString("image_type"));
                tokens.add(token);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return tokens;
    }
    
    // Get token by ID
    public Token getTokenById(int id) {
        String query = "SELECT * FROM tokens WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Token token = new Token();
                token.setId(rs.getInt("id"));
                token.setName(rs.getString("name"));
                token.setSymbol(rs.getString("symbol"));
                token.setNetwork(rs.getString("network"));
                token.setMarketCap(rs.getString("market_cap"));
                token.setImageData(rs.getBytes("image_data"));
                token.setImageType(rs.getString("image_type"));
                return token;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
