@Test public void predefOptionWithManyOptions() throws Exception {
  assertEquals("{\"predef\": ['YUI','window','document','OnlineOpinion','xui']}",optionsBuilder.build("predef=['YUI','window','document','OnlineOpinion','xui']"));
}
