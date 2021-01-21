@Test public void testIsSame() throws Exception {
  for (  String pw : hashedPasswords.keySet()) {
    String pwHash=hashedPasswords.get(pw);
    assertTrue("Not the same " + pw + ", "+ pwHash,PasswordUtil.isSame(pwHash,pw));
  }
  String pw="password";
  String pwHash=PasswordUtil.buildPasswordHash(pw,"SHA-1",4,50);
  assertTrue("Not the same '" + pw + "', "+ pwHash,PasswordUtil.isSame(pwHash,pw));
  pwHash=PasswordUtil.buildPasswordHash(pw,"md5",0,5);
  assertTrue("Not the same '" + pw + "', "+ pwHash,PasswordUtil.isSame(pwHash,pw));
  pwHash=PasswordUtil.buildPasswordHash(pw,"md5",-1,-1);
  assertTrue("Not the same '" + pw + "', "+ pwHash,PasswordUtil.isSame(pwHash,pw));
}
