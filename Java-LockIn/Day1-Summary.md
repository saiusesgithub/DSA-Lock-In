# 🚀 DSL Lock-In — Day 1

📅 Date: 25 March 2026

---

## 🔥 Focus of the Day

Core Java + DSA Foundations (Fast-paced revision + implementation)

---

## 📚 Topics Covered

### 1. Core Java Basics (Quick Revision)

* Syntax structure (`main` method, class-based)
* Data types: `int`, `double`, `char`, `String`, `boolean`
* Input handling using `Scanner`

    * `nextInt()`, `next()`, `nextLine()`
    * ⚠️ newline issue after `nextInt()`
* Operators: arithmetic, comparison, logical
* Control flow:

    * `if-else`
    * loops (`for`, `while`)
    * `break`, `continue`

---

### 2. Arrays (Important Foundation)

* Declaration:

    * `int[] arr = new int[n]`
    * `int[] arr = {1,2,3}`
* Traversal:

    * index-based loop
    * enhanced for-loop
* 2D arrays basics (`grid[i][j]`)

#### Patterns learned:

* Sum of array
* Maximum element
* Minimum element
* Reverse array (in-place logic)

#### Key Insight:

Every array problem = traversal + condition + update

---

### 3. Functions / Methods

* Method structure:

    * return type, parameters
* `void` vs non-void
* Method calls from `main`
* Method overloading (intro)

#### Concepts:

* Pass by value
* Local scope
* Avoid putting all logic in `main`

---

### 4. Strings (Java-Specific Behavior)

* `String` vs `char[]`
* Immutability (String does not change in-place)
* Important methods:

    * `length()`, `charAt()`, `substring()`, `equals()`
* ⚠️ `==` vs `.equals()` (critical difference)

#### Character handling:

* `charAt()` returns primitive → cannot chain methods
* Use `Character.toLowerCase(c)`

#### Preprocessing concept:

* Convert to lowercase
* Remove spaces

---

## 💻 Programs Implemented

### Arrays

* Sum of array
* Average of array (fixed integer division issue)
* Attempted second largest element (logic refinement needed)

---

### Functions

* `sum(int[] arr)` → returns sum
* `max(int[] arr)` → returns maximum

---

### Strings

* Vowel count (initial uppercase-only → improved with lowercase handling)
* Palindrome check (logic improved: half traversal + preprocessing)

---

### Prime Check (Started)

* Learned optimized condition: `i * i <= n`
* Implementation pending refinement

---

## 🧠 Key Learnings

### Java-Specific

* Strings are immutable
* `.equals()` vs `==`
* `return` exits entire function (not just loop)
* `char` is primitive → no method chaining

---

### Problem Solving

* Identifying logic bugs (index misuse, wrong conditions)
* Importance of edge cases
* Thinking in patterns (especially arrays)

---

## ⚠️ Pending (To Fix / Complete)

* Prime function (final correct implementation)
* Advanced array problems (skipped for now)

---

## 🔜 Next Focus (Day 2 Preview)

Apart from planned stuff for day 2 , 

These are pending from day 1 -

* Collections:

    * ArrayList
    * HashMap
    * HashSet
* Frequency counting

---
