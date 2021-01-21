@Test public void testImmutable() throws Exception {
  List<ACE> entries=new ArrayList<ACE>();
  entries.add(createEntry(testPrincipal,testPrivileges,true));
  entries.add(createEntry(testPrincipal,privilegesFromNames(PrivilegeConstants.JCR_LIFECYCLE_MANAGEMENT),false));
  JackrabbitAccessControlList acl=createACL(entries);
  assertFalse(acl.isEmpty());
  assertEquals(2,acl.size());
  assertEquals(getTestPath(),acl.getPath());
  assertImmutable(acl);
}
