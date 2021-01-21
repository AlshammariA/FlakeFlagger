@Test public void testComplementaryEntry1() throws Exception {
  Privilege[] privileges=privilegesFromNames(JCR_READ,JCR_ADD_CHILD_NODES);
  acl.addEntry(testPrincipal,privileges,true);
  privileges=privilegesFromNames(JCR_READ);
  assertTrue(acl.addEntry(testPrincipal,privileges,false));
  assertTrue(acl.size() == 2);
  assertACE(acl.getEntries().get(0),true,privilegesFromNames(JCR_ADD_CHILD_NODES));
  assertACE(acl.getEntries().get(1),false,privilegesFromNames(JCR_READ));
}
