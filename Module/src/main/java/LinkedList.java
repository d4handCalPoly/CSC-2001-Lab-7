public record LinkedList<T>(Node<T> head) {
  public LinkedList<T> addToFront(T val) {
    return new LinkedList<>(new Node<>(val, this.head));
  }
}
