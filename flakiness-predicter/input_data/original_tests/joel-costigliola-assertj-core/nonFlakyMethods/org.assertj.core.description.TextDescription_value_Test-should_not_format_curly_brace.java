@Test public void should_not_format_curly_brace(){
  TextDescription description=new TextDescription("{} Robin %s","Hood");
  assertEquals("{} Robin Hood",description.value());
}
