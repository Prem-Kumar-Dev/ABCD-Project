document.getElementById("withdraw-form").addEventListener("submit", function(event) {
    event.preventDefault();
    let withdrawAmount = parseFloat(document.getElementById("amount").value.trim());

    const remainingElement = document.getElementById("remaining-balance");

    let currentBalance = parseFloat(
        remainingElement.textContent.replace(/[₹,]/g, '')
    );
    if (isNaN(withdrawAmount) || withdrawAmount < 1) {
        alert("Invalid amount! Please enter an amount of ₹1 or more.");
        return;
    }

    if (withdrawAmount <= currentBalance) {
        currentBalance -= withdrawAmount;

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
    document.getElementById("amount").value = "";
});
