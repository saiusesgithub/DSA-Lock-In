# 🚀 DSL Lock-In — Day 2

📅 Date: 26 March 2026

---

## 🔥 Focus of the Day

Collections in Java (ArrayList, HashMap, HashSet) + Practical Problem Solving

---

## 📚 Topics Covered

### 1. ArrayList

* Dynamic array (resizable)
* Stores objects (`Integer`, not `int`)

#### Core Operations:

* `add()` → insert element
* `get()` → access element
* `set()` → update element
* `remove()` → remove by index
* `size()` → length

#### Key Learning:

* Removing elements shifts remaining elements (no gaps)
* Loop adjustment needed (`i--`) OR iterate backwards

---

### 2. HashMap (Core DSA Tool)

* Key → Value mapping
* Used for counting, tracking, lookup

#### Core Operations:

* `put()` → insert/update
* `get()` → fetch value
* `containsKey()` → check existence


#### Key Learning:

* HashMap is **unordered**
* Must use original structure (like string/array) to preserve order

---

### 3. HashSet

* Stores only unique elements
* Fast lookup for existence

#### Core Operations:

* `add()` → insert
* `contains()` → check
* `remove()` → delete

#### Key Learning:

* No indexing
* No guaranteed order
* Ideal for duplicate detection

---

## 💻 Programs Implemented

### ArrayList

* Input elements into ArrayList
* Sum of elements
* Removed even numbers (using new list + in-place logic understanding)

---

### HashMap

* Frequency count of characters in string
* First non-repeating character (fixed using second traversal)
* Anagram check using 2 HashMaps

    * Fixed issues:

        * wrong map usage
        * null checks
        * length check placement

---

### HashSet

* Removed duplicates from array
* Checked if array contains duplicates (size comparison trick)
* Found first repeating element (using fresh set)

---

## 🧠 Key Learnings

### Core Concepts

* ArrayList = dynamic array with shifting behavior
* HashMap = counting + mapping tool
* HashSet = uniqueness + existence checking

---

### Problem Solving Patterns

* Frequency → HashMap
* Existence → HashSet
* Order-sensitive problems → iterate original structure

---

### Debugging Insights

* Order matters (HashMap ≠ ordered)
* Always consider edge cases (null, duplicates, empty cases)

---

## ⚠️ Mistakes Identified & Fixed

* Incorrect frequency updates
* Ignoring unordered nature of HashMap
* Loop skipping due to index shifts

---

## 📌 Overall Progress

* Shifted from syntax → data structure thinking
* Started using correct tools for problems
* Improved debugging and logical reasoning

---

## 🧠 Level Update

From: Basic Java
To: Early DSA (Collections + Patterns)

---
