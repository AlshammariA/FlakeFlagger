@Test public void testAddEntryTwice() throws Exception {
  acl.addEntry(testPrincipal,testPrivileges,true,Collections.<String,Value>emptyMap());
  assertFalse(acl.addEntry(testPrincipal,testPrivileges,true,Collections.<String,Value>emptyMap()));
}
