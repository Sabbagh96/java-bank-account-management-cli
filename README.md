# BankAccount

A console-based Java application demonstrating object-oriented programming, separated responsibilities, collections, validation, and custom exception handling.

## Features

- Create bank accounts with unique account numbers.
- List all stored accounts.
- Find an account by account number.
- Deposit a positive amount into an existing account.
- Withdraw funds while preventing overdrafts.
- Reject duplicate accounts and invalid amounts with custom exceptions.

## Project Structure

```text
src/com/sabbagh/bankaccount/
|-- Main.java
|-- model/
|   `-- BankAccount.java
|-- service/
|   `-- BankService.java
`-- exception/
    |-- AccountNotFoundException.java
    |-- DuplicateAccountException.java
    |-- InsufficientBalanceException.java
    `-- InvalidAmountException.java
```

## Responsibilities

- `Main` handles the command-line menu, user input, and output.
- `BankService` manages the account collection and coordinates account operations.
- `BankAccount` owns one account's state and enforces deposit and withdrawal rules.
- Custom exceptions describe invalid business operations.

## Requirements

- JDK 17 or newer

The project was tested with JDK 21.

## Run on Windows PowerShell

From the repository root:

```powershell
$sourceFiles = Get-ChildItem -Recurse -Filter *.java src
javac -d out $sourceFiles.FullName
java -cp out com.sabbagh.bankaccount.Main
```

## Run on macOS or Linux

From the repository root:

```bash
mkdir -p out
javac -d out $(find src -name "*.java")
java -cp out com.sabbagh.bankaccount.Main
```

## Menu

```text
1. Add account
2. Show all accounts
3. Deposit
4. Withdraw
5. Find account
0. Exit
```

## Concepts Practiced

- Classes and objects
- Constructors and encapsulation
- Command and query methods
- Object references and collections
- Packages and imports
- Service and domain responsibilities
- Validation and custom runtime exceptions
- Defensive copying of an internal `ArrayList`

## Current Scope

This is an in-memory learning project. Account data is lost when the application exits.

The project uses `double` to keep the first implementation beginner-friendly. Production financial software should use `BigDecimal` or a dedicated money type to avoid floating-point precision errors.

Potential future improvements include persistent storage, automated tests, safer console-input handling, and a REST API.
