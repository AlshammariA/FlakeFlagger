@Test public void testCreateGroupWithId() throws RepositoryException, NotExecutableException {
  Group gr=null;
  try {
    String id=createGroupId();
    gr=userMgr.createGroup(id);
    superuser.save();
    assertEquals("Expect group with exact ID",id,gr.getID());
  }
  finally {
    if (gr != null) {
      gr.remove();
      superuser.save();
    }
  }
}
