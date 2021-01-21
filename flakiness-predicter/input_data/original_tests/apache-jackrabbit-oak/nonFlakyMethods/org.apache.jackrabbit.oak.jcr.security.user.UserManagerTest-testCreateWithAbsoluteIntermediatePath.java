@Test public void testCreateWithAbsoluteIntermediatePath() throws Exception {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  User test=null;
  try {
    test=userMgr.createUser(uid,"pw",p,UserConstants.DEFAULT_USER_PATH + "/test");
    superuser.save();
    assertTrue(test.getPath().startsWith(UserConstants.DEFAULT_USER_PATH + "/test"));
  }
  finally {
    if (test != null) {
      test.remove();
      superuser.save();
    }
  }
}
