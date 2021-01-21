@Test public void should_return_names_of_files_in_given_directory_and_its_subdirectories(){
  String path=concat("root",separator,"dir_1");
  assertThatContainsFiles(newArrayList("file_1_1","file_1_2","file_1_1_1"),Files.fileNamesIn(path,true));
}
