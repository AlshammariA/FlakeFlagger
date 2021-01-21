@Test public void testMembers(){
  PrincipalIterator it=principalMgr.getPrincipals(PrincipalManager.SEARCH_TYPE_ALL);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    if (p.equals(principalMgr.getEveryone())) {
      continue;
    }
    if (isGroup(p)) {
      Enumeration<? extends Principal> en=((java.security.acl.Group)p).members();
      while (en.hasMoreElements()) {
        Principal memb=en.nextElement();
        assertTrue(principalMgr.hasPrincipal(memb.getName()));
      }
    }
  }
}
