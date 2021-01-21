public void testRename() throws RepositoryException {
  Node renamedNode=null;
  NodeIterator it=testRootNode.getNodes();
  int pos=0;
  while (it.hasNext()) {
    Node n=it.nextNode();
    String name=n.getName();
    assertEquals(new String(new char[]{SEQ_BEFORE.charAt(pos)}),name);
    if (pos == RELPOS) {
      JackrabbitNode node=(JackrabbitNode)n;
      node.rename(name.toUpperCase());
      renamedNode=n;
    }
    pos++;
  }
  it=testRootNode.getNodes();
  pos=0;
  while (it.hasNext()) {
    Node n=it.nextNode();
    String name=n.getName();
    assertEquals(new String(new char[]{SEQ_AFTER.charAt(pos)}),name);
    if (pos == RELPOS) {
      assertTrue(n.isSame(renamedNode));
    }
    pos++;
  }
}
