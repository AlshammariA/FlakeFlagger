@Test public void testCreateGroupWithIdAndPrincipal() throws RepositoryException, NotExecutableException {
  Group gr=null;
  try {
    Principal p=getTestPrincipal();
    String uid=p.getName();
    gr=userMgr.createGroup(uid,p,null);
    superuser.save();
    assertEquals("Expect group with exact ID",uid,gr.getID());
    assertEquals("Expected group with exact principal name",p.getName(),gr.getPrincipal().getName());
  }
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
