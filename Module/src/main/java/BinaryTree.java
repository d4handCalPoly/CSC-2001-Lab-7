public record BinaryTree<T>(T val, BinaryTree<T> left, BinaryTree<T> right) {
  /** return number of nodes in tree */
  public static <T> int countNodes(BinaryTree<T> tree) {
    return switch (tree) {
      case null -> 0;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r) ->
          1 + BinaryTree.countNodes(l) + BinaryTree.countNodes(r);
    };
  }

  public static <T> LinkedList<T> preorder(BinaryTree<T> tree) {
    return switch (tree) {
      case null -> null;
      case BinaryTree<T> t -> preorderHelp(t, null);
    };
  }

  private static <T> LinkedList<T> preorderHelp(
      BinaryTree<T> tree,
      LinkedList<T> passed)
  {
    switch (tree) {
      case null:
        return null;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r):
        if (r != null) {
          passed = preorderHelp(r, passed);
        }
        if (l != null){
          passed = preorderHelp(l, passed);
        }
          passed = new LinkedList<>(v, passed);
    }
    return passed;
  }

  public static <T> LinkedList<T> findPath(T val, BinaryTree<T> tree) {
    switch (tree) {
      case null:
        return null;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r):
        if (v.equals(val)) {
          return new LinkedList<T>(val, null);
        } else {
          LinkedList<T> left = findPath(val, l);
          LinkedList<T> right = findPath(val, r);
          if (left != null) {
            return new LinkedList<T>(v, left);
          } else if (right != null) {
            return new LinkedList<T>(v, right);
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
