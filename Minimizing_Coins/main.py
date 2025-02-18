def main():
    input1 =  [int(i) for i in input().split()]
    n = input1[0]
    x = input1[1]
    c = [int(i) for i in input().split()]
    c.sort()
    cols =  x+1
    arr = [float('inf') for _ in range(cols)]
    arr[0] = 0
    for i in range(1, cols):
        for coin in c:
            if i - coin < 0:
                break
            arr[i] = min(arr[i], arr[i-coin]+1)
    print(arr[x] if arr[x] != float('inf') else -1)

if __name__ == "__main__":
    main()