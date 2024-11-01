# `path[adjacent_vertex] = path[vertex] + 1;` versus `path[adjacent_vertex] = vertex;`

### `path[adjacent_vertex] = path[vertex] + 1;`
This approach is used to **calculate and store the distance** from the starting node (`start`) to `adjacent_vertex` in terms of the **number of edges**.

- Here, `path[vertex]` represents the distance from the start node to `vertex`.
- By adding `1` to `path[vertex]`, you calculate the distance from the start node to `adjacent_vertex`.
- This is useful when you need to determine **how many edges** there are in the shortest path from the start node to each node.

For example:
- If `path[vertex]` is `2` and you find an adjacent node, the `path[adjacent_vertex]` will be `2 + 1 = 3`.
- The value stored in `path[adjacent_vertex]` is the **number of edges** from the starting node to that particular vertex.

### `path[adjacent_vertex] = vertex;`
This approach is used to **track the predecessor** of each vertex during traversal.

- Here, `path[adjacent_vertex]` stores the **previous node** (i.e., predecessor) from which `adjacent_vertex` was reached.
- This information is useful for **reconstructing the actual path** from the start node to `adjacent_vertex`.
- Essentially, it allows you to backtrack from `adjacent_vertex` to the start node by following each node's predecessor.

For example:
- If `vertex` is `1` and you reach `adjacent_vertex` which is `3`, then `path[3]` will be set to `1`.
- This means that node `3` was reached from node `1`, and you can reconstruct the path by following these predecessors.

### Summary
- **`path[adjacent_vertex] = path[vertex] + 1;`**: Stores the **distance** from the start node to `adjacent_vertex` (useful for finding the shortest path length).
- **`path[adjacent_vertex] = vertex;`**: Stores the **predecessor** of `adjacent_vertex` (useful for reconstructing the actual path).

In your current code, `path[adjacent_vertex] = vertex;` is being used to track the predecessor, which is helpful when you want to reconstruct the path later. If you wanted to calculate the distance from the start node to every other node, you would instead use `path[adjacent_vertex] = path[vertex] + 1;`.