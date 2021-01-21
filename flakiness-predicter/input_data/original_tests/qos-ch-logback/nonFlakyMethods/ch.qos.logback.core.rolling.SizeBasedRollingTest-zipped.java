@Test public void zipped() throws IOException, InterruptedException {
  expectedFilenameList.add(randomOutputDir + "a-sbr-zipped.log");
  expectedFilenameList.add(randomOutputDir + "sbr-zipped.0.zip");
  expectedFilenameList.add(randomOutputDir + "sbr-zipped.1.zip");
  generic("zipped","a-sbr-zipped.log","sbr-zipped.%i.zip",expectedFilenameList);
  List<String> zipFiles=filterElementsInListBySuffix(".zip");
  zipEntryNameCheck(zipFiles,"sbr-zipped.20\\d{2}-\\d{2}-\\d{2}_\\d{4}");
}
