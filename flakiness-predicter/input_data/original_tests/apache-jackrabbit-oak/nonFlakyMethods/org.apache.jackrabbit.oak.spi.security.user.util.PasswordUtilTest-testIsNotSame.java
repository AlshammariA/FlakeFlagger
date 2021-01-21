@Test public void testIsNotSame() throws Exception {
  String previous=null;
  for (  String pw : hashedPasswords.keySet()) {
    String pwHash=hashedPasswords.get(pw);
    assertFalse(pw,PasswordUtil.isSame(pw,pw));
    assertFalse(pwHash,PasswordUtil.isSame(pwHash,pwHash));
    if (previous != null) {
      assertFalse(previous,PasswordUtil.isSame(pwHash,previous));
    }
    previous=pw;
  }
}
