@Test public void testPBKDF2WithHmacSHA1() throws Exception {
  String algo="PBKDF2WithHmacSHA1";
  String pw="pass\0word";
  int iterations=4096;
  String hash=PasswordUtil.buildPasswordHash(pw,algo,5,iterations);
  assertTrue(hash.startsWith("{PBKDF2WithHmacSHA1}"));
  int cntOctets=hash.substring(hash.lastIndexOf('-') + 1).length() / 2;
  assertEquals(16,cntOctets);
}
