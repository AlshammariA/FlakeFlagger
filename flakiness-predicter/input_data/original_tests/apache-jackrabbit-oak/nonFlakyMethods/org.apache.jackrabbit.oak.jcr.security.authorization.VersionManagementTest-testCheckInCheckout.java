@Test public void testCheckInCheckout() throws Exception {
  modify(path,REP_WRITE,true);
  modify(path,Privilege.JCR_VERSION_MANAGEMENT,false);
  Node n=createVersionableNode(superuser.getNode(path));
  try {
    testSession.refresh(false);
    Node testNode=testSession.getNode(n.getPath());
    testNode.checkin();
    fail("Missing jcr:versionManagement privilege -> checkin/checkout must fail.");
  }
 catch (  AccessDeniedException e) {
    Property p=n.getProperty("jcr:isCheckedOut");
    assertFalse(p.isModified());
    assertTrue(n.getProperty("jcr:isCheckedOut").getValue().getBoolean());
  }
}
