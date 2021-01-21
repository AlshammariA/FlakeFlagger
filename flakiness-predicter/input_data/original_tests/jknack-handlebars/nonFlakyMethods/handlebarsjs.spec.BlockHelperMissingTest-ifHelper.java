@Test public void ifHelper() throws IOException {
  String string="{{#if goodbye}}GOODBYE {{/if}}cruel {{world}}!";
  shouldCompileTo(string,"{goodbye: true, world: world}","GOODBYE cruel world!","if with boolean argument shows the contents when true");
  shouldCompileTo(string,"{goodbye: dummy, world: world}","GOODBYE cruel world!","if with string argument shows the contents");
  shouldCompileTo(string,"{goodbye: false, world: world}","cruel world!","if with boolean argument does not show the contents when false");
  shouldCompileTo(string,"{world: world}","cruel world!","if with undefined does not show the contents");
  shouldCompileTo(string,$("goodbye",new Object[]{"foo"},"world","world"),"GOODBYE cruel world!","if with non-empty array shows the contents");
  shouldCompileTo(string,$("goodbye",new Object[0],"world","world"),"cruel world!","if with empty array does not show the contents");
}
