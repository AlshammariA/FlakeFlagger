@Test public void failed_rename() throws IOException {
  if (!EnvUtilForTests.isWindows())   return;
  FileOutputStream fos=null;
  try {
    String fileName=testId2FileName("failed_rename");
    File file=new File(fileName);
    file.getParentFile().mkdirs();
    fos=new FileOutputStream(fileName);
    String testId="failed_rename";
    rolloverChecker=new ZRolloverChecker(testId);
    genericTest(testId,"failed_rename","",FILE_OPTION_SET,NO_RESTART);
  }
  finally {
    StatusPrinter.print(context);
    if (fos != null)     fos.close();
  }
}
