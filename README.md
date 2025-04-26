# dastal - 📚 Data Structures & Algorithms in Java

[![Build Status](https://img.shields.io/github/actions/workflow/status/phortran/dastal/gradle.yml?branch=main)](https://github.com/phortran/dastal/actions)
[![Java Version](https://img.shields.io/badge/java-21%2B-blue.svg)](https://jdk.java.net/21/)
[![Gradle](https://img.shields.io/badge/build-tool-gradle-02303A.svg?logo=gradle)](https://gradle.org/)
[![License](https://img.shields.io/github/license/phortran/dastal.svg)](LICENCE)
[![Coverage](https://img.shields.io/codecov/c/github/phortran/dastal?token=YOUR_TOKEN_HERE)](https://codecov.io/gh/phortran/dastal)

---

## 📖 Overview

This repository is a comprehensive, well-structured collection of **data structures and algorithms implemented in Java**.
It includes a wide variety of classic algorithms, custom data structures, and solutions to popular coding challenges
from **HackerRank** and **LeetCode**.

The project emphasizes **clean code practices**, **unit test coverage**, and **build automation with Gradle** — making it
ideal for learners, interviewees, and developers seeking to deepen their algorithmic problem-solving skills.

---

## ✨ Features

- 📚 **Classic Data Structures:** Arrays, Linked Lists, Stacks, Queues, Trees, Heaps, Graphs, Hash Tables, and more.
- ⚙️ **Algorithms Implemented:** Sorting, Searching, Recursion, Dynamic Programming, Backtracking, Greedy Algorithms, and Graph Algorithms.
- 📝 **Problem-Solving Section:** Dedicated solutions to selected problems from **HackerRank** and **LeetCode**.
- ✅ **Comprehensive Unit Tests:** All implementations are backed by **JUnit 5** unit tests.
- ⚡ **Gradle Build Automation:** Simple, efficient build and test workflows.
- 📦 **CI/CD-ready:** Pre-configured with GitHub Actions for continuous integration and optional Codecov for test coverage reporting.

---

## 📂 Project Structure

```bash
dastal/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── panopticode/
│   │               ├── algorithms/
│   │               ├── datastructures/
│   │               └── problems/
│   │                   ├── hackerrank/
│   │                   └── leetcode/
│   │
│   └── test/
│       └── java/
│           └── com/
│               └── panopticode/
│                   ├── algorithms/
│                   ├── datastructures/
│                   └── problems/
│                       ├── hackerrank/
│                       └── leetcode/
│
├── build.gradle
├── settings.gradle
├── README.md
└── LICENCE
```

🚀## Getting Started
🔧
### Prerequisites

* [Java 21+](https://jdk.java.net/21/)
* [Gradle](https://gradle.org/install/) (optional — project includes Gradle Wrapper)

## 📦 Clone & Build

```bash
git clone https://github.com/Panopticode/dastal.git
cd dastal
./gradlew build
```

🧪## Run Tests

```bash
./gradlew test
```

📌## Usage

* Browse through `src/main/java` to explore implementations.
* Visit `problems/hackerrank/` and `problems/leetcode/` directories for coding challenge solutions.
* Corresponding unit tests are under `src/test/java`.
* Modify or extend any implementation and rerun the tests to validate changes.

🤝## Contributing
Contributions are very welcome! If you have optimizations, new problems, or improvements:

1. Fork the project.
2. Create your feature branch:

```bash
git checkout -b feature/YourFeature
```

3. Commit your changes:

```bash
git commit -m "Add YourFeature"
```

4. Push to the branch:

```bash
git push origin feature/YourFeature
```

5. Open a pull request.

📜## Licence
This project is licenced under the [MIT Licence](https://www.mit.edu/~amini/LICENSE.md).

📣## Acknowledgments

* [HackerRank](https://www.hackerrank.com)
* [LeetCode](https://leetcode.com)
* Open-source contributors and Java developer community.

> Pro tip: Bookmark this repository if you're prepping for technical interviews or coding contests!