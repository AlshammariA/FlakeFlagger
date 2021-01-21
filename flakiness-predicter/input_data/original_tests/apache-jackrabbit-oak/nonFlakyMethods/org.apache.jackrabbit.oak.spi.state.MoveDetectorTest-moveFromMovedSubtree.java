/** 
 * Moving a node from a moved subtree doesn't generate a move event.
 * @throws CommitFailedException
 */
@Test public void moveFromMovedSubtree() throws CommitFailedException {
  NodeBuilder rootBuilder=root.builder();
  move(rootBuilder,"/test/z","/test/y/z");
  NodeState moved=move(rootBuilder,"/test/y/z/zz","/test/x/zz").getNodeState();
  MoveExpectation moveExpectation=new MoveExpectation(ImmutableMap.of("/test/z","/test/y/z","/test/z/zz","/test/x/zz"));
  MoveDetector moveDetector=new MoveDetector(moveExpectation);
  CommitFailedException exception=EditorDiff.process(moveDetector,root,moved);
  if (exception != null) {
    throw exception;
  }
  moveExpectation.assertAllFound();
}
