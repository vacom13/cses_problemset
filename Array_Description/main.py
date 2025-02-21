
mod = 10**9 + 7

def main():
    n, x = [int(i) for i in input().split()]
    arr = [int(i) for i in input().split()]
    dp = [[0 for j in range(x+2)] for i in range(n + 1)]

    #  Can be optimized to O(n) space complexity
    if(arr[0] == 0):
        for j in range(1, x+1):
            dp[1][j] = 1
    else:
        dp[1][arr[0]] = 1
    
    for i in range(2,n+1):
        idx = i-1
        if arr[idx] != 0:
            dp[i][arr[idx]] = dp[i-1][arr[idx]-1] + dp[i-1][arr[idx]] + dp[i-1][arr[idx]+1]
            dp[i][arr[idx]] %= mod
            continue

        for j in range(1,x+1):
            
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j] + dp[i-1][j+1]
            dp[i][j] %= mod
    ans = 0
    for sum in dp[-1]:
        ans += sum
        ans %= mod
    print(ans)

if __name__ == '__main__':
    main()