// Every "ugly" number (except 1) can be formed by multiplying a smaller ugly number by 2, 3, or 5.

// So let's say that the ugly numbers found so far are [1,2,3,4,5]. Based on that list we can generate three sequences of ugly numbers:

// Multiplying by 2, the possible ugly numbers are [2,4,6,8,10]
// Multiplying by 3, the possible ugly numbers are [3,6,9,12,15]
// Multiplying by 5, the possible ugly numbers are [5,10,15,20,25]

// But we already have 2,3,4, and 5 in the list, so we don't care about values less than or equal to 5. Let's mark those entries with a - to indicate that we don't care about them

// Multiplying by 2, the possible ugly numbers are [-,-,6,8,10]
// Multiplying by 3, the possible ugly numbers are [-,6,9,12,15]
// Multiplying by 5, the possible ugly numbers are [-,10,15,20,25]

// And in fact, all we really care about is the smallest number in each sequence

// Multiplying by 2, the smallest number greater than 5 is 6
// Multiplying by 3, the smallest number greater than 5 is 6
// Multiplying by 5, the smallest number greater than 5 is 10

// After adding 6 to the list of ugly numbers, each sequence has one additional element:

// Multiplying by 2, the possible ugly numbers are [-,-,-,8,10,12]
// Multiplying by 3, the possible ugly numbers are [-,-,9,12,15,18]
// Multiplying by 5, the possible ugly numbers are [-,10,15,20,25,30]

// But the elements from each sequence that are useful are:

// Multiplying by 2, the smallest number greater than 6 is 8
// Multiplying by 3, the smallest number greater than 6 is 9
// Multiplying by 5, the smallest number greater than 6 is 10

// So you can see that what the algorithm is doing is creating three sequences of ugly numbers. Each sequence is formed by multiplying all of the existing ugly numbers by one of the three factors.

// But all we care about is the smallest number in each sequence (larger than the largest ugly number found so far).

// So the indexes i2, i3, and i5 are the indexes into the corresponding sequences. When you use a number from a sequence, you update the index to point to the next number in that sequence.