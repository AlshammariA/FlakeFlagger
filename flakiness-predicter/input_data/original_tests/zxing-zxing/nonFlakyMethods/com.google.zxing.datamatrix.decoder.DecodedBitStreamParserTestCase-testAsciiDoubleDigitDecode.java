@Test public void testAsciiDoubleDigitDecode() throws Exception {
  byte[] bytes={(byte)130,(byte)(1 + 130),(byte)(98 + 130),(byte)(99 + 130)};
  String decodedString=DecodedBitStreamParser.decode(bytes).getText();
  assertEquals("00019899",decodedString);
}
