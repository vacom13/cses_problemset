def main():
    n, x = [int(i) for i in input().split()]
    prices = [int(i) for i in input().split()]
    pages = [int(i) for i in input().split()]
    dp = [[0 for j in range (x+1)] for i in range(2)]

    # Maximum number of pages that can be bought when I have i number of books and 0 funds with me.
    for numberOfBooks in range(1, n+1):
        for money in range(x+1):
            #  if I but the current book
            priceCbook = prices[numberOfBooks-1]
            pagesCbook = pages[numberOfBooks-1]
            if priceCbook <= money:
                dp[1][money] =  pagesCbook + dp[0][money-priceCbook]
            dp[1][money] = max(dp[1][money], dp[0][money])
        for money in range(x+1):
            dp[0][money] = dp[1][money]
            dp[1][money] = 0
    print(dp[0][x])

if __name__ == '__main__':
    main()