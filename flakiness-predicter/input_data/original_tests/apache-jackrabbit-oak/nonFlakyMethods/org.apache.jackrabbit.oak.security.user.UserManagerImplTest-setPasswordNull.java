@Test public void setPasswordNull() throws Exception {
  User user=userMgr.createUser(testUserId,null);
  root.commit();
  Tree userTree=root.getTree(user.getPath());
  try {
    userMgr.setPassword(userTree,null,true);
    fail("setting null password should fail");
  }
 catch (  NullPointerException e) {
  }
  try {
    userMgr.setPassword(userTree,null,false);
    fail("setting null password should fail");
  }
 catch (  NullPointerException e) {
  }
}
