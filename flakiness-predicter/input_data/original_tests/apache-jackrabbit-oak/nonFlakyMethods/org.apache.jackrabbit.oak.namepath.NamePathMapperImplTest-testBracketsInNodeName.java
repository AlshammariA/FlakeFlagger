@Test public void testBracketsInNodeName() throws Exception {
  String[] childNames={"{A}","B}","{C","(D)","E)","(F"};
  for (  String name : childNames) {
    assertEquals(name,npMapper.getOakName(name));
  }
}
