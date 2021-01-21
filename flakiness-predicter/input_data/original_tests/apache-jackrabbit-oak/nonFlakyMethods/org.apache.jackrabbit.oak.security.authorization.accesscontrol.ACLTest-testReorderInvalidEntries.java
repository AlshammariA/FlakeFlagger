@Test public void testReorderInvalidEntries() throws Exception {
  Privilege[] read=privilegesFromNames(JCR_READ,JCR_READ_ACCESS_CONTROL);
  Privilege[] write=privilegesFromNames(JCR_WRITE);
  acl.addAccessControlEntry(testPrincipal,read);
  acl.addAccessControlEntry(EveryonePrincipal.getInstance(),write);
  AccessControlEntry invalid=createEntry(testPrincipal,false,null,JCR_WRITE);
  try {
    acl.orderBefore(invalid,acl.getEntries().get(0));
    fail("src entry not contained in list -> reorder should fail.");
  }
 catch (  AccessControlException e) {
  }
  try {
    acl.orderBefore(acl.getEntries().get(0),invalid);
    fail("dest entry not contained in list -> reorder should fail.");
  }
 catch (  AccessControlException e) {
  }
}
