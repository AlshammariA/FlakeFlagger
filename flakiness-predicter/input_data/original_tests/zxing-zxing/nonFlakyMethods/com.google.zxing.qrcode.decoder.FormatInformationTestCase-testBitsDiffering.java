@Test public void testBitsDiffering(){
  assertEquals(0,FormatInformation.numBitsDiffering(1,1));
  assertEquals(1,FormatInformation.numBitsDiffering(0,2));
  assertEquals(2,FormatInformation.numBitsDiffering(1,2));
  assertEquals(32,FormatInformation.numBitsDiffering(-1,0));
}
