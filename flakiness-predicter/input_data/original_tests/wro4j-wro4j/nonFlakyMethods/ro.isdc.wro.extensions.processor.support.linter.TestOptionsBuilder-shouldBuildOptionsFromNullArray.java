@Test public void shouldBuildOptionsFromNullArray() throws Exception {
  final String[] options=null;
  assertEquals("{}",optionsBuilder.build(options));
}
