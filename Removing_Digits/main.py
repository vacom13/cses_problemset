def main():
    n = int(input())
    dp = [float('inf') for i in range(n+1)]
    dp[0] = 0
    ans = 0
    while(n > 0):
        number = n
        m = -1
        while(number > 0):
            m = max(m, number % 10)
            number //= 10
        n -= m
        ans += 1
    print(ans)

if __name__ == "__main__":
    main()