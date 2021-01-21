/** 
 * Moving a moved node is reported as a single move from the original source to the final destination.
 * @throws CommitFailedException
 */
@Test public void moveMoved() throws CommitFailedException {
  NodeBuilder rootBuilder=root.builder();
  move(rootBuilder,"/test/x","/test/y/xx");
  NodeState moved=move(rootBuilder,"/test/y/xx","/test/z/xxx").getNodeState();
  MoveExpectation moveExpectation=new MoveExpectation(ImmutableMap.of("/test/x","/test/z/xxx"));
  MoveDetector moveDetector=new MoveDetector(moveExpectation);
  CommitFailedException exception=EditorDiff.process(moveDetector,root,moved);
  if (exception != null) {
    throw exception;
  }
  moveExpectation.assertAllFound();
}
