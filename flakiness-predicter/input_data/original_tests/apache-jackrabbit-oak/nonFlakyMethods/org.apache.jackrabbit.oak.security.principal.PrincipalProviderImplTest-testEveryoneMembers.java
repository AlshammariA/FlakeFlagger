@Test public void testEveryoneMembers() throws Exception {
  Principal everyone=principalProvider.getPrincipal(EveryonePrincipal.NAME);
  assertTrue(everyone instanceof EveryonePrincipal);
  Group everyoneGroup=null;
  try {
    UserManager userMgr=getUserManager(root);
    everyoneGroup=userMgr.createGroup(EveryonePrincipal.NAME);
    root.commit();
    Principal ep=principalProvider.getPrincipal(EveryonePrincipal.NAME);
    Set<? extends Principal> everyoneMembers=ImmutableSet.copyOf(Collections.list(((java.security.acl.Group)ep).members()));
    Iterator<? extends Principal> all=principalProvider.findPrincipals(PrincipalManager.SEARCH_TYPE_ALL);
    while (all.hasNext()) {
      Principal p=all.next();
      if (everyone.equals(p)) {
        assertFalse(everyoneMembers.contains(p));
      }
 else {
        assertTrue(everyoneMembers.contains(p));
      }
    }
  }
  finally {
    if (everyoneGroup != null) {
      everyoneGroup.remove();
      root.commit();
    }
  }
}
