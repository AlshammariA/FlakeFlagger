@Test public void renameToNonExistingDirectory() throws IOException, RolloverFailure {
  RenameUtil renameUtil=new RenameUtil();
  renameUtil.setContext(context);
  int diff2=RandomUtil.getPositiveInt();
  File fromFile=File.createTempFile("from" + diff,"test",randomOutputDir);
  String randomTARGETDir=CoreTestConstants.OUTPUT_DIR_PREFIX + diff2;
  renameUtil.rename(fromFile.toString(),new File(randomTARGETDir + "/to.test").toString());
  StatusPrinter.printInCaseOfErrorsOrWarnings(context);
  assertTrue(statusChecker.isErrorFree(0));
}
