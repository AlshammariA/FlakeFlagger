@Test public void testChildNodesWithAccessCheck() throws Exception {
  Node nodeToDeny=superuser.getNode(path).addNode("nodeToDeny");
  superuser.save();
  deny(nodeToDeny.getPath(),privilegesFromName(PrivilegeConstants.JCR_READ));
  NodeIterator it=testSession.getNode(path).getNodes();
  Set<String> childNodeNames=new HashSet<String>();
  while (it.hasNext()) {
    Node n=it.nextNode();
    childNodeNames.add(n.getName());
  }
  assertFalse(childNodeNames.contains("nodeToDeny"));
}
