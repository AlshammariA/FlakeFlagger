@Test public void should_delete_folder() throws IOException {
  FolderFixture dir3=new FolderFixture("dir_3");
  dir3.addFiles("file_3_1").addFiles("file_3_2").addFiles("file_3_2");
  dir3.addFolder("dir_3_1").addFiles("file_3_1_1").addFiles("file_3_1_2");
  File d=dir3.dir();
  String path=d.getCanonicalPath();
  Files.delete(d);
  assertFalse(new File(path).exists());
}
