@Test public void testAddEntry() throws Exception {
  assertTrue(acl.addEntry(testPrincipal,testPrivileges,true));
  assertFalse(acl.isEmpty());
}
