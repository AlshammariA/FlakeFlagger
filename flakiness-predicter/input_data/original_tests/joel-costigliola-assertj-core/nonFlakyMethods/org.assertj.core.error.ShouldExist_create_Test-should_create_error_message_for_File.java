@Test public void should_create_error_message_for_File(){
  factory=shouldExist(new FakeFile("xyz"));
  actualMessage=factory.create(description,representation);
  expectedMessage="[Test] \nExpecting file:\n  <xyz>\nto exist.";
  assertThat(actualMessage).isEqualTo(expectedMessage);
}
