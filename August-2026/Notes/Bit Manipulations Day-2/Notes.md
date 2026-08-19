# Bit Manipulation — Day 2 Notes
## 19/08/2026

Yesterday we learned the fundamental operators:

&    AND
|    OR
^    XOR
~    NOT

<<   Left Shift
>>   Right Shift
>>>  Unsigned Right Shift

Today we learned how to combine these operators with bit masks to manipulate individual bits.


# 1. Bit Positions

Bits are numbered starting from the rightmost bit, beginning at 0.

Example:

n = 13

Binary:
1101

Positions:

3 2 1 0
-------
1 1 0 1

Therefore:

bit 0 = 1
bit 1 = 0
bit 2 = 1
bit 3 = 1

A bit containing 1 is called a set bit.

A bit containing 0 is called an unset/clear bit.

So for 13:

1101

Set bits:
0, 2, 3

Unset bit:
1

Important terminology:

"Is bit i set?"
→ Is bit i currently 1?

"Set bit i"
→ Change bit i to 1.

These mean different things.


# 2. Bit Mask

A bit mask lets us target a particular bit without affecting/checking every other bit.

Suppose:

n = 13 = 1101

and we want to work with bit 2.

We want:

0100

because only bit position 2 is 1.

Instead of manually constructing it, start with:

1 = 0001

and left shift:

1 << 2

0001
  ↓
0100

Therefore:

mask = 1 << i

creates a number containing a single 1 at position i.

Examples:

1 << 0 = 0001
1 << 1 = 0010
1 << 2 = 0100
1 << 3 = 1000

This becomes the foundation for checking, setting, clearing and toggling bits.


# 3. Check Whether the ith Bit Is Set

Suppose:

n = 13 = 1101

We want to check bit 2.

Create the mask:

1 << 2 = 0100

Now use AND:

  1101
& 0100
------
  0100

The result is non-zero.

Therefore:

bit 2 is SET

Why does AND work?

Because:

1 & 1 = 1
0 & 1 = 0

The mask contains 1 only at the position we care about.

## General idea

mask = 1 << i

n & mask

If:

(n & mask) != 0

then the bit is set.

If:

(n & mask) == 0

then the bit is unset.

## Example with an unset bit

n = 10 = 1010

Check bit 2:

mask = 0100

  1010
& 0100
------
  0000

Therefore bit 2 is unset.


# 4. Set the ith Bit

Set means:

force the target bit to become 1

Suppose:

n = 10 = 1010

Set bit 2.

We want:

1010
 ↓
1110

Create the mask:

1 << 2 = 0100

Use OR:

  1010
| 0100
------
  1110

Therefore:

n | (1 << i)

sets bit i.

Why OR?

At the target position:

0 | 1 = 1
1 | 1 = 1

So regardless of its previous value, it becomes 1.

For all other positions the mask contains 0:

0 | 0 = 0
1 | 0 = 1

so those bits remain unchanged.

## Example

10 = 1010

Set bit 2:

1010 | 0100
= 1110
= 14


# 5. Clear the ith Bit

Clear means:

force the target bit to become 0

Suppose:

n = 14 = 1110

Clear bit 2.

Desired result:

1110
 ↓
1010

Our normal mask is:

1 << 2

0100

But AND with 0100 would destroy the other bits.

Instead, invert the mask using NOT:

~0100
= 1011

Now the mask contains:

target position → 0
everything else → 1

AND:

  1110
& 1011
------
  1010

Therefore:

n & ~(1 << i)

clears bit i.

Why?

At the target:

1 & 0 = 0
0 & 0 = 0

so it becomes 0.

Everywhere else:

x & 1 = x

so the original bits remain unchanged.


# 6. Toggle the ith Bit

Toggle means flip the bit:

0 → 1
1 → 0

We need an operator with exactly that behavior.

XOR:

0 ^ 1 = 1
1 ^ 1 = 0

And XOR with zero leaves a bit unchanged:

0 ^ 0 = 0
1 ^ 0 = 1

Therefore create:

mask = 1 << i

and XOR:

n ^ mask

## Example

n = 10 = 1010

Toggle bit 2:

mask = 0100

  1010
^ 0100
------
  1110

Toggle the exact same bit again:

  1110
^ 0100
------
  1010

So XOR naturally behaves like an on/off switch.


# 7. The Four Fundamental Bit Operations

This is the important summary:

CHECK ith bit

mask = 1 << i

n & mask


SET ith bit to 1

n | (1 << i)


CLEAR ith bit to 0

n & ~(1 << i)


TOGGLE ith bit

n ^ (1 << i)


But don't memorize only the formulas.

Remember why each operator is used:

CHECK  → AND isolates the target bit

SET    → OR with 1 forces it to 1

CLEAR  → AND with 0 forces it to 0

TOGGLE → XOR with 1 flips it

That's much more useful than memorizing four expressions.


# 8. Practice Done Today

You manually solved exercises for all four operations.

For:

13 = 1101

checking bit 2:

mask = 0100

1101 & 0100
= 0100

→ SET


For:

10 = 1010

checking bit 2:

1010 & 0100
= 0000

→ UNSET


You also correctly performed:

Set bit
Clear bit
Toggle a set bit
Toggle an unset bit

and then did the combined exercise:

22 = 10110

positions:
4 3 2 1 0
1 0 1 1 0

including independently checking/setting/clearing/toggling different positions.

So this section is good enough to move forward rather than drilling the same operation repeatedly.


