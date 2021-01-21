/** 
 * Moving a transiently added node doesn't generate a move event
 * @throws CommitFailedException
 */
@Test public void moveAddedNode() throws CommitFailedException {
  NodeBuilder rootBuilder=root.builder();
  rootBuilder.getChildNode("test").setChildNode("added");
  NodeState moved=move(rootBuilder,"/test/added","/test/y/added").getNodeState();
  MoveExpectation moveExpectation=new MoveExpectation(ImmutableMap.<String,String>of());
  MoveDetector moveDetector=new MoveDetector(moveExpectation);
  CommitFailedException exception=EditorDiff.process(moveDetector,root,moved);
  if (exception != null) {
    throw exception;
  }
  moveExpectation.assertAllFound();
}
