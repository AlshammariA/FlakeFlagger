@Test public void pathsWithHyphens() throws IOException {
  shouldCompileTo("{{foo-bar}}","{foo-bar: baz}","baz","Paths can contain hyphens (-)");
  shouldCompileTo("{{foo.foo-bar}}","{foo: {foo-bar: baz}}","baz","Paths can contain hyphens (-)");
  shouldCompileTo("{{foo/foo-bar}}","{foo: {foo-bar: baz}}","baz","Paths can contain hyphens (-)");
}
