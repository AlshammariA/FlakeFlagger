@Test public void testAddEntry2() throws Exception {
  assertTrue(acl.addEntry(testPrincipal,testPrivileges,true,Collections.<String,Value>emptyMap()));
  assertFalse(acl.isEmpty());
}
