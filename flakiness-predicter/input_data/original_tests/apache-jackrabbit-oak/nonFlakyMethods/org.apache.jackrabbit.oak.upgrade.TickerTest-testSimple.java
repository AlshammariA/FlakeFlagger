@Test public void testSimple() throws Exception {
  ProgressTicker ticker=new SimpleTicker(50);
  for (int i=0; i < 200; i++) {
    System.out.println(ticker.tick());
  }
}
