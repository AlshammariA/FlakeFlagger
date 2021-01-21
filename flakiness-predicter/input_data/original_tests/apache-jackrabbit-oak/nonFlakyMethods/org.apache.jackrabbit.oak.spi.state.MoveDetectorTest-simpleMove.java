/** 
 * Test whether we can detect a single move
 * @throws CommitFailedException
 */
@Test public void simpleMove() throws CommitFailedException {
  NodeState moved1=move(root.builder(),"/test/x","/test/y/xx").getNodeState();
  MoveExpectation moveExpectation1=new MoveExpectation(ImmutableMap.of("/test/x","/test/y/xx"));
  MoveDetector moveDetector1=new MoveDetector(moveExpectation1);
  CommitFailedException exception1=EditorDiff.process(moveDetector1,root,moved1);
  if (exception1 != null) {
    throw exception1;
  }
  moveExpectation1.assertAllFound();
  NodeState moved2=move(moved1.builder(),"/test/y/xx","/test/x").getNodeState();
  MoveExpectation moveExpectation2=new MoveExpectation(ImmutableMap.of("/test/y/xx","/test/x"));
  MoveDetector moveDetector2=new MoveDetector(moveExpectation2);
  CommitFailedException exception2=EditorDiff.process(moveDetector2,moved1,moved2);
  if (exception2 != null) {
    throw exception2;
  }
  moveExpectation2.assertAllFound();
}
