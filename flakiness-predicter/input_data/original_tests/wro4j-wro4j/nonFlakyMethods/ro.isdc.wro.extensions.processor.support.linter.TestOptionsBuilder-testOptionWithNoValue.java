@Test public void testOptionWithNoValue() throws Exception {
  assertEquals("{\"devel\": true}",optionsBuilder.build("devel"));
}
