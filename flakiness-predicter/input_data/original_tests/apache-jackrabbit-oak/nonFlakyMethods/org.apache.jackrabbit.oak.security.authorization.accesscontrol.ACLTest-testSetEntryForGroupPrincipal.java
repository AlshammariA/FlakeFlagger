@Test public void testSetEntryForGroupPrincipal() throws Exception {
  Privilege[] privs=privilegesFromNames(JCR_READ);
  Group grPrincipal=(Group)principalManager.getEveryone();
  assertTrue(acl.addAccessControlEntry(grPrincipal,privs));
  assertTrue(acl.addEntry(grPrincipal,privs,false));
  assertEquals(1,acl.size());
  assertFalse(acl.getEntries().get(0).isAllow());
}
