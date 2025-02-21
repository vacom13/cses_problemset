

mod = 10**9 + 7

def main():
    n = int(input())
    arr = []
    for i in range(n):
        arr.append(input())
    dp = [[0 for _ in range(n+1)] for _ in range(n+1)]
    if(arr[-1][-1] != '*'):
        dp[-1][-1] = 1
    for i in range(n,0,-1):
        for j in range(n,0,-1):
            if(arr[i-1][j-1] == '*'):
                dp[i][j] = 0
                continue
            if(j<n):
                dp[i][j] += dp[i][j+1]
            if i < n:
                dp[i][j] += dp[i+1][j]
            dp[i][i] %= mod
    print(dp[1][1])




if __name__ == '__main__':
    main()