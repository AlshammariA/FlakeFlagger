@Test public void testOneError() throws ChecksumException {
  Random random=getRandom();
  for (int i=0; i < PDF417_TEST_WITH_EC.length; i++) {
    int[] received=PDF417_TEST_WITH_EC.clone();
    received[i]=random.nextInt(256);
    checkDecode(received);
  }
}
