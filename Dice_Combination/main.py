mod = 10**9 + 7

def main():
    n = int(input())
    dp = []
    for i in range(5):
        dp.append(0)  
    dp.append(1)
    for i in range(len(dp), len(dp)+n):
        temp=(dp[i-1] + dp[i-2] + dp[i-3] + dp[i-4] + dp[i-5] + dp[i-6]) % mod
        dp.append(temp)

    # print(dp)
    print(dp[-1])

if __name__ == "__main__":
    main()