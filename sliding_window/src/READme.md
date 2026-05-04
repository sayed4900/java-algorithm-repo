# 🚀 Sliding Window & Subarray Patterns

This repository is dedicated to documenting my journey of learning and mastering **Sliding Window** patterns and **Subarray** problems. The goal is to build a deep understanding of how to choose the most efficient algorithm based on the nature of the data (positive numbers, negative numbers, or characters).

## 📺 Learning Reference
The logic and problems implemented here are based on the excellent explanations found in this tutorial:
[Sliding Window Algorithm - Watch on YouTube](https://youtu.be/tLsoelNl3To)

---

## 🧠 Key Technical Insights

Through practical implementation and review sessions using **Gemini AI** as a mentor, I have established these "Golden Rules" for selecting the right approach:

| Scenario | Best Tool | Reasoning |
| :--- | :--- | :--- |
| **Target Sum ($k$) + Positive Numbers only** | **Sliding Window** | The window moves monotonically (adding an element increases sum, removing decreases it). |
| **Target Sum ($k$) + Negative Numbers included** | **Prefix Sum + HashMap** | Negative numbers break window monotonicity; the Map acts as a "radar" to track historical sums. |
| **Maximum Subarray Sum (Variable Size)** | **Kadane's Algorithm** | Operates on the "reset" principle; if the current window sum becomes negative, discard it and start fresh. |
| **Longest Substring without repeating characters** | **Sliding Window + Set** | Uses a Set to ensure uniqueness and "slides" the left pointer whenever a duplicate is encountered. |

---

## 🛠️ Study Workflow
1. **Self-Challenge:** Attempting to solve each problem programmatically before watching the solution in the video.
2. **AI Mentorship:** Using **Gemini** to review my logic, understand tricky edge cases (especially negative numbers), and correct course when stuck.
3. **Abstraction:** Focusing on mental models and patterns rather than memorizing specific code blocks.

---

## 📂 Repository Structure
- `SubarraySumEqualsK.java`: Solutions using HashMap to handle negative integers.
- `LongestSubstring.java`: Implementing sliding window with a HashSet for unique character tracking.
- `KadaneAlgorithm.java`: Finding the maximum subarray sum in $O(n)$ time.
- `HasSubstringAnagram.java`: Fixed-size window implementation for string pattern matching.

---
**Done with ❤️ and Logic.**