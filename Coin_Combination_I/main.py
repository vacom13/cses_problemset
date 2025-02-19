
mod=10**9+7

def main():
    n, x = [int(i) for i in input().split()]
    coins = [int(i) for i in input().split()]
    dp = [0 for i in range(x+1)]
    coins.sort()
    print(coinCombinations(n, x, coins, dp))

def coinCombinations(n, x, coins, dp):
    dp[0] = 1
    for i in range(1, x+1):
        for coin in coins:
            if i-coin < 0:
                break
            if dp[i-coin] == 0:
                continue
            dp[i] +=dp[i-coin]
            dp[i] %= mod
    return dp[-1]

if __name__ == "__main__":
    main()