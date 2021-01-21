@Test public void testAllowWriteDenyRemoveGroupEntries() throws Exception {
  Principal everyone=principalManager.getEveryone();
  Privilege[] grPriv=privilegesFromNames(REP_WRITE);
  Privilege[] dePriv=privilegesFromNames(JCR_REMOVE_CHILD_NODES);
  acl.addEntry(everyone,grPriv,true,Collections.<String,Value>emptyMap());
  acl.addEntry(everyone,dePriv,false,Collections.<String,Value>emptyMap());
  Set<Privilege> allows=new HashSet<Privilege>();
  Set<Privilege> denies=new HashSet<Privilege>();
  AccessControlEntry[] entries=acl.getAccessControlEntries();
  for (  AccessControlEntry en : entries) {
    if (everyone.equals(en.getPrincipal()) && en instanceof JackrabbitAccessControlEntry) {
      JackrabbitAccessControlEntry ace=(JackrabbitAccessControlEntry)en;
      Privilege[] privs=ace.getPrivileges();
      if (ace.isAllow()) {
        allows.addAll(Arrays.asList(privs));
      }
 else {
        denies.addAll(Arrays.asList(privs));
      }
    }
  }
  Privilege[] expected=privilegesFromNames(JCR_ADD_CHILD_NODES,JCR_REMOVE_NODE,JCR_MODIFY_PROPERTIES,JCR_NODE_TYPE_MANAGEMENT);
  assertEquals(expected.length,allows.size());
  assertEquals(ImmutableSet.copyOf(expected),allows);
  assertEquals(1,denies.size());
  assertArrayEquals(privilegesFromNames(JCR_REMOVE_CHILD_NODES),denies.toArray(new Privilege[denies.size()]));
}
