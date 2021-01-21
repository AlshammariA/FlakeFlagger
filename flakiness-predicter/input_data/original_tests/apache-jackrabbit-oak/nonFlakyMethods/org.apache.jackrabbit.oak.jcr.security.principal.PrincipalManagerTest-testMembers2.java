@Test public void testMembers2() throws Exception {
  Authorizable gr=null;
  try {
    gr=((JackrabbitSession)superuser).getUserManager().createGroup(getClass().getName());
    superuser.save();
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
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
