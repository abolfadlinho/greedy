﻿German University in Cairo Department of Computer Science Dr. Nourhan Ehab

CSEN 703 Analysis and Design of Algorithms, Winter Term 2024

Assignment 2

Deadline: 12-12-2024

Exercise 2-1

The Dynamic Arena Challenge

You are an aspiring fighter, planning to hone your skills in the famous Dynamic Arena. This arena does not maintain a consistent structure. Instead, the arena’s floors rise and fall dynamically throughout the day, making the climb more unpredictable and dangerous.

You want to strategically plan your fighting episodes. An Episode is a sequence of two actions: arena entry then winning in combat. You can engage in multiple fighting episodes, but you cannot engage

in more than one combat in the same episode. In other words, once you fight in combat, you need to start a new episode of entry then combat. However, there is a catch, you cannot engage in two episodes consecutively, you need to wait for at least one arena movement to pass. Given that you have been training really well, you know that once you chose to fight, you will win.

You need to choose the right time to enter the arena first, then choose the right time to engage in combat. In order to start an episode, you will have to pay an entry fee and when you win in combat you will gain a reward. The entry fee and the reward are each equal to the floor the arena is in when you make your moves. Your goal is to maximize the rewards you get while in the Dynamic Arena.

[1,7,5,3,6,4,5,8]

The largest number of floors that a fighter can climb is (7   1) + (6   3) + (8   5) = 12.

- Floor 1: Enter the arena.
- Floor 7: Fight to get the reward of floor 7.
- Floor 5: Do nothing.
- Floor 3: Enter the arena.
- Floor 6: Fight to get the reward of floor 6.
- Floor 4: Do nothing.
- Floor 5: Enter the arena.
- Floor 8: Fight to get the reward of floor 8.

Requirements

- Your task is to solve the Dynamic Arena challenge using a dynamic programming-based algorithm. Your algorithm should not run in an exponential time.

Deliverables

You are required to submit one Java file titled DynamicArena containing the following methods. The class name must be DynamicArena and the class must have a package name csen703.main.assignment2.

1) public static int ClimbDynamicArenaDP(int [] floors) that implements a dynamic program- ming approach to finding the maximum number of floors that a fighter can climb.
1) Notice that using static variables might mess up the test cases, therefore we advise against using static variables. There are other workarounds that you can do. Failing to abide with class name, package name, or function signature will lead to an automatic zero.

Regulations

1. A team can include up to 3 members.
1. You should write your solutions in Java.
1. You will submit your solutions through https://forms.gle/ZXsggBmeeo4FvLWm6.

Plagiarism, including the use of GenAI tools such as GPT, Copilot, and similar assistants, is not tolerated. You are also advised against discussing elements of your solutions with other teams.
2
