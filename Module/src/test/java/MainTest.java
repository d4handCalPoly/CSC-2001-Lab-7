import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  @Test
  void tree() {
    BinaryTree<String> tree = new BinaryTree<String>("Hello World!", null, null);
  }

  @Test
  void countEmptyTree() {
    assertEquals(0, BinaryTree.countNodes(null));
  }
  @Test
  void countOneTree() {
    assertEquals(1, BinaryTree.countNodes(
        new BinaryTree<String>("Hello World!", null, null)
    ));
  }
  @Test
  void countLotsTree() {
    assertEquals(12, BinaryTree.countNodes(
        new BinaryTree<String>(
            "t",
            new BinaryTree<String>(
                "t",
                null,
                new BinaryTree<String>(
                    "t",
                    null,
                    null)),
            new BinaryTree<String>(
                "t",
                new BinaryTree<String>(
                    "t",
                    new BinaryTree<String>(
                        "t",
                        null,
                        new BinaryTree<String>(
                            "t",
                            new BinaryTree<String>(
                                "t",
                                new BinaryTree<String>(
                                    "t",
                                    null,
                                    null),
                                new BinaryTree<String>(
                                    "t",
                                    null,
                                    null)),
                            null)),
                    null),
                new BinaryTree<String>(
                    "t",
                    null,
                    new BinaryTree<String>(
                        "t",
                        null,
                        null
                    )
                )
            )
        )
    ));
  }

  @Test
  void mirrorEmpty() {
    assertNull(BinaryTree.mirror(null));
  }
  @Test
  void mirrorOne() {
    assertEquals(
        new BinaryTree<String>("t", null,null),
        BinaryTree.mirror(new BinaryTree<String>("t", null, null))
    );
  }
  @Test
  void mirrorThree() {
    assertEquals(
        new BinaryTree<String>(
            "1",
            new BinaryTree<String>(
                "3",
                null,
                null
            ),
            new BinaryTree<String>(
                "2",
                null,
                null
            )
        ),
        BinaryTree.mirror(new BinaryTree<String>(
            "1",
            new BinaryTree<String>(
                "2",
                null,
                null
            ),
            new BinaryTree<String>(
                "3",
                null,
                null
            )
        ))
    );
  }
  @Test
  void mirrorLots() {
    assertEquals(
        new BinaryTree<String>(
            "1",
            new BinaryTree<String>(
                "3",
                new BinaryTree<String>(
                    "7",
                    new BinaryTree<String>(
                        "15",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "14",
                        null,
                        null
                    )
                ),
                new BinaryTree<String>(
                    "6",
                    new BinaryTree<String>(
                        "13",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "12",
                        null,
                        null
                    )
                )
            ),
            new BinaryTree<String>(
                "2",
                new BinaryTree<String>(
                    "5",
                    new BinaryTree<String>(
                        "11",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "10",
                        null,
                        null
                    )
                ),
                new BinaryTree<String>(
                    "4",
                    new BinaryTree<String>(
                        "9",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "8",
                        null,
                        null
                    )
                )
            )
        ),
        BinaryTree.mirror(new BinaryTree<String>(
            "1",
            new BinaryTree<String>(
                "2",
                new BinaryTree<String>(
                    "4",
                    new BinaryTree<String>(
                        "8",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "9",
                        null,
                        null
                    )
                ),
                new BinaryTree<String>(
                    "5",
                    new BinaryTree<String>(
                        "10",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "11",
                        null,
                        null
                    )
                )
            ),
            new BinaryTree<String>(
                "3",
                new BinaryTree<String>(
                    "6",
                    new BinaryTree<String>(
                        "12",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "13",
                        null,
                        null
                    )
                ),
                new BinaryTree<String>(
                    "7",
                    new BinaryTree<String>(
                        "14",
                        null,
                        null
                    ),
                    new BinaryTree<String>(
                        "15",
                        null,
                        null
                    )
                )
            )
        ))
    );
  }

  @Test
  void findPathEmpty() {
    assertNull(BinaryTree.findPath("Test", null));
  }
  @Test
  void pathOneNotThere() {
    assertNull(BinaryTree.findPath(
        "Test",
        new BinaryTree<String>("Not Test", null, null)
        ));
  }
  @Test
  void pathLotsNotThere() {
    assertNull(BinaryTree.findPath(
        "Test",
        new BinaryTree<String>(
            "t",
            new BinaryTree<String>(
                "t",
                null,
                new BinaryTree<String>(
                    "t",
                    null,
                    null)),
            new BinaryTree<String>(
                "t",
                new BinaryTree<String>(
                    "t",
                    new BinaryTree<String>(
                        "t",
                        null,
                        new BinaryTree<String>(
                            "t",
                            new BinaryTree<String>(
                                "t",
                                new BinaryTree<String>(
                                    "t",
                                    null,
                                    null),
                                new BinaryTree<String>(
                                    "t",
                                    null,
                                    null)),
                            null)),
                    null),
                new BinaryTree<String>(
                    "t",
                    null,
                    new BinaryTree<String>(
                        "t",
                        null,
                        null
                    )
                )
            )
        )
        ));
  }
  @Test
  void pathOne() {
    assertEquals(
        new LinkedList<String>("Test", null),
        BinaryTree.findPath(
            "Test",
            new BinaryTree<String>("Test", null, null)
            )
        );
  }
  @Test
  void pathLots() {
    assertEquals(
        new LinkedList<String>(
            "1",
            new LinkedList<String>(
                "2",
                new LinkedList<>("3"
                    ,
                    new LinkedList<String>("Test", null)
                )
            )
        ),
        BinaryTree.findPath(
            "Test",
            new BinaryTree<String>("1",
                new BinaryTree<String>("2",
                    new BinaryTree<String>("Not Test",
                        null,
                        null
                    ),
                    new BinaryTree<String>("3",
                        new BinaryTree<String>("Test",
                            null,
                            null
                        ),
                        new BinaryTree<String>("Not Test",
                            null,
                            null
                        )
                    )
                ),
                new BinaryTree<String>("Not Test",
                    new BinaryTree<String>("Not Test",
                        null,
                        null
                    ),
                    new BinaryTree<String>("Not Test",
                        null,
                        null
                    )
                )
            ))
        );
  }

  @Test
  void preorder() {
    assertEquals(
        new LinkedList<Integer>(12, new LinkedList<Integer>(7,
            new LinkedList<Integer>(2, new LinkedList<Integer>(10,
                new LinkedList<Integer>(9, new LinkedList<Integer>(18,
                    new LinkedList<Integer>(14, new LinkedList<Integer>(23, null
                    ))
                ))
            ))
        )),
        BinaryTree.preorder(
            new BinaryTree<Integer>(
                12,
                new BinaryTree<Integer>(
                    7,
                    new BinaryTree<Integer>(
                        2,
                        null,
                        null
                ) ,
                    new BinaryTree<Integer>(
                        10,
                        new BinaryTree<Integer>(
                            9,
                            null,
                            null
                        ) ,
                        null
                    )
                ) ,
                new BinaryTree<Integer>(
                    18,
                    new BinaryTree<Integer>(
                        14,
                        null,
                        null
                    ) ,
                    new BinaryTree<Integer>(
                        23,
                        null,
                        null
                    )
                )
            )
        )
    );
  }
  @Test
  void preorderNull() {
    assertNull(BinaryTree.preorder(null));
  }
}
