@Test public void block() throws Exception {
  assertEquals("`*`#test`*`inside`*`/test`*`",compile("{{=`*` `*`=}}`*`#test`*`inside`*`/test`*`").text());
}
