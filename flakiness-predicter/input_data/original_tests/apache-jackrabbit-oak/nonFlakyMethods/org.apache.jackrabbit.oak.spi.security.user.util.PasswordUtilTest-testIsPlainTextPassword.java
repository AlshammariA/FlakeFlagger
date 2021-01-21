@Test public void testIsPlainTextPassword() throws Exception {
  for (  String pw : plainPasswords) {
    assertTrue(pw + " should be plain text.",PasswordUtil.isPlainTextPassword(pw));
  }
}
