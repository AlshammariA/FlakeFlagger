@Test public void testSetPrimaryTypeWithoutPrivilege() throws Exception {
  Node child=(Node)superuser.getItem(childNode.getPath());
  String ntName=child.getPrimaryNodeType().getName();
  try {
    childNode.setPrimaryType("nt:folder");
    testSession.save();
    fail("TestSession does not have sufficient privileges to change the primary type.");
  }
 catch (  AccessDeniedException e) {
  }
 finally {
    testSession.refresh(false);
    if (!ntName.equals(child.getPrimaryNodeType().getName())) {
      child.setPrimaryType(ntName);
      superuser.save();
    }
  }
}
