@Test public void should_find_path_of_temporary_folder(){
  String a=Files.temporaryFolderPath();
  String e=append(separator).to(systemTemporaryFolder());
  assertEquals(e,a);
}
