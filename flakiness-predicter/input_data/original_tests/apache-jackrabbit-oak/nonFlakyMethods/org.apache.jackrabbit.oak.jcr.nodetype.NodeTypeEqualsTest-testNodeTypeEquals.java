/** 
 * Tests if 2 NodeType objects are equals if they refer to the same node type. OAK-1086.
 * @throws Exception
 */
@Test public void testNodeTypeEquals() throws Exception {
  NodeType nt=testRootNode.getPrimaryNodeType();
  Assert.assertEquals("Same NoteType could be equal",nt,testRootNode.getPrimaryNodeType());
}
