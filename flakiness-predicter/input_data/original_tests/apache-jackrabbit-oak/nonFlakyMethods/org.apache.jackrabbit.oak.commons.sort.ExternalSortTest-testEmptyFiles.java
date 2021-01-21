@Test public void testEmptyFiles() throws Exception {
  File f1=File.createTempFile("tmp","unit");
  File f2=File.createTempFile("tmp","unit");
  ExternalSort.mergeSortedFiles(ExternalSort.sortInBatch(f1),f2);
  if (f2.length() != 0) {
    throw new RuntimeException("empty files should end up emtpy");
  }
}
