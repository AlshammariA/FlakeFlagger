@Test public void testNoAi() throws Exception {
  BitArray information=BinaryUtil.buildBitArrayFromString(" .......X ..XX..X. X.X....X .......X ....");
  AbstractExpandedDecoder decoder=AbstractExpandedDecoder.createDecoder(information);
  String decoded=decoder.parseInformation();
  assertEquals("(10)12A",decoded);
}
