@Test public void testIsPlainTextForNull() throws Exception {
  assertTrue(PasswordUtil.isPlainTextPassword(null));
}
