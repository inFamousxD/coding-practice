cmake_minimum_required(VERSION 4.1)
project(coding_practice)

set(CMAKE_CXX_STANDARD 14)

add_executable(coding_practice
        dynamic-programming/1.1.nth-fib-memory.cpp
        dynamic-programming/2.1.climbing-stairs.cpp
        dynamic-programming/3.1.frog-jump.cpp
        dynamic-programming/5.1.max-sum-subseq-without-adjacent.cpp
        "leetcode-editor/leetcode/editor/en/[100]Same Tree.cpp"
        recursion/2.1.print-name-n-times.cpp
        recursion/2.2.print-1-n.cpp
        recursion/3.1.sum-of-first-n.cpp
        recursion/4.1.reverse-arr.cpp
        recursion/5.1.nth-fib.cpp
        recursion/6.1.subsequences.cpp
        recursion/7.1.subseq-sum.cpp
        recursion/8.1.combination-sum-1.cpp)
