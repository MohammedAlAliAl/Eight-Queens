# N-Queens Solver in Java

This project implements a **recursive backtracking solution** for the classic N-Queens problem using Java. It uses an object-oriented approach with a chessboard represented as a grid of `Node` objects containing `Piece` instances.

---

## 📌 Problem

The N-Queens problem asks:  
> Can you place N queens on an N×N chessboard so that no two queens threaten each other?

For an 8×8 board, there are **92 distinct solutions**.

---

## 💡 Features

- ✅ Recursive backtracking
- ✅ Prints **all** valid solutions
- ✅ Uses a `Node[][]` structure for the chessboard
- ✅ Custom `Piece` and `PieceType` classes
- ✅ Clean console output

---

## 📂 Project Structure

├── Chessboard.java // Core logic and solution search
├── Node.java // Represents a cell on the board
├── Piece.java // Represents a chess piece (Queen)
├── PieceType.java // Enum: currently only QUEEN
└── README.md
