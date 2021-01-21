@Test public void testCreateWithRelativePath() throws Exception {
  Principal p=getTestPrincipal();
  String uid=p.getName();
  List<String> invalid=new ArrayList<String>();
  invalid.add("../../path");
  invalid.add(UserConstants.DEFAULT_USER_PATH + "/../test");
  invalid.add("../../../home/users/test");
  for (  String path : invalid) {
    try {
      User user=userMgr.createUser(uid,"pw",p,path);
      superuser.save();
      fail("intermediate path '" + path + "' outside of the user tree.");
    }
 catch (    Exception e) {
    }
 finally {
      superuser.refresh(false);
      Authorizable testUser=userMgr.getAuthorizable(uid);
      if (testUser != null) {
        testUser.remove();
        superuser.save();
      }
    }
  }
}
