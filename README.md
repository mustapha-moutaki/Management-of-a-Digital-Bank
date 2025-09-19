# Digital Bank Management System

A Java-based console application for managing digital banking operations with separate interfaces for clients and bankers.

## Project Structure

```
src/
├── entities/
│   ├── Person.java          # Abstract base class for all persons
│   ├── Client.java          # Client entity extending Person
│   ├── Gestionnaire.java    # Banker/Manager entity extending Person
│   ├── Account.java         # Account entity with transaction history
│   ├── AccountType.java     # Enum for account types (CURRENT, SAVINGS)
│   └── Transaction.java     # Transaction entity for tracking operations
├── exceptions/
│   ├── AccountInexistantException.java  # Custom exception for non-existent accounts
│   └── SoldInsuffisantException.java    # Custom exception for insufficient funds
├── services/
│   ├── ClientService.java   # Business logic for client operations
│   └── AccountService.java  # Business logic for account operations
├── repository/
│   └── AccountRepository.java  # Data access layer for accounts
├── ui/
│   └── Menu.java           # User interface and menu system
└── Main.java               # Application entry point
```

## Features

### Client Features
- **User Authentication**: Login and registration system
- **Account Management**:
    - Create new accounts (Current or Savings)
    - View all accounts
    - Check account balance and transaction history
- **Financial Operations**:
    - Deposit money into accounts
    - Withdraw money from accounts
    - Transfer money between accounts
- **Transaction History**: Complete transaction tracking with timestamps

### Banker Features
- *Coming Soon* - Banker interface for administrative operations

## How to Run

1. **Compile the project**:
   ```bash
   javac -d . src/entities/*.java src/exceptions/*.java src/services/*.java src/ui/*.java src/Main.java
   ```

2. **Run the application**:
   ```bash
   java Main
   ```

## Usage Guide

### Getting Started
1. Launch the application
2. Choose your role:
    - **Client**: For banking customers
    - **Gestionnaire**: For bank staff (coming soon)

### Client Operations

#### 1. Login/Register
- **Register**: Create a new client account with personal information
- **Login**: Access existing client account using client ID

#### 2. Account Management
- **Create Account**:
    - Enter account number
    - Set initial balance
    - Choose account type (Current or Savings)
- **View All Accounts**: See all accounts associated with your client profile

#### 3. Financial Operations
- **Deposit**: Add money to any of your accounts
- **Withdraw**: Remove money from accounts (with balance validation)
- **Transfer**: Move money between your own accounts

#### 4. Account Information
- **View Balance & History**:
    - Check current account balance
    - View complete transaction history
    - See transaction details (date, type, amount, source, destination)

## Technical Details

### Key Classes

#### Client
- Extends `Person` abstract class
- Contains a HashMap of accounts
- Unique client ID for identification

#### Account
- Supports multiple account types (Current, Savings)
- Maintains transaction history using HashSet
- Tracks balance and account details

#### Transaction
- Records all financial operations
- Includes transaction type, amount, date, and account information
- Supports deposits, withdrawals, and transfers

#### ClientService
- Manages client data using HashMap
- Provides CRUD operations for clients
- Handles client authentication and account management

### Exception Handling
- **AccountInexistantException**: Thrown when trying to access non-existent accounts
- **SoldInsuffisantException**: Thrown when attempting operations with insufficient funds

## Future Enhancements

### Planned Features
- **Banker Interface**: Complete administrative functionality for bank staff
- **AccountService**: Enhanced business logic for account operations
- **Database Integration**: Replace in-memory storage with persistent database
- **Enhanced Security**: Password encryption and secure authentication
- **Advanced Reporting**: Financial reports and analytics
- **Multi-currency Support**: Support for different currencies
- **Interest Calculations**: Automatic interest calculations for savings accounts

## Development Notes

- The application uses in-memory storage (HashMaps) for simplicity
- All data is lost when the application is closed
- Transaction IDs are generated using system timestamps
- Account numbers are user-defined strings
- The system supports multiple accounts per client

## Requirements

- Java 8 or higher
- No external dependencies required

## Contributing

This is a learning project demonstrating object-oriented programming principles, exception handling, and basic banking system architecture in Java.

## License

This project is for educational purposes.
