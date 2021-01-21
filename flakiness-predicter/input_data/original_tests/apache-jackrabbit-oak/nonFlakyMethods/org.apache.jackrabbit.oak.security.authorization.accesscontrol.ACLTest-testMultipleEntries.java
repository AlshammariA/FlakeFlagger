@Test public void testMultipleEntries() throws Exception {
  Privilege[] privileges=privilegesFromNames(JCR_READ);
  acl.addEntry(testPrincipal,privileges,true);
  privileges=privilegesFromNames(JCR_READ,JCR_ADD_CHILD_NODES);
  assertTrue(acl.addEntry(testPrincipal,privileges,true));
  assertTrue(acl.size() == 1);
  assertACE(acl.getEntries().get(0),true,privileges);
}
