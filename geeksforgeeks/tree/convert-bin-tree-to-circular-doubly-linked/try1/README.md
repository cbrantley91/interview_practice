# Convert a Binary Tree to a Circular Doubly Linked List

* Given a Binary Tree, convert it to a Circular Doubly Linked List (In-Place)
* The order of nodes in List must be same as Inorder of the given Binary Tree.
* The first node of Inorder traversal must be head node of the Circular List

Full problem at http://www.geeksforgeeks.org/convert-a-binary-tree-to-a-circular-doubly-link-list/

# Thought process
* root needs to be head: probably a product of generation: should avoid doing too much outside of natural generation this way
* returns a doubly linked list: doubly is specified for a reason - want ability to attach things to either end
