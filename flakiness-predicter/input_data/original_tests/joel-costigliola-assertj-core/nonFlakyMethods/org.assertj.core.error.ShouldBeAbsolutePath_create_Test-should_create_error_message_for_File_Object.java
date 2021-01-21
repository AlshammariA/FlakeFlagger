@Test public void should_create_error_message_for_File_Object(){
  final FakeFile file=new FakeFile("xyz");
  factory=shouldBeAbsolutePath(file);
  actualMessage=factory.create(description,representation);
  assertThat(actualMessage).isEqualTo(format("[Test] " + SHOULD_BE_ABSOLUTE_PATH,file));
}
