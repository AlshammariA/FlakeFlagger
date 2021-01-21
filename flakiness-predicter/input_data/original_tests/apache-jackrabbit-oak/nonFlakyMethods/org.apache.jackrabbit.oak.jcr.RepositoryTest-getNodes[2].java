@Test public void getNodes() throws RepositoryException {
  Node test=getNode(TEST_PATH);
  test.addNode("foo");
  test.addNode("bar");
  test.addNode("baz");
  getAdminSession().save();
  Set<String> nodeNames=new HashSet<String>(){
{
      add("bar");
      add("added");
      add("baz");
    }
  }
;
  test=getNode(TEST_PATH);
  test.addNode("added");
  test.getNode("foo").remove();
  test.getNode("bar").remove();
  test.addNode("bar");
  NodeIterator nodes=test.getNodes();
  assertEquals(3,nodes.getSize());
  while (nodes.hasNext()) {
    String name=nodes.nextNode().getName();
    assertTrue(nodeNames.remove(name));
  }
  assertTrue(nodeNames.isEmpty());
}
