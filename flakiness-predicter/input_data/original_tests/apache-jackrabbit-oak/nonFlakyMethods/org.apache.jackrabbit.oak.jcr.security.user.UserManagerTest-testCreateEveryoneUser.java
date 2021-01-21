@Test public void testCreateEveryoneUser() throws Exception {
  User u=null;
  try {
    u=userMgr.createUser(EveryonePrincipal.NAME,"pw");
    fail("everyone is a reserved group name");
  }
 catch (  IllegalArgumentException e) {
  }
 finally {
    if (u != null) {
      u.remove();
    }
  }
}
