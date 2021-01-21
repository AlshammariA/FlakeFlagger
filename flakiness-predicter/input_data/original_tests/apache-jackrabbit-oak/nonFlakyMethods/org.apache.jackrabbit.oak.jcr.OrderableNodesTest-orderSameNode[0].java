@Test public void orderSameNode() throws Exception {
  Session session=getAdminSession();
  Node n=session.getRootNode().addNode("test","nt:unstructured");
  Node a=n.addNode("a");
  n.orderBefore("a","a");
}
