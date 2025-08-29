<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Account</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    <style>
        body {
            background: #f0f2f5;
        }
        .card {
            border-radius: 15px;
            padding: 15px;
        }
        .card-header {
            border-radius: 15px 15px 0 0;
        }
        .form-label {
            font-weight: 600;
        }
        .btn-success {
            min-width: 150px;
        }
        .btn:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white">
                <h4 class="mb-0">Create New Account</h4>
            </div>
            <div class="card-body">
                <form action="AdminDashboardController" method="post" enctype="multipart/form-data">
                    <input type="hidden" name="action" value="createAccount">

                    <!-- User Details -->
                    <h5 class="mb-3">User Details</h5>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Full Name</label>
                            <input type="text" class="form-control" name="name" placeholder="Enter full name" required>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control" name="address" placeholder="Enter address" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Gender</label>
                            <select class="form-select" name="gender" required>
                                <option value="Male">Male</option>
                                <option value="Female">Female</option>
                                <option value="Other">Other</option>
                            </select>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">Mobile</label>
                            <input type="text" class="form-control" name="mobile" maxlength="10" placeholder="Enter 10-digit mobile" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Aadhar Number</label>
                            <input type="text" class="form-control" name="adhar" maxlength="12" placeholder="Enter 12-digit Aadhar" required>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">PAN Number</label>
                            <input type="text" class="form-control" name="pan" maxlength="10" placeholder="Enter PAN" required>
                        </div>
                    </div>
                    
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control" name="email" placeholder="Enter email address" required>
                        </div>
                    </div>

                    <!-- Account Details -->
                    <h5 class="mb-3 mt-4">Account Details</h5>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Balance</label>
                            <input type="number" step="0.01" class="form-control" name="balance" placeholder="Enter initial balance" required>
                        </div>
                    </div>
                    
                    <!-- File Upload -->
                    <h5 class="mb-3 mt-4">Upload Documents</h5>
                    <div class="row mb-3">
                        <div class="col-md-6">
                            <label class="form-label">Aadhar File</label>
                            <input type="file" class="form-control" name="aadharFile" accept="image/*,.pdf" required>
                        </div>
                        <div class="col-md-6">
                            <label class="form-label">PAN Card File</label>
                            <input type="file" class="form-control" name="panFile" accept="image/*,.pdf" required>
                        </div>
                    </div>
                    
                    <!-- Submit -->
                    <div class="text-end">
                        <button type="submit" class="btn btn-success me-2">Create Account</button>
                        <button type="reset" class="btn btn-secondary">Reset</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>
