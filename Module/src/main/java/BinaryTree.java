public record BinaryTree<T>(T val, BinaryTree<T> left, BinaryTree<T> right) {
  /** return number of nodes in tree */
  public static <T> int countNodes(BinaryTree<T> tree) {
    return switch (tree) {
      case null -> 0;
      case BinaryTree<T>(T v, BinaryTree<T> l, BinaryTree<T> r) ->
          1 + BinaryTree.countNodes(l) + BinaryTree.countNodes(r);
    };
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
