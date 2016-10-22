# Implementation for theoretical problem

Consider a special family of Engineers and Doctors with following rules :

    Everybody has two children.
    First child of an Engineer is an Engineer and second child is a Doctor.
    First child of an Doctor is Doctor and second child is an Engineer.
    All generations of Doctors and Engineers start with Enginee

Full prompt : http://www.geeksforgeeks.org/find-profession-in-a-hypothetical-special-situation/

# General thoughts
* Unfortunately, this was listed in the "Bits" section of GeeksForGeeks, so I immediately have to think bits.
* Should recognize that 2 options means maybe bit manipulation is an option.
* Everybody has two children: read as "do not handle the null case" or we're just looking for a heap implementation.
* Trees are reflective of each other: possible way to use this?

# E/C Breaking the mold: write a way to get the node/level of a person who breaks the mold

