mod = 10**9 + 7

def main():

    n, x = [int(i) for i in input().split()]
    coins = [int(c) for c in input().split()]
    coins.sort()
    dp = [0 for i in range(x+1)]
    dp[0] = 1
    for coin in coins:
        for i in range(coin, x+1):
            dp[i] += dp[i-coin]
            dp[i] %= mod
    print(dp[-1])

if __name__ == "__main__":
    main()