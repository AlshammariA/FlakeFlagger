@Test public void smoke() throws IOException, InterruptedException {
  expectedFilenameList.add(randomOutputDir + "a-sizeBased-smoke.log");
  expectedFilenameList.add(randomOutputDir + "sizeBased-smoke.0");
  expectedFilenameList.add(randomOutputDir + "sizeBased-smoke.1");
  generic("zipped","a-sizeBased-smoke.log","sizeBased-smoke.%i",expectedFilenameList);
}
