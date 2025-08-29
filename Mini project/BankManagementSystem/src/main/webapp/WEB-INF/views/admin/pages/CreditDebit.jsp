<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Credit or Debit</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <h2 class="text-center mb-4">Credit or Debit</h2>

                <!-- Credit Form -->
                <div class="card shadow-sm mb-4">
                    <div class="card-header bg-success text-white">
                        <h5 class="mb-0">Credit</h5>
                    </div>
                    <div class="card-body">
                        <form action="AdminDashboardController" method="post">
                            <input type="hidden" name="action" value="credit">

                            <div class="mb-3">
                                <label class="form-label">Account Number</label>
                                <input type="text" class="form-control" name="accountNumber" placeholder="Enter account number" required>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Amount</label>
                                <input type="number" class="form-control" name="amount" placeholder="Enter amount" required>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Message</label>
                                <input type="text" class="form-control" name="message" placeholder="Enter message" required>
                            </div>

                            <button type="submit" class="btn btn-success w-100">Credit</button>
                        </form>
                    </div>
                </div>

                <!-- Debit Form -->
                <div class="card shadow-sm">
                    <div class="card-header bg-danger text-white">
                        <h5 class="mb-0">Debit</h5>
                    </div>
                    <div class="card-body">
                        <form action="AdminDashboardController" method="post">
                            <input type="hidden" name="action" value="debit">

                            <div class="mb-3">
                                <label class="form-label">Account Number</label>
                                <input type="text" class="form-control" name="accountNumber" placeholder="Enter account number" required>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Amount</label>
                                <input type="number" class="form-control" name="amount" placeholder="Enter amount" required>
                            </div>

                            <div class="mb-3">
                                <label class="form-label">Message</label>
                                <input type="text" class="form-control" name="message" placeholder="Enter message" required>
                            </div>

                            <button type="submit" class="btn btn-danger w-100">Debit</button>
                        </form>
                    </div>
                </div>

            </div>
        </div>
    </div>

    <!-- Bootstrap JS (for modal, alerts, etc.) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
