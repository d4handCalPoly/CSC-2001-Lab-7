public record BinaryTree<T>(T val, BinaryTree<T> left, BinaryTree<T> right) {
  /** return number of nodes in tree */
  public static <T> int countNodes(BinaryTree<T> tree) {
    return switch (tree) {
      case null -> 0;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r) ->
          1 + BinaryTree.countNodes(l) + BinaryTree.countNodes(r);
    };
  }

  /** return Linked List of tree in preorder */
  public static <T> Node<T> preorder(BinaryTree<T> tree) {
    return preorderHelp(tree, null);
  }

    /** do all the work for preorder */
    private static <T> Node<T> preorderHelp(
      BinaryTree<T> tree,
      Node<T> passed)
  {
    return switch (tree) {
      case null -> passed;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r) ->
          new Node<>(v, preorderHelp(l, preorderHelp(r, passed)));
    };
  }

  public static <T> LinkedList<String> findPath(T val, BinaryTree<T> tree) {
    switch (tree) {
      case null:
        return null;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r):
        if (v.equals(val)) {
          return new LinkedList<>(null);
        } else {
          LinkedList<String> left = findPath(val, l);
          LinkedList<String> right = findPath(val, r);
          if (left != null) {
            return left.addToFront("left");
          } else if (right != null) {
            return right.addToFront("right");
          } else {
            return null;
          }
        }
    }

  }

  /** return tree with mirror image to input */
  public static <T> BinaryTree<T> mirror(BinaryTree<T> tree) {
    return switch (tree) {
      case null -> null;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r) ->
        new BinaryTree<T>(v, BinaryTree.mirror(r), BinaryTree.mirror(l));
    };
  }
}
