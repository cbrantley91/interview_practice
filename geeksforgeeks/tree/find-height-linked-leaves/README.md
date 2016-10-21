# Find height of a special binary tree whose leaf nodes are connected

Given a special binary tree whose leaf nodes are connected to form a circular doubly linked list, find its height.

Prompted: http://www.geeksforgeeks.org/find-height-of-a-special-binary-tree-whose-leaf-nodes-are-connected/

# Thoughts
* somewhat confusing wording on this one: in essence, the left and right elements are holding the left and right nodes of the linked list
* check for leaf is changed to no longer be null, but left->right should be yourself
* other than that is ok
