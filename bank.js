document.getElementById("withdraw-form").addEventListener("submit", function(event) {
    event.preventDefault();

    // Get and parse the withdrawal amount, removing any extra spaces
    let withdrawAmount = parseFloat(document.getElementById("amount").value.trim());

    const remainingElement = document.getElementById("remaining-balance");

    // Ensure the current balance is properly parsed (removes ₹ and commas)
    let currentBalance = parseFloat(
        remainingElement.textContent.replace(/[₹,]/g, '')
    );

    // Check if the withdrawAmount is a valid decimal number and >= 1
    if (isNaN(withdrawAmount) || withdrawAmount < 1) {
        alert("Invalid amount! Please enter an amount of ₹1 or more.");
        return;
    }

    // Check if the withdrawal amount is less than or equal to the current balance
    if (withdrawAmount <= currentBalance) {
        currentBalance -= withdrawAmount;

        // Update the remaining balance with proper formatting (with two decimal places)
        remainingElement.textContent = "₹" + currentBalance.toLocaleString('en-IN', {
            minimumFractionDigits: 2,
            maximumFractionDigits: 2
        });

        alert("Withdrawal successful! New balance: ₹" + currentBalance.toLocaleString('en-IN', {
            minimumFractionDigits: 2,
            maximumFractionDigits: 2
        }));
    } else {
        alert("Insufficient balance! Please enter a smaller amount.");
    }

    // Reset the input field after the transaction
    document.getElementById("amount").value = "";
});
