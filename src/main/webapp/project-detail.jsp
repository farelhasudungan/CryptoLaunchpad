<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Project Details - Crypto Launchpad</title>
    <link rel="stylesheet" href="css/output.css">
</head>
<body>
    <header>
        <nav>
            <h1>🚀 Crypto Launchpad</h1>
            <ul>
                <li><a href="index.jsp">Home</a></li>
                <li><a href="projects">Projects</a></li>
                <li><a href="dashboard.jsp">Dashboard</a></li>
            </ul>
        </nav>
    </header>
    
    <main>
        <div class="project-detail-container">
            <div class="project-main">
                <h2>DeFi Protocol (DFP)</h2>
                <span class="status-badge live">Live Now</span>
                
                <div class="progress-section">
                    <div class="progress-bar">
                        <div class="progress-fill" style="width: 65%"></div>
                    </div>
                    <p>650,000 / 1,000,000 tokens sold (65%)</p>
                </div>
                
                <div class="buy-section">
                    <h3>Participate in Token Sale</h3>
                    <form action="buy-tokens" method="post">
                        <div class="form-group">
                            <label>Amount (ETH):</label>
                            <input type="number" name="ethAmount" step="0.001" 
                                   placeholder="0.0" required>
                        </div>
                        <div class="form-group">
                            <label>You will receive:</label>
                            <input type="text" id="tokenAmount" readonly 
                                   placeholder="0 DFP">
                        </div>
                        <button type="submit" class="btn-buy">Buy Tokens</button>
                    </form>
                </div>
                
                <div class="project-description">
                    <h3>About the Project</h3>
                    <p>A revolutionary DeFi protocol that enables seamless lending 
                       and borrowing with minimal fees...</p>
                </div>
            </div>
            
            <aside class="project-sidebar">
                <div class="info-card">
                    <h4>Token Information</h4>
                    <ul>
                        <li>Symbol: <strong>DFP</strong></li>
                        <li>Price: <strong>$0.005</strong></li>
                        <li>Network: <strong>Ethereum</strong></li>
                        <li>Total Supply: <strong>100M</strong></li>
                    </ul>
                </div>
                
                <div class="info-card">
                    <h4>Sale Timeline</h4>
                    <ul>
                        <li>Start: <strong>Nov 1, 2025</strong></li>
                        <li>End: <strong>Nov 30, 2025</strong></li>
                        <li>Listing: <strong>Dec 5, 2025</strong></li>
                    </ul>
                </div>
            </aside>
        </div>
    </main>
</body>
</html>
