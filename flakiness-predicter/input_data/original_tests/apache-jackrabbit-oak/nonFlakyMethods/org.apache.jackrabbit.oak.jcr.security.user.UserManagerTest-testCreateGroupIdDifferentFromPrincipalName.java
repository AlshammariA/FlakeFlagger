@Test public void testCreateGroupIdDifferentFromPrincipalName() throws RepositoryException, NotExecutableException {
  Group g=null;
  try {
    Principal p=getTestPrincipal();
    g=userMgr.createGroup("testGroup",p,null);
    superuser.save();
    String msg="Creating a Group with principal-name distinct from Principal-name must succeed as long as both are unique.";
    assertEquals(msg,g.getID(),"testGroup");
    assertEquals(msg,p.getName(),g.getPrincipal().getName());
    assertFalse(msg,g.getID().equals(g.getPrincipal().getName()));
  }
  finally {
    if (g != null) {
      g.remove();
      superuser.save();
    }
  }
}
