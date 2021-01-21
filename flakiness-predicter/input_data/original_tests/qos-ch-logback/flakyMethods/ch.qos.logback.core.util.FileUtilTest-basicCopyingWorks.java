@Test public void basicCopyingWorks() throws IOException {
  String dir=CoreTestConstants.OUTPUT_DIR_PREFIX + "/fu" + diff;
  File dirFile=new File(dir);
  dirFile.mkdir();
  String src=CoreTestConstants.TEST_INPUT_PREFIX + "compress1.copy";
  String target=CoreTestConstants.OUTPUT_DIR_PREFIX + "/fu" + diff+ "/copyingWorks.txt";
  fileUtil.copy(src,target);
  Compare.compare(src,target);
}
