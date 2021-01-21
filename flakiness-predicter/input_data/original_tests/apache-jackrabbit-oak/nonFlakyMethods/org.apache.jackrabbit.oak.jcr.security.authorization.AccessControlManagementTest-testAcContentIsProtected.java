@Test public void testAcContentIsProtected() throws Exception {
  Node policyNode=findPolicyNode(superuser.getRootNode());
  if (policyNode == null) {
    throw new NotExecutableException("no policy node found.");
  }
  assertTrue("The rep:Policy node must be protected",policyNode.getDefinition().isProtected());
  try {
    policyNode.remove();
    fail("rep:Policy node must be protected.");
  }
 catch (  ConstraintViolationException e) {
  }
  for (NodeIterator it=policyNode.getNodes(); it.hasNext(); ) {
    Node n=it.nextNode();
    if (n.isNodeType("rep:ACE")) {
      try {
        n.remove();
        fail("ACE node must be protected.");
      }
 catch (      ConstraintViolationException e) {
      }
      break;
    }
  }
  try {
    policyNode.setProperty("test","anyvalue");
    fail("rep:policy node must be protected.");
  }
 catch (  ConstraintViolationException e) {
  }
  try {
    policyNode.addNode("test","rep:ACE");
    fail("rep:policy node must be protected.");
  }
 catch (  ConstraintViolationException e) {
  }
}
