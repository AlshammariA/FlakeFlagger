@Test public void testNoError() throws ChecksumException {
  int[] received=PDF417_TEST_WITH_EC.clone();
  checkDecode(received);
}
