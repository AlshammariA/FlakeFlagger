@Test public void var3() throws IOException {
  assertEquals("hello {{{var}}}!",compile("hello {{{ var }}}!").text());
}
