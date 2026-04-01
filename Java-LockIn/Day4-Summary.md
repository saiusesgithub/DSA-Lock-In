# 🚀 DSA Lock-In — Day 4

📅 Date: 28 March 2026

---

## 🔥 Focus of the Day

Recursion + Linked List Basics (Core DSA Entry)

---

## 📚 Topics Covered

### 1. Recursion

* Factorial
* Recursive Sum
* Fibonacci

#### Key Learning:

* Recursion = breaking problem into smaller subproblems
* Base case is mandatory (or infinite recursion)

---

### 2. Linked List Basics

* Node structure (data + next)
* Manual linking of nodes
* Traversal using temp pointer

#### Key Learning:

* Linked List = pointer-based structure
* Unlike arrays, memory is NOT continuous

---

## ⚙️ Operations Implemented

### 1. Insert at End

* Traverse till last node
* Attach new node

#### Key Logic:

* `temp.next == null` → last node

---

### 2. Insert at Start

* New node points to head
* Return new node as head

---

### 3. Delete First Node

* Return `head.next`

---

### 4. Delete Last Node

* Traverse till second last node
* Set `temp.next = null`

#### Key Logic:

* `temp.next.next == null` → second last node

---

### 5. Reverse Linked List ⭐

* Reverse pointers (in-place)

#### Key Steps:

1. Store next
2. Reverse link
3. Move pointers

---

### 6. Find Middle of Linked List ⭐

* Two pointer technique

#### Logic:

* slow → 1 step

* fast → 2 steps

* When fast reaches end → slow is middle

---

## 💻 Programs Implemented

### Recursion

* factorial()
* recursiveSum()
* fibonacci()
---

### Linked List

* insertAtEndLL() -> ✅ done directly (without any explanation , reference , hint)
* insertAtStartLL() → ✅ done directly
* deleteFirstNodeLL() → ✅ done directly
* deleteLastNodeLL() → ❌ major bug → fixed
* reverseLL() → ❌ major bug → fixed
* middleLL() → ✅ almost direct (with hints)

---

## ⚠️ Mistakes Identified & Fixed

### 🔴 1. Infinite Loop Bug

* Forgot `temp = temp.next`

#### Learning:

* Always move pointer inside loop

---

### 🔴 2. Reverse LL Bug

* Stored `next` outside loop
* Broke link before saving

#### Learning:

* Always save next BEFORE changing links

---

### 🔴 3. Return Type Confusion

* Tried returning deleted node

#### Learning:

* Always return updated head

---

## 🧠 Key Learnings

### Core Concepts

* `temp.next != null` → last node
* `temp.next.next != null` → second last node
* Reverse = pointer redirection

---

## 🧠 Mental Models Built

* "Save → Break → Move" (reverse LL)
* "Stop before null" (LL traversal)
* "Pointers > Values" (core shift)

---

## 📈 Progress Reflection

* First real exposure to pointer-based DSA
* Faced real bugs (infinite loops, broken links)
* Fixed them with reasoning
* Shift from syntax → logic + debugging

---

## 🧠 Level Update

From: OOP Foundation
To: Basic DSA (Linked List + Recursion)

---

## ⏳ Pending (To Revisit)

* Recursion optimization (later)
* More Linked List problems

---

🔥 Status: Breakthrough Day (Entered Real DSA)
