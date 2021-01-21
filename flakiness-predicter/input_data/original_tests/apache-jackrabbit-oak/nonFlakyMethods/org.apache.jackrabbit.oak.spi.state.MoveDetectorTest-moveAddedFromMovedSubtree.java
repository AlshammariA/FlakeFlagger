/** 
 * Moving a transiently added node from a moved subtree doesn't generate a move event.
 * @throws CommitFailedException
 */
@Test public void moveAddedFromMovedSubtree() throws CommitFailedException {
  NodeBuilder rootBuilder=root.builder();
  rootBuilder.getChildNode("test").getChildNode("z").setChildNode("added");
  move(rootBuilder,"/test/z","/test/y/z");
  NodeState moved=move(rootBuilder,"/test/y/z/added","/test/x/added").getNodeState();
  MoveExpectation moveExpectation=new MoveExpectation(ImmutableMap.of("/test/z","/test/y/z"));
  MoveDetector moveDetector=new MoveDetector(moveExpectation);
  CommitFailedException exception=EditorDiff.process(moveDetector,root,moved);
  if (exception != null) {
    throw exception;
  }
  moveExpectation.assertAllFound();
}
