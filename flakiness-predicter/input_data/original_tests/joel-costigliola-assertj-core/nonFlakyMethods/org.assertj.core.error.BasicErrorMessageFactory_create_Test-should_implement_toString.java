@Test public void should_implement_toString(){
  Description description=new TestDescription("Test");
  Representation representation=new StandardRepresentation();
  String formattedMessage="[Test] Hello Yoda";
  when(formatter.format(description,representation,"Hello %s","Yoda")).thenReturn(formattedMessage);
  assertEquals(formattedMessage,factory.create(description,representation));
}
