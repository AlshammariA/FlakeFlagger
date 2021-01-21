@Test public void should_create_new_temporary_folder(){
  File f=null;
  try {
    f=Files.newTemporaryFolder();
    assertTrue(f.isDirectory());
  }
  finally {
    if (f != null)     f.delete();
  }
}
