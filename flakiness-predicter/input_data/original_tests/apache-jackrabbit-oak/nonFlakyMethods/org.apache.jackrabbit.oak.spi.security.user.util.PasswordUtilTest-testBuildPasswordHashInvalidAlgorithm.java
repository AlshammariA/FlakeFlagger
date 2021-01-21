@Test public void testBuildPasswordHashInvalidAlgorithm() throws Exception {
  List<String> invalidAlgorithms=new ArrayList<String>();
  invalidAlgorithms.add("");
  invalidAlgorithms.add("+");
  invalidAlgorithms.add("invalid");
  for (  String invalid : invalidAlgorithms) {
    try {
      PasswordUtil.buildPasswordHash("pw",invalid,PasswordUtil.DEFAULT_SALT_SIZE,PasswordUtil.DEFAULT_ITERATIONS);
      fail("Invalid algorithm " + invalid);
    }
 catch (    NoSuchAlgorithmException e) {
    }
  }
}
