@Test public void testComplementaryEntry2() throws Exception {
  Privilege[] repwrite=privilegesFromNames(REP_WRITE);
  acl.addAccessControlEntry(testPrincipal,repwrite);
  Privilege[] modProperties=privilegesFromNames(JCR_MODIFY_PROPERTIES);
  assertTrue(acl.addEntry(testPrincipal,modProperties,false));
  assertTrue(acl.size() == 2);
  Privilege[] expected=privilegesFromNames(JCR_ADD_CHILD_NODES,JCR_REMOVE_CHILD_NODES,JCR_REMOVE_NODE,JCR_NODE_TYPE_MANAGEMENT);
  assertACE(acl.getEntries().get(0),true,expected);
  assertACE(acl.getEntries().get(1),false,modProperties);
}
