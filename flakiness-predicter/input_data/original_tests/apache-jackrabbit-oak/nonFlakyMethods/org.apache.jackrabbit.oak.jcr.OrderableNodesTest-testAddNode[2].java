/** 
 * OAK-612
 */
@Test public void testAddNode() throws Exception {
  new TestContentLoader().loadTestContent(getAdminSession());
  Session session=getAdminSession();
  Node test=session.getRootNode().addNode("test","test:orderableFolder");
  assertTrue(test.getPrimaryNodeType().hasOrderableChildNodes());
  test.addNode("a");
  test.addNode("b");
  session.save();
  NodeIterator it=test.getNodes();
  assertEquals("a",it.nextNode().getName());
  assertEquals("b",it.nextNode().getName());
}
