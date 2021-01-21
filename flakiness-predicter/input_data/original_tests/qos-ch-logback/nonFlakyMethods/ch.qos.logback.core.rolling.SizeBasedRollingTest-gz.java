@Test public void gz() throws IOException, InterruptedException {
  expectedFilenameList.add(randomOutputDir + "a-sbr-gzed.log");
  expectedFilenameList.add(randomOutputDir + "sbr-gzed.0.gz");
  expectedFilenameList.add(randomOutputDir + "sbr-gzed.1.gz");
  generic("gzed","a-sbr-gzed.log","sbr-gzed.%i.gz",expectedFilenameList);
}
