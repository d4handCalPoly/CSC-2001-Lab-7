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
                        null))))
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
}
