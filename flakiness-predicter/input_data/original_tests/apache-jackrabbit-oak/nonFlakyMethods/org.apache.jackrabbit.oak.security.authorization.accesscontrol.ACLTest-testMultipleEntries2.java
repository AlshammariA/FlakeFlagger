@Test public void testMultipleEntries2() throws Exception {
  Privilege[] privileges=privilegesFromNames(JCR_READ,JCR_ADD_CHILD_NODES);
  acl.addEntry(testPrincipal,privileges,true);
  Privilege[] achPrivs=privilegesFromNames(JCR_ADD_CHILD_NODES);
  assertFalse(acl.addEntry(testPrincipal,achPrivs,true));
  assertTrue(acl.size() == 1);
  assertACE(acl.getEntries().get(0),true,privileges);
}
