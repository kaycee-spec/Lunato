rate = 0.92

prices_usd = [float(input(f"Enter price for product {i+1} in USD: ")) for i in range(6)]

prices_eur = [price * rate for price in prices_usd]

for i in range(6):
    print(f"Product {i+1}: ${prices_usd[i]:.2f} USD = €{prices_eur[i]:.2f} EUR")
    