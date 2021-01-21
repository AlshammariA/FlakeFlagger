@Test public void testIsPlainTextForPwHash() throws Exception {
  for (  String pwHash : hashedPasswords.values()) {
    assertFalse(pwHash + " should not be plain text.",PasswordUtil.isPlainTextPassword(pwHash));
  }
}
