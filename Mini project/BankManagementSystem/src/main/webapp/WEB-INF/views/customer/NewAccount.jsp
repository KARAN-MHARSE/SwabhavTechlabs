<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Bank Account</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" 
      rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <div class="card shadow-lg border-0 rounded-3">
                    <div class="card-header text-center bg-primary text-white">
                        <h3 class="mb-0">Create New Bank Account</h3>
                    </div>
                    <div class="card-body p-4">
                        <!-- enctype is required for file upload -->
                        <form action="NewAccountController" method="post" enctype="multipart/form-data" class="needs-validation" novalidate>
                            
                            <div class="mb-3">
                                <label class="form-label">Aadhaar Number</label>
                                <input type="text" class="form-control" name="adharNo" 
                                       pattern="\d{12}" title="Enter 12 digit Aadhaar number" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">PAN Number</label>
                                <input type="text" class="form-control" name="panNo" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Account Type</label>
                                <select class="form-select" name="accountType" required>
                                    <option value="" disabled selected>Select Account Type</option>
                                    <option value="Saving">Saving</option>
                                    <option value="Current">Current</option>
                                </select>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Initial Deposit</label>
                                <input type="number" class="form-control" name="initialDeposit" min="0" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Upload Aadhaar Document</label>
                                <input type="file" class="form-control" accept="image/*" name="adharDoc" required>
                            </div>
                            
                            <div class="mb-3">
                                <label class="form-label">Upload PAN Document</label>
                                <input type="file" class="form-control" accept="image/*" name="panDoc" required>
                            </div>
                            
                            <div class="form-check mb-3">
                                <input type="checkbox" class="form-check-input" name="agree" value="accepted" required>
                                <label class="form-check-label">I confirm the information provided is correct</label>
                            </div>
                            
                            <div class="d-grid">
                                <button type="submit" class="btn btn-primary btn-lg">Create Account</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
