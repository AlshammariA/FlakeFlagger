@Test public void testAscii() throws Exception {
  ProgressTicker ticker=new AsciiArtTicker();
  for (int i=0; i < 200; i++) {
    System.out.println(ticker.tick());
  }
}
