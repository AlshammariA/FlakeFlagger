@Test public void testGetMembersConsistentWithMembership(){
  Principal everyone=principalMgr.getEveryone();
  PrincipalIterator it=principalMgr.getPrincipals(PrincipalManager.SEARCH_TYPE_GROUP);
  while (it.hasNext()) {
    Principal p=it.nextPrincipal();
    if (p.equals(everyone)) {
      continue;
    }
    assertTrue(isGroup(p));
    Enumeration<? extends Principal> members=((java.security.acl.Group)p).members();
    while (members.hasMoreElements()) {
      Principal memb=members.nextElement();
      Principal group=null;
      PrincipalIterator mship=principalMgr.getGroupMembership(memb);
      while (mship.hasNext() && group == null) {
        Principal gr=mship.nextPrincipal();
        if (p.equals(gr)) {
          group=gr;
        }
      }
      assertNotNull("Group member " + memb.getName() + "does not reveal group upon getGroupMembership",p.getName());
    }
  }
}
