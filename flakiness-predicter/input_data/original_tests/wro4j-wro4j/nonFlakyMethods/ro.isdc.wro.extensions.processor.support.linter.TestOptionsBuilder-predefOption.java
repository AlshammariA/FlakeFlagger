@Test public void predefOption() throws Exception {
  assertEquals("{\"predef\": ['YUI']}",optionsBuilder.build("predef=['YUI']"));
}
