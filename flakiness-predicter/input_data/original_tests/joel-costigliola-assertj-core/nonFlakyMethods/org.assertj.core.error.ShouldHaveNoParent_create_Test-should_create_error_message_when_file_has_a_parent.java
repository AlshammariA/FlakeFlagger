@Test public void should_create_error_message_when_file_has_a_parent(){
  final File file=mock(File.class);
  final FakeFile parent=new FakeFile("unexpected.parent");
  when(file.getParentFile()).thenReturn(parent);
  String fileAbsolutePath="/path/to/file";
  when(file.getAbsolutePath()).thenReturn(fileAbsolutePath);
  factory=shouldHaveNoParent(file);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + FILE_HAS_PARENT,fileAbsolutePath,parent);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
