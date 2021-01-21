@Test public void withZipCompression_FileSet_NoRestart_7() throws Exception {
  generic("test7","toto.log",FIRST_PHASE_ONLY,".zip");
  List<String> zipFiles=filterElementsInListBySuffix(".zip");
  checkZipEntryMatchesZipFilename(zipFiles);
}
