@Test public void testSetPassword() throws Exception {
  User user=userMgr.createUser(testUserId,"pw");
  root.commit();
  List<String> pwds=new ArrayList<String>();
  pwds.add("pw");
  pwds.add("");
  pwds.add("{sha1}pw");
  Tree userTree=root.getTree(user.getPath());
  for (  String pw : pwds) {
    userMgr.setPassword(userTree,pw,true);
    String pwHash=userTree.getProperty(UserConstants.REP_PASSWORD).getValue(Type.STRING);
    assertNotNull(pwHash);
    assertTrue(PasswordUtil.isSame(pwHash,pw));
  }
  for (  String pw : pwds) {
    userMgr.setPassword(userTree,pw,false);
    String pwHash=userTree.getProperty(UserConstants.REP_PASSWORD).getValue(Type.STRING);
    assertNotNull(pwHash);
    if (!pw.startsWith("{")) {
      assertTrue(PasswordUtil.isSame(pwHash,pw));
    }
 else {
      assertFalse(PasswordUtil.isSame(pwHash,pw));
      assertEquals(pw,pwHash);
    }
  }
}
