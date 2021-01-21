@Test public void testMultiplePrincipals() throws Exception {
  Principal everyone=principalManager.getEveryone();
  Privilege[] privs=privilegesFromNames(JCR_READ);
  acl.addAccessControlEntry(testPrincipal,privs);
  assertFalse(acl.addAccessControlEntry(testPrincipal,privs));
  assertTrue(acl.addAccessControlEntry(everyone,privs));
  assertTrue(acl.getAccessControlEntries().length == 2);
  assertEquals(everyone,acl.getAccessControlEntries()[1].getPrincipal());
}
