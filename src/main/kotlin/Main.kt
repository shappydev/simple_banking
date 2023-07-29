fun main() {
    val accounts = mutableMapOf<String, Double>()
    println("Welcome to the Simple Banking System!")
    while (true) {
        println("What do you want to do?")
        println("1. Create an account")
        println("2. Deposit money")
        println("3. Withdraw money")
        println("4. Check account balance")
        println("5. Exit")

        val choice = readlnOrNull()?.toIntOrNull() ?: continue

        when (choice) {
            1 -> {
                println("Enter your name to create an account:")
                val name = readlnOrNull()?.trim()
                if(!name.isNullOrEmpty()) {
                    if(accounts.containsKey(name)) {
                        println("Account already exists for $name.")
                    } else {
                        accounts[name] = 0.0
                        println("Account created successfully for $name.")
                    }
                } else {
                    println("Invalid input. Please enter a valid name.")
                }
            }
            2 -> {
                println("Enter your name to deposit money:")
                val name = readlnOrNull()?.trim()
                if(name != null && accounts.containsKey(name)) {
                    println("Enter the amount to deposit:")
                    val depositAmount = readlnOrNull()?.toDoubleOrNull()
                    if(depositAmount != null && depositAmount > 0) {
                        accounts[name] = accounts[name]!! + depositAmount
                        println("Deposit successful. Your current balance is: ${accounts[name]}")
                    } else {
                        println("Invalid input. Please enter a valid positive amount to deposit.")
                    }
                } else {
                    println("Account not found. Please create an account first.")
                }
            }
            3 -> {
                println("Enter your name to withdraw money:")
                val name = readlnOrNull()?.trim()
                if(name != null && accounts.containsKey(name)) {
                    println("Enter the amount to withdraw:")
                    val withdrawAmount = readlnOrNull()?.toDoubleOrNull()
                    if(withdrawAmount != null && withdrawAmount > 0) {
                        if(withdrawAmount <= accounts[name]!!) {
                            accounts[name] = accounts[name]!! - withdrawAmount
                            println("Withdrawal successful. Your current balance is: ${accounts[name]}")
                        } else {
                            println("Insufficient balance. You cannot withdraw more than your account balance.")
                        }
                    } else {
                        println("Invalid input. Please enter a valid positive amount to withdraw.")
                    }
                } else {
                    println("Account not found. Please create an account first.")
                }
            }
            4 -> {
                println("Enter your name to check account balance:")
                val name = readlnOrNull()?.trim()
                if(name!= null && accounts.containsKey(name)) {
                    println("Your current balance is: ${accounts[name]}")
                } else {
                    println("Account not found. Please create an account first.")
                }
            }
            5 -> {
                println("Exiting the Simple Banking System. Have a nice day!")
                return
            }
            else -> {
                println("Invalid choice. Please select a valid option.")
            }
        }
    }
}