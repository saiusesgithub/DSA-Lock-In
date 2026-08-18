18/08/2026 - 

1. AND (&)

Rule:
Both bits must be 1 → result is 1.

0 & 0 = 0
0 & 1 = 0
1 & 0 = 0
1 & 1 = 1

Example:

  0101  (5)
& 0011  (3)
------
  0001  (1)

Think: BOTH must be 1.

---

2. OR (|)

Rule:
At least one bit must be 1 → result is 1.

0 | 0 = 0
0 | 1 = 1
1 | 0 = 1
1 | 1 = 1

Example:

  0101  (5)
| 0011  (3)
------
  0111  (7)

Think: AT LEAST ONE must be 1.

---

3. XOR (^)

Rule:
Different bits → 1
Same bits      → 0

0 ^ 0 = 0
0 ^ 1 = 1
1 ^ 0 = 1
1 ^ 1 = 0

Example:

  0101  (5)
^ 0011  (3)
------
  0110  (6)

Think: DIFFERENT → 1.

---
---

⭐ Two important XOR properties

1. a ^ a = 0
Any number XOR itself cancels out.


Example:
5 ^ 5
  0101
^ 0101
------
  0000

2. a ^ 0 = a
XOR with 0 does nothing.

Example:
5 ^ 0
  0101
^ 0000
------
  0101


a ^ a = 0    → same number cancels
a ^ 0 = a    → zero changes nothing

These two are especially important because later you'll see stuff like:

4 ^ 1 ^ 2 ^ 1 ^ 2


= 4 ^ (1 ^ 1) ^ (2 ^ 2)
= 4 ^ 0 ^ 0
= 4

---

4. Two's Complement — Representing Negative Numbers

Computers use two's complement to represent negative integers.
For learning, use 8 bits.

Positive numbers are represented normally:

5 = 00000101
3 = 00000011

Converting positive → negative

To represent -n:

1. Write binary of +n
2. Flip every bit
3. Add 1

Example: -5

+5 = 00000101

Flip:
     11111010


Add 1:
     11111011


Therefore:

-5 = 11111011

MSB / Sign Bit

For signed binary numbers, the leftmost bit is the Most Significant Bit (MSB).

0xxxxxxx → positive / zero
1xxxxxxx → negative

Example using 8 bits:

00000101 → positive
11111011 → negative

Java int uses 32 bits.

Range of int:
-2³¹ to 2³¹ - 1

5. Converting Two's Complement → Decimal

If the MSB is 1, the number is negative.

To find its magnitude:

1. Subtract 1
2. Flip every bit
3. Convert to decimal
4. Add negative sign

Example:

Given:
11111010

MSB = 1, so it's negative.

11111010
-      1
--------
11111001


Flip:
00000110

00000110 = 6

Therefore:

11111010 = -6

Easy way to remember
Decimal → Negative binary:
FLIP + ADD 1

Negative binary → Decimal magnitude:
SUBTRACT 1 + FLIP

6. Bitwise NOT ~

NOT works on one number and flips every bit:

0 → 1
1 → 0

Example using 8 bits:

5 = 00000101

~5:
    11111010

11111010 is a negative two's-complement number.

We just calculated:

11111010 = -6

Therefore:

~5 = -6

Important NOT formula
~n = -(n + 1)

Examples:

~5 = -(5 + 1)
   = -6

~1 = -(1 + 1)
   = -2


---

7. Left Shift <<
Left shift moves all bits left by k positions.

5 = 00000101

5 << 1
= 00001010
= 10

5 << 2
= 00010100
= 20

For normal positive integers without overflow:
```
n << k = n × 2^k
```

So:

6      = 6
6 << 1 = 12
6 << 2 = 24
6 << 3 = 48

Each shift left effectively multiplies by 2.

8. Right Shift >>

Right shift moves all bits right by k positions.

For positive numbers:

24 = 00011000

24 >> 1
= 00001100
= 12


24 >> 3
= 00000011
= 3

For positive integers:

n >> k = floor(n / 2^k)

Example:

13 = 00001101


13 >> 1
= 00000110
= 6

The fractional part is discarded.

9. Right Shift with Negative Numbers

Java's >> is an arithmetic right shift.

It preserves the sign.

For a positive number, new bits on the left are 0:

00001000   (+8)
>> 1
--------
00000100   (+4)

For a negative number, new bits on the left are 1:

11111000   (-8)    // shown using 8 bits
>> 1
--------
11111100   (-4)

So:

>> → sign-preserving right shift

10. Unsigned Right Shift >>> — Java

Java also provides:

>>>

Unlike >>, it always inserts 0 from the left, even if the number is negative.

>>   → preserves sign
>>>  → always inserts 0

For now, just know >>> exists. We don't need to go deep into it yet.
```
Shift Cheat Sheet
<<   Left Shift
     move bits left
     roughly multiply by 2^k


>>   Right Shift
     move bits right
     roughly divide by 2^k
     preserves sign


>>>  Unsigned Right Shift
     move bits right
     always insert 0 from left
```