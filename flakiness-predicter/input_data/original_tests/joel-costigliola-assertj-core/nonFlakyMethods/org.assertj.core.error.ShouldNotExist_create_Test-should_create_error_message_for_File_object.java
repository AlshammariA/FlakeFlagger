@Test public void should_create_error_message_for_File_object(){
  final FakeFile file=new FakeFile("xyz");
  factory=shouldNotExist(file);
  actualMessage=factory.create(description,representation);
  expectedMessage=String.format("[Test] " + FILE_SHOULD_NOT_EXIST,file);
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
