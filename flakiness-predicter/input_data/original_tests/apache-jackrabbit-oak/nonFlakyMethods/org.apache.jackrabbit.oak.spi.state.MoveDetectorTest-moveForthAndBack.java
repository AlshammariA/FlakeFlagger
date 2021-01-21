/** 
 * Moving a node forth and back again should not generate a move event.
 * @throws CommitFailedException
 */
@Test public void moveForthAndBack() throws CommitFailedException {
  NodeBuilder rootBuilder=root.builder();
  move(rootBuilder,"/test/x","/test/y/xx");
  NodeState moved=move(rootBuilder,"/test/y/xx","/test/x").getNodeState();
  MoveExpectation moveExpectation=new MoveExpectation(ImmutableMap.<String,String>of());
  MoveDetector moveDetector=new MoveDetector(moveExpectation);
  CommitFailedException exception=EditorDiff.process(moveDetector,root,moved);
  if (exception != null) {
    throw exception;
  }
  moveExpectation.assertAllFound();
}
