## Theory (Trees) - ROUGH NOTES , PROPERLY FORMAT IT LATER

Subtree - Every node can be treated as the root of its own smaller tree.
This idea is extremely important because most tree algorithms are recursive.

Binary Tree - A binary tree is a tree where each node has at most two children

Java Representation - 

```java
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```

Usage - 

```java
TreeNode root = new TreeNode(1);   // root.val = 1
root.left = new TreeNode(2);       // root.left.val = 2 
root.right = new TreeNode(3);      // root.right.val = 3
```

Trees Are Made of References
A tree node does not physically contain the entire left and right tree.

It contains references:
TreeNode left;
TreeNode right;

So: root.left - points to another TreeNode.

Null Means No Child

Consider:
    1
     \
      3

In memory:
```java
root.left == null
root.right != null
```
This is why almost every recursive tree method starts with:

```java
if (root == null) {  // base case
    return ...;
}
```

Consider:
        1
       / \
      2   3
     /
    4

Depth of a Node means the distance from the root to that node.

Usually measured in edges:
Depth of 1 = 0
Depth of 2 = 1
Depth of 3 = 1
Depth of 4 = 2

Height of a Node means the longest distance from that node down to a leaf.

Height of 4 = 0
Height of 2 = 1
Height of 1 = 2

Some LeetCode problems count height in nodes instead of edges.

Full Binary Tree
Every node has either:
Zero children
Two children

Example:

       1
      / \
     2   3
        / \
       4   5


Complete Binary Tree
All levels are completely filled except possibly the last level, and the last level is filled from left to right.

        1
       / \
      2   3
     / \  /
    4  5 6

This matters for heaps.

Perfect Binary Tree
Every internal node has exactly two children, and all leaves are at the same level.

        1
       / \
      2   3
     / \ / \
    4  5 6  7

If height is h, the total number of nodes is:
2^(h + 1) - 1
when root height is counted as 0.

Skewed Tree
Every node has only one child.

Left-skewed:

    1
   /
  2
 /
3

Right-skewed:

1
 \
  2
   \
    3

A skewed tree behaves almost like a linked list.

Balanced Binary Tree

A tree is roughly balanced when the left and right subtree heights do not differ too much.

Balanced:

        1
       / \
      2   3
     /
    4

Very unbalanced:

1
 \
  2
   \
    3
     \
      4

Balanced trees are important because many operations can stay around:

O(log n)

while skewed trees may degrade to:

O(n)


---

Binary Search Tree

A Binary Search Tree, or BST, has an ordering property:

All values in left subtree < node value
All values in right subtree > node value

Example:

        10
       /  \
      5    20
     / \   / \
    2   7 15 30


This property applies to every node, not just the root.