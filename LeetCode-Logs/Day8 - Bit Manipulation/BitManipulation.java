
    // Bit Manipulation Operators -

//& → check bit
//| → set bit
//^ → toggle bit
//~ → flip ALL bits

    //| Operation | Code          | Effect          |              |
    //| --------- | ------------- | --------------- | ------------ |
    //| check     | `n & (1<<i)`  | see if bit is 1 |              |
    //| set       | `n            | (1<<i)`         | make bit = 1 |
    //| toggle    | `n ^ (1<<i)`  | flip            |              |
    //| clear     | `n & ~(1<<i)` | make bit = 0    |              |

    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------

    // AND (&)
    //A  B  A&B
    //0  0   0
    //0  1   0
    //1  0   0
    //1  1   1
    // the only time AND gives 1 is when both bits are 1

    // 5 & 3
    //5 = 101
    //3 = 011
    //now compare bit by bit (using truth table above)
    //  101
    //& 011
    //-----
    //  001
    //001 in decimal = 1
    //so 5 & 3 = 1

    // what is the intuition?
    // AND keeps only the positions where both numbers have 1

//    so you can think:
//    AND finds common set bits
//    6 = 110
//    3 = 011
//    common 1 appears only in the middle bit
//    so result = 010

//    most common use of & -
//    checking whether a bit is set
//    bit is set = that position has 1 (ON)
//    bit is not set = that position has 0 (OFF)
//    5 = 101
//
//    want to check if the last bit is 1?
//    do: 5 & 1
//
//    because:  101
//            & 001
//            -----
//              001
//    result is not 0, so yes, last bit is set

    // very common special case -
    //odd or even
    //
    //last bit tells this:
    //odd number → last bit is 1
    //even number → last bit is 0
    //n & 1
    //if result is 1 → odd
    //if result is 0 → even

    //example:
    //7 = 111
    //7 & 1 = 1  → odd
    //6 = 110
    //6 & 1 = 0  → even


//    1 in binary is 001
//    so n & 1 only checks the last bit
// we can access last bit of a number by using n&1
// 1 in binary is 001 , so we only check the last bit,
// if last bit of n is 1 , we get 1 , or else we will get 0

//    if i do n & 2, will i access second bit?”
//    YES. EXACTLY. 💯
// 6 = 0110
// 2 = 0010
// 0110
//&0010
//-----
// 0010
//2nd bit is SET

    // 🔥 GENERAL RULE
    //n & (1 << i)
    //
    //👉 checks if ith bit is set

    // check 0th bit (last bit)
    //n & 1
    //check 1st bit
    //n & 2
    //check 2nd bit
    //n & 4
    //check 3rd bit

    // 1 << i = 2^i
    //and that number has:
    //👉 only one bit = 1
    //👉 rest = 0
    //so AND isolates that bit

    //| Number | Binary | Meaning | Index
    //| ------ | ------ | ------- | ----
    //| 1      | 0001   | bit 0   | 0
    //| 2      | 0010   | bit 1   | 1
    //| 4      | 0100   | bit 2   | 2
    //| 8      | 1000   | bit 3   | 3

//    ⚡ SIMPLE RULE
//    n & (1 << i) → checks ith bit (0-based)

    // Quick Mental Model
    //n & 1 → last bit
    //n & 2 → second bit
    //n & 4 → third bit
    //n & 8 → fourth bit

    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------

    // OR Operator (|)

//  1 | 1 = 1
//  1 | 0 = 1
//  0 | 1 = 1
//  0 | 0 = 0

    // OR → “if ANY bit is 1 → result is 1”

    // OR is used to SET bits
    // 🔥 MAIN USE CASE
    //  ✅ SET a bit
    //  n | (1 << i)

    // turn ith bit → 1
    // even if it was already 1 → stays 1

    // set 1st bit in 4
    // 4 = 0100
    // 1<<1 = 0010 (2 place element -> 1st bit)
    //0100
    //0010
    //----
    //0110 = 6
    // we “turned ON” that bit

    // AND (&) → check bits
    //OR  (|) → set bits
    // OR never turns OFF bits
    //👉 it only turns ON

    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------


    // XOR Operator (^)
    // 1 ^ 1 = 0
    // 1 ^ 0 = 1
    // 0 ^ 1 = 1
    // 0 ^ 0 = 0
    // XOR → “same → 0 , different → 1”

    // XOR tells:
    //bits same → OFF
    //bits different → ON

    // 🔥 MOST IMPORTANT USE CASE
    // ✅ TOGGLE A BIT
    //n ^ (1 << i)
    //
    //👉 this will:
    //if bit = 1 → becomes 0
    //if bit = 0 → becomes 1

    //toggle 1st bit of 4
    //4 = 0100
    //1<<1 = 0010
    //0100
    //0010
    //----
    //0110 = 6
    //👉 bit turned ON

    // ⚡ MAGIC PROPERTY (VERY IMPORTANT)
    //a ^ a = 0
    //a ^ 0 = a

    // 🧠 WHY THIS IS CRAZY USEFUL
    //👉 used in:
    //finding single non-duplicate element
    //swapping without temp variable
    //bit tricks

    // 🔥 GOLDEN PATTERN
    //x ^ y ^ y = x
    //👉 duplicates cancel out

    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------
    // ---------------------------------------------------------------------------------

    // NOT/COMPLEMENT OPERATOR (~)

    // ~ flips ALL bits
    // ~1 = 0
    // ~0 = 1

//    🔍 SIMPLE EXAMPLE
//        5 = 0101
//        ~5 = 1010   (in ideal binary world)
//
//     👉 BUT WAIT ❗
//    in Java → things are different

    // ⚠️ IMPORTANT (VERY IMPORTANT)
    //👉 Java uses 32-bit signed integers (2’s complement)
    //~5 ≠ 1010
    //instead:
    //5  = 00000000 00000000 00000000 00000101
    //~5 = 11111111 11111111 11111111 11111010
    //👉 this is -6

    // 🤯 MAGIC FORMULA
    // ~n = -(n + 1)

    // 🧠 INTUITION
    //👉 NOT doesn’t just flip
    //👉 it moves you into negative numbers

    // ⚡ WHEN IS ~ USED?
    //honestly:
    //less common than &, |, ^
    //mostly used in:
    //masks
    //advanced bit tricks
    //clearing bits

    //🔥 BONUS (COMBINATION)
    //❌ CLEAR A BIT
    //n & ~(1 << i)
    //👉 steps:
    //(1 << i) → bit mask
    //~(...) → invert → everything 1 except that bit
    //& → clears that bit

    // clearing a bit = force it to 0

    //clear 1st bit of 6:
    //6 = 0110
    //1<<1 = 0010
    //~0010 = 1101
    //0110
    //1101
    //----
    //0100 = 4
    //👉 bit cleared


public class BitManipulation {
    public static void main(String[] args) {
        int[] arr = {2,2,2,3};
        System.out.println(singleNumberWith3Duplicates(arr));
    }

    static boolean isPowerOf2(int num) {
        // ChatGPT gave hint for this (check num & num-1)
        if ((num & (num - 1)) == 0) {
            return true;
        }
        return false;


        //# 🧠 WHY DOES `n & (n-1)` REMOVE THE LAST SET BIT?

        //## 🧠 OBSERVE PATTERN
        //👉 when you subtract 1:
        //1. the **rightmost 1 becomes 0**
        //2. all bits to the right become **1**
        //
        //## 🔥 EXAMPLES

        //n     = 101000
        //n - 1 = 100111

        //👉 see:
        //* that last `1` flipped to `0`
        //* everything after → `1`

        //n     = 1000
        //n - 1 = 0111

        //# ⚡ STEP 2: NOW DO AND (`&`)
        //n     = 101000
        //n-1   = 100111
        //----------------
        //        100000
        //
        //👉 WHAT HAPPENED?
        //
        //* the **last set bit got removed**
        //* rest stays same

        //# 🧠 WHY THIS WORKS
        //👉 because:
        //
        //* in `n`: last set bit = `1`
        //* in `n-1`: that same bit = `0`
        //
        //👉 AND result:
        //
        //1 & 0 = 0  ← last set bit gone
        //
        //---
        //
        //# 🔥 VISUAL INTUITION
        //
        //n:     xxxx1000
        //n-1:   xxxx0111
        //AND:   xxxx0000
        //
        //👉 only that last `1` disappears
        //
        //---
        //
        //# ⚡ KEY TAKEAWAY
        //
        //n & (n-1) → removes the rightmost set bit

        //# 🔥 NOW CONNECT TO YOUR PROBLEM
        //
        //👉 power of 2:
        //
        //1000 (only one 1)
        //
        //remove last set bit:
        //
        //1000 & 0111 = 0000
        //
        //---
        //
        //👉 NOT power of 2:
        //
        //```text
        //1100
        //```
        //
        //```text
        //1100 & 1011 = 1000 ≠ 0

        //# 🧠 FINAL SUMMARY
        //
        //n-1 → flips last set bit + everything after
        //AND → removes that bit
    }

    static int noOfSetBits(int num) {
        // DIDNT TAKE ANY HINTS
        int count = 0;
        while (num != 0) {
            num = num & num - 1; // DO THIS - num = num & (num - 1) because rn it becomes this due to precedence - num = (num & num) - 1;
            count++;
        }
        return count;
    }

    static int singleNumber(int[] arr) {
        // NO HINTS but recognised it easily cuz recently saw this usecase
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = result ^ arr[i];
        }
        return result;

//        4 ^ 1 ^ 2 ^ 1 ^ 2
//                = 4 ^ (1^1) ^ (2^2)
//                = 4 ^ 0 ^ 0
//                = 4
        // XOR is associative + commutative
    }

    static int singleNumberWith3Duplicates(int[] arr) {
        int result1 =0;
        int result2 = 0;
        for (int i : arr) {
            result1 = result1 + (i & (1<<1));
            result2 = result2 + (i & (1<<2));
        }
        String b1 = Integer.toString(result1 % 3);
        String b2 = Integer.toString(result2 % 3);
        return Integer.parseInt(b1+b2 , 2);

    }

}

