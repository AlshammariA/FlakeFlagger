@Test public void filesOnSameFolderShouldBeOnTheSameFileStore() throws RolloverFailure, IOException {
  if (!EnvUtil.isJDK7OrHigher())   return;
  File parent=new File(pathPrefix);
  File file=new File(pathPrefix + "filesOnSameFolderShouldBeOnTheSameFileStore");
  FileUtil.createMissingParentDirectories(file);
  file.createNewFile();
  assertTrue(FileStoreUtil.areOnSameFileStore(parent,file));
}
