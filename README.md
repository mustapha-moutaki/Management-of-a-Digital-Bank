# FinBank Solutions - Digital Banking System 🏦

## 📋 Project Overview

FinBank Solutions is a Java console application that digitalizes banking account management for clients and managers. This system provides a simple, reliable, and secure tool for managing common financial operations while ensuring complete traceability.

## 🎯 Objectives

The application simulates digital banking account management, respecting business rules and object-oriented programming best practices through a console interface.

## ✨ Main Features

### 👥 For Clients:
- ✅ **Account Balance Consultation** - Check available funds
- ✅ **Deposits and Withdrawals** - Manage account transactions
- ✅ **Money Transfers** - Transfer funds between accounts
- ✅ **Bank Statement Consultation** - View transaction history from .txt files
- ✅ **Multiple Account Management** - Handle different savings or expense accounts

### 🏛️ For Managers (Bankers):
- ✅ **Account Management** - Create, modify, and close client accounts
- ✅ **Client Information Updates** - Maintain up-to-date client data
- ✅ **Transaction Monitoring** - Consult any client's bank statement
- ✅ **Client Search and Management** - Find and manage client profiles

## 🔧 Business Rules

- **One-to-Many Relationship**: A client can own multiple accounts
- **Account Ownership**: Each account belongs to only one client
- **Transaction History**: Each account maintains a complete transaction history
- **File Logging**: Each operation is recorded in a unique .txt file per account
- **Exception Handling**: Insufficient balance, non-existent account, negative amounts, file access issues

## 📊 Entity Modeling (OOP)


## 💻 Technical Architecture

### Technologies Used:
- **Language**: Java (OOP, Collections)
- **Collections**: 
  - `HashMap` for client account management
  - `HashSet` for transaction history
- **File Management**: Creating and reading .txt files for bank statements

### Design Patterns:
- **MVC Pattern**: Separation of concerns (Model, View, Controller)
- **Service Layer Pattern**: Business logic encapsulation
- **Exception Handling**: Custom exceptions for robust error management

## 📝 Transaction Log Format

Each account has its own transaction log file with the following format:

```
Date | Type | Amount | Source Account | Destination Account
2025-09-15 | Deposit | 100.00 € | null | C1001
2025-09-16 | Withdrawal | 50.00 € | C1001 | null
2025-09-17 | Transfer | 200.00 € | C1001 | C1002
```

## 🚀 Getting Started

### Prerequisites
- Java JDK 8 or higher
- IDE (IntelliJ IDEA, Eclipse, VS Code)
- Git (optional)

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/finbank-solutions.git
   cd finbank-solutions
   ```

2. **Compile the project**
   ```bash
   javac -d bin src/**/*.java
   ```

3. **Run the application**
   ```bash
   java -cp bin Main
   ```

### Alternative: Using IDE
1. Import the project into your preferred IDE
2. Run the `Main.java` file
3. Follow the console prompts

## 🎮 How to Use

### 🔐 First Time Setup
1. Run the application
2. Choose "Manager" mode to create initial client accounts
3. Switch to "Client" mode to perform transactions

### 👤 Client Operations
1. **Login**: Use your client ID to access your accounts
2. **View Balance**: Check your account balance
3. **Make Deposit**: Add money to your account
4. **Make Withdrawal**: Remove money (if sufficient balance)
5. **Transfer Funds**: Move money between your accounts
6. **View Statement**: Check your transaction history

### 🏛️ Manager Operations
1. **Create Account**: Set up new client accounts
2. **Update Client Info**: Modify client details
3. **View Transactions**: Monitor client activities
4. **Close Account**: Deactivate client accounts

## 🛡️ Exception Handling

The system handles the following exceptions:

- **InsufficientSoldException**: Prevents overdrafts
- **AccountNotFoundException**: Validates account existence
- **FileAccessException**: Manages file operation errors

## 📚 User Stories Implementation

### Client Stories ✅
- [x] Transaction history per account
- [x] Automatic .txt file logging
- [x] Balance consultation
- [x] Deposit/Withdrawal operations
- [x] Bank statement consultation
- [x] Insufficient balance error handling
- [x] Negative amount validation

### Manager Stories ✅
- [x] Single ownership per account
- [x] Account creation/closure
- [x] Client information updates
- [x] Client bank statement access

### Developer Stories 
- [x] Robust file access management
- [x] Comprehensive exception handling

## 🎁 Bonus Features

- **Premium Account Types**: Enhanced accounts with special benefits
- **Transaction Categories**: Detailed transaction classification
- **Account Interest Calculation**: Automatic interest for savings accounts
- **Monthly Statements**: Automated monthly report generation

## 🧪 Testing

### Manual Testing Scenarios

1. **Account Creation Flow**
   - Create manager account
   - Create client with multiple accounts
   - Verify account ownership

2. **Transaction Flow**
   - Perform deposits, withdrawals, transfers
   - Verify balance updates
   - Check transaction file generation

3. **Error Handling**
   - Test insufficient balance scenarios
   - Validate negative amount handling
   - Test non-existent account access


#### AccountService
```java
public class AccountService {
    public void createAccount(Account account)
    public Account findAccount(String accountNumber)
    public void deposit(Account account, double amount)
    public void withdraw(Account account, double amount)
    public void transfer(Account source, Account destination, double amount)
}
```

