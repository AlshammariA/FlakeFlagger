@Test public void testEqualsForEmpty() throws Exception {
  JackrabbitAccessControlList acl=createEmptyACL();
  assertEquals(acl,createEmptyACL());
  ACE entry=createEntry(testPrincipal,testPrivileges,true);
  assertFalse(acl.equals(createACL(entry)));
  assertFalse(acl.equals(new TestACL(getTestPath(),getRestrictionProvider(),Collections.<JackrabbitAccessControlEntry>emptyList())));
}
