# Bit Manipulation — Day 4
## 22/08/2026

Today's plan:
- ~20 minutes learning
- Then LeetCode

Main concepts covered:
1. Revisiting n & (n - 1)
2. Isolating the rightmost set bit using n & -n
3. Binary addition refresher
4. Odd/even using bit manipulation


# 1. Revisiting n & (n - 1)

Important operation:

n & (n - 1)

This REMOVES the rightmost set bit from n.

## Why?

Take:

n = 12

12 = 1100

Subtract 1:

12     = 1100
12 - 1 = 1011

Notice what happens when we subtract 1:

1100
   ↓
1011

The rightmost set bit becomes 0.

All the zeroes after that rightmost set bit become 1.

Everything before the rightmost set bit remains unchanged.


General pattern:

xxxx1000
    ↓ -1
xxxx0111


Now AND the two numbers:

xxxx1000
&
xxxx0111
--------
xxxx0000


At the rightmost set bit:

1 & 0 = 0

For all bits after it:

0 & 1 = 0

Therefore the rightmost set bit disappears.


Example:

n = 12

n     = 1100
n - 1 = 1011

  1100
& 1011
------
  1000


Therefore:

n & (n - 1)

→ removes the rightmost set bit


# 2. Applications of n & (n - 1)

We have already encountered this operation in multiple problems.


## Application 1 — Power of Two

Every positive power of 2 contains exactly ONE set bit.

Examples:

1  = 0001
2  = 0010
4  = 0100
8  = 1000
16 = 10000


If there is exactly one set bit:

n & (n - 1)

removes that one bit and gives:

0


Example:

8 = 1000
7 = 0111

1000
&
0111
----
0000


Therefore, for positive n:

(n & (n - 1)) == 0

means n is a power of 2.


Important:

Always handle:

n <= 0

because 0 should NOT be considered a power of 2.


## Application 2 — Counting Set Bits

Since:

n & (n - 1)

removes exactly ONE set bit, we can repeatedly perform it and count how many operations are needed before n becomes 0.

Example:

n = 12 = 1100

First:

1100
&
1011
----
1000

One set bit removed.


Second:

1000
&
0111
----
0000

Another set bit removed.


Number of operations = 2

Therefore:

12 has 2 set bits.


Conceptually:

count = 0

while (n != 0) {
    n = n & (n - 1);
    count++;
}


This is useful for problems such as:

LeetCode 191 — Number of 1 Bits


# 3. Remove vs Isolate Rightmost Set Bit

Today we learned another important operation:

n & -n


This does NOT remove the rightmost set bit.

Instead:

n & -n

→ ISOLATES the rightmost set bit


So remember the difference:

n & (n - 1)
→ REMOVE rightmost set bit

n & -n
→ ISOLATE rightmost set bit


# 4. Understanding n & -n

To understand this, we revisited two's complement.

For a negative integer:

-n

we can obtain its binary representation by:

1. Flip all bits of n
2. Add 1


Example:

n = 12

Using 8 bits:

+12 = 00001100


Step 1 — Flip all bits:

00001100
↓
11110011


Step 2 — Add 1:

  11110011
+ 00000001
----------
  11110100


Therefore:

-12 = 11110100


Now:

 n  = 00001100
-n  = 11110100

      00001100
    & 11110100
    ----------
      00000100


Result:

00000100 = 4


Look at 12:

12 = 00001100
          ↑
      rightmost set bit


The result contains ONLY that bit:

00000100


Therefore:

n & -n

isolates the rightmost set bit.


# 5. Binary Addition Refresher

While calculating two's complement, we briefly revised binary addition.

Basic rules:

0 + 0 = 0

0 + 1 = 1

1 + 0 = 1

1 + 1 = 10


For:

1 + 1 = 10

we:

write 0
carry 1


If there is already a carry:

1 + 1 + 1 = 11

we:

write 1
carry 1


Example:

  11110011
+ 00000001
----------
  11110100


Starting from the right:

1 + 1 = 10

write 0
carry 1


Next:

1 + carry 1 = 10

write 0
carry 1


Next:

0 + carry 1 = 1

write 1
carry ends


Everything else stays unchanged.


# 6. Useful Pattern When Adding 1 in Binary

When adding 1:

Starting from the right:

- consecutive 1s become 0
- stop when the first 0 is found
- that 0 becomes 1


Example:

00101111
+      1
--------
00110000


So:

...01111

becomes:

...10000


This pattern is also useful for understanding two's complement and n - 1.


# 7. Practice — Isolating Rightmost Set Bit

We tested:

n = 40

40 = 00101000


The rightmost set bit is:

00101000
    ↑


Therefore:

40 & -40

should produce:

00001000


Decimal:

8


So:

40 & -40 = 8


This confirmed the idea:

n & -n
→ isolate rightmost set bit


# 8. Important Pair to Remember

REMOVE:

n & (n - 1)


ISOLATE:

n & -n


Example:

n = 12 = 1100


REMOVE:

1100
&
1011
----
1000


ISOLATE:

00001100
&
11110100
--------
00000100


So:

n & (n - 1)
→ 1000

n & -n
→ 0100


# 9. Odd and Even Numbers in Binary

We then noticed a very simple property of binary numbers.

Examples:

4 = 0100
5 = 0101
6 = 0110
7 = 0111
8 = 1000
9 = 1001


Look only at the rightmost bit.


EVEN numbers:

4 = 0100
6 = 0110
8 = 1000

Rightmost bit = 0


ODD numbers:

5 = 0101
7 = 0111
9 = 1001

Rightmost bit = 1


Therefore:

Even number
→ bit 0 = 0

Odd number
→ bit 0 = 1


# 10. Why Does the Rightmost Bit Determine Odd/Even?

Binary positions represent powers of 2:

... 16  8  4  2  1
                  ↑
                 2^0


Every position except the last represents an even value:

2
4
8
16
32
...


The only position capable of adding 1 is:

2^0 = 1


Therefore:

rightmost bit = 0
→ number is even

rightmost bit = 1
→ number is odd


# 11. Checking Odd/Even Using a Bit Mask

To check bit position 0:

mask = 1 << 0

which is simply:

0001


Therefore:

n & 1


Example:

13 = 1101

  1101
& 0001
------
  0001


Non-zero result:

13 is odd.


Example:

12 = 1100

  1100
& 0001
------
  0000


Result = 0:

12 is even.


Therefore:

(n & 1) == 0
→ EVEN

(n & 1) != 0
→ ODD


# 12. Today's Three Main Bit Tricks

REMOVE rightmost set bit:

n & (n - 1)


ISOLATE rightmost set bit:

n & -n


CHECK ODD/EVEN:

n & 1


Mental model:

n & (n - 1)
→ remove a 1

n & -n
→ keep only the rightmost 1

n & 1
→ inspect the rightmost bit

---

# Today's Final Cheat Sheet

RIGHTMOST SET BIT:

n & (n - 1)
→ removes it


n & -n
→ isolates it


ODD / EVEN:

n & 1

0     → even
non-0 → odd


BIT MASK:

1 << i
→ creates a 1 at position i


POWER OF TWO:

positive n
+
(n & (n - 1)) == 0


POWER OF FOUR:

exactly one set bit
+
set bit occurs at an even position


# Biggest Takeaway

Don't memorize:

n & (n - 1)
n & -n
n & 1

as random formulas.

Understand what each expression does to the binary representation:

n & (n - 1)
→ delete the rightmost 1

n & -n
→ keep only the rightmost 1

n & 1
→ inspect bit 0

Once the binary behavior makes sense, the formulas become much easier to reconstruct during a problem.