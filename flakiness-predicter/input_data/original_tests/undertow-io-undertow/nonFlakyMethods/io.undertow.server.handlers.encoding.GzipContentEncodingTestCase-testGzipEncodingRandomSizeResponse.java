@Test public void testGzipEncodingRandomSizeResponse() throws IOException {
  int seed=new Random().nextInt();
  System.out.println("Using seed " + seed);
  try {
    final Random random=new Random(seed);
    int size=random.nextInt(691963);
    final StringBuilder messageBuilder=new StringBuilder(size);
    for (int i=0; i < size; ++i) {
      messageBuilder.append('*' + random.nextInt(10));
    }
    runTest(messageBuilder.toString());
  }
 catch (  Exception e) {
    throw new RuntimeException("Test failed with seed " + seed,e);
  }
}
