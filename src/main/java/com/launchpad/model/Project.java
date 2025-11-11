package com.launchpad.model;

public class Project {
    private int id;
    private String name;
    private String symbol;
    private String description;
    private double tokenPrice;
    private long tokensAvailable;
    private String contractAddress;
    private String status; // "upcoming", "live", "ended"
    private String launchDate;
    
    // Constructor
    public Project(int id, String name, String symbol, String description, 
                   double tokenPrice, long tokensAvailable, String status) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.description = description;
        this.tokenPrice = tokenPrice;
        this.tokensAvailable = tokensAvailable;
        this.status = status;
    }
    
    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getSymbol() { return symbol; }
    public void setSymbol(String symbol) { this.symbol = symbol; }
    
    public double getTokenPrice() { return tokenPrice; }
    public void setTokenPrice(double tokenPrice) { this.tokenPrice = tokenPrice; }
    
    public long getTokensAvailable() { return tokensAvailable; }
    public void setTokensAvailable(long tokensAvailable) { this.tokensAvailable = tokensAvailable; }
    
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    
    // Add other getters/setters
}
