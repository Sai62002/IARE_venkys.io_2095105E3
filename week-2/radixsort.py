def radix_sort(arr):
    max_num = max(arr)
    exp = 1
    while max_num // exp > 0:
        count = [0] * 10
        for i in range(len(arr)):
            index = arr[i] // exp
            count[index % 10] += 1
        for i in range(1, 10):
            count[i] += count[i-1]
        output = [0] * len(arr)
        i = len(arr) - 1
        while i >= 0:
            index = arr[i] // exp
            output[count[index % 10] - 1] = arr[i]
            count[index % 10] -= 1
            i -= 1
        for i in range(len(arr)):
            arr[i] = output[i]
        exp *= 10
    return arr
